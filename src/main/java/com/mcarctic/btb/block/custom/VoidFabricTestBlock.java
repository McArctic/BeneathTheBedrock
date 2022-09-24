package com.mcarctic.btb.block.custom;



import com.mcarctic.btb.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.*;


public class VoidFabricTestBlock extends Block {
    private final Random listRandomizer = new Random();

    private final ArrayList<Direction> staticList = getDirections();
    private final List<Direction> directionOrder = new ArrayList<>();
    private int infectionCounter = 0;
    public VoidFabricTestBlock() {
        super(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BLACK)
                .tickRandomly()
                .hardnessAndResistance(5f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .setRequiresTool()
                .hardnessAndResistance(5f)
                .sound(SoundType.CLOTH));

        List<Direction> clone = getDirections();
        for (int i = 0; i < staticList.size(); i++){
            Direction buffer = clone.get(listRandomizer.nextInt(clone.size()));
            directionOrder.add(buffer);
            clone.remove(buffer);
        }

    }
/*
    private static ArrayList<BlockPos> getPositionsToInfect(BlockPos blockpos, ServerWorld worldIn) {

        for(int x = -1; x < 2; x++) {

            for (int y = -1; y < 2; y++) {

              for (int z = -1; z < 2; z++) {
                  if(isReplaceable(worldIn.getBlockState(blockpos))) {
                      ArrayList<BlockPos> positions = new ArrayList<>();
                      positions.add(blockpos);
                      return positions;
                  }
            }
            }

        }

    }

 */


    private static ArrayList<Direction> getDirections() {
        ArrayList<Direction> output = new ArrayList<>();
        output.addAll(Arrays.asList( new Direction[]{
                Direction.UP,
                Direction.DOWN,
                Direction.EAST,
                Direction.WEST,
                Direction.NORTH,
                Direction.SOUTH}));
        return output;
    }

    private BlockPos getBlockPosToInfect(BlockPos pos){
        switch (directionOrder.get(infectionCounter)) {
            case UP:return pos.up();
            case DOWN:return pos.down();
            case EAST:return pos.east();
            case WEST:return pos.west();
            case NORTH:return pos.north();
            case SOUTH:return pos.south();
            default:throw new IllegalArgumentException();

       }
    }
    private static boolean isReplaceable(BlockState state) {
        return !state.matchesBlock(Blocks.AIR) && !state.matchesBlock(Blocks.BEDROCK) && !state.matchesBlock(ModBlocks.VOID_FABRIC_TEST.get()) && !state.matchesBlock(Blocks.WATER);
    }
    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            if (infectionCounter == staticList.size()) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                return;
            }
            BlockPos blockpos = getBlockPosToInfect(pos);
                if (isReplaceable(worldIn.getBlockState(blockpos))) {
                    worldIn.setBlockState(blockpos, ModBlocks.VOID_FABRIC_TEST.get().getDefaultState());
                }
                infectionCounter++;
    }



    /*
        @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (true)
        {
            if (!worldIn.isAreaLoaded(pos, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            BlockPos blockpos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                if (!worldIn.getBlockState(blockpos).matchesBlock(Blocks.AIR) && !worldIn.getBlockState(blockpos).matchesBlock(Blocks.BEDROCK) && !worldIn.getBlockState(blockpos).matchesBlock(ModBlocks.VOID_FABRIC_TEST.get())) {
                    worldIn.setBlockState(blockpos, ModBlocks.VOID_FABRIC_TEST.get().getDefaultState());
                }
                else {
                    worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                }
        }
     */

}