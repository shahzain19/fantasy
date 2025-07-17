package net.shyn.wandswonders.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.shyn.wandswonders.block.ModBlocks;

import java.util.*;

public class ShipControllerBlock extends Block {
    public static final Map<World, Set<BlockPos>> activeControllers = new HashMap<>();

    public ShipControllerBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        Set<BlockPos> controllers = activeControllers.computeIfAbsent(world, w -> new HashSet<>());

        if (controllers.contains(pos)) {
            controllers.remove(pos);
            player.sendMessage(Text.literal("🛑 Ship auto-movement stopped."), false);
        } else {
            controllers.add(pos);
            player.sendMessage(Text.literal("✅ Ship auto-movement started."), false);
        }

        return ActionResult.SUCCESS;
    }

    public static void tick(World world) {
        if (world.isClient || !activeControllers.containsKey(world)) return;

        Set<BlockPos> controllers = new HashSet<>(activeControllers.get(world));

        for (BlockPos controllerPos : controllers) {
            if (!world.getBlockState(controllerPos).isOf(ModBlocks.SHIP_CONTROLLER)) continue;

            Direction moveDir = Direction.SOUTH;

            Set<BlockPos> visited = new HashSet<>();
            Queue<BlockPos> toVisit = new LinkedList<>();
            toVisit.add(controllerPos);
            visited.add(controllerPos);

            Map<BlockPos, BlockState> oldStates = new HashMap<>();

            // Find connected blocks
            while (!toVisit.isEmpty()) {
                BlockPos current = toVisit.poll();
                BlockState state = world.getBlockState(current);

                oldStates.put(current, state);

                for (Direction dir : Direction.values()) {
                    BlockPos neighbor = current.offset(dir);
                    if (!visited.contains(neighbor)) {
                        BlockState neighborState = world.getBlockState(neighbor);
                        if (!neighborState.isAir() && !neighborState.isOf(ModBlocks.SHIP_CONTROLLER)) {
                            visited.add(neighbor);
                            toVisit.add(neighbor);
                        }
                    }
                }
            }

            // Sort to avoid overlap
            List<BlockPos> ordered = new ArrayList<>(oldStates.keySet());
            ordered.sort(Comparator
                    .comparingInt(BlockPos::getY)
                    .thenComparingInt(BlockPos::getZ)
                    .thenComparingInt(BlockPos::getX)
                    .reversed()
            );

            // Destroy old blocks
            for (BlockPos oldPos : ordered) {
                world.setBlockState(oldPos, net.minecraft.block.Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
            }

            // Place blocks in new position
            for (BlockPos oldPos : ordered) {
                BlockPos newPos = oldPos.offset(moveDir);
                BlockState state = oldStates.get(oldPos);
                world.setBlockState(newPos, state, Block.NOTIFY_ALL);
            }

            // Move nearby players
            for (PlayerEntity player : world.getPlayers()) {
                BlockPos playerPos = player.getBlockPos();
                for (BlockPos movedBlock : visited) {
                    if (playerPos.isWithinDistance(movedBlock, 1.5)) {
                        player.requestTeleport(
                                player.getX() + moveDir.getOffsetX(),
                                player.getY(),
                                player.getZ() + moveDir.getOffsetZ()
                        );
                        break;
                    }
                }

            }
        }
    }
}
