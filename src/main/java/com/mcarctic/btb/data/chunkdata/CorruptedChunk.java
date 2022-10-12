package com.mcarctic.btb.data.chunkdata;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class CorruptedChunk {

    private final Map<BlockPos, BlockState> formerStates = new HashMap<>();

    public void addFormerState(BlockPos pos, BlockState state) {
        formerStates.put(pos, state);
    }

    public BlockState getAndRemoveFormerState(BlockPos pos) {
        if (!formerStates.containsKey(pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return formerStates.remove(pos);
    }

    public void saveNBTData(CompoundTag nbt) {
        var i = 0;
        for (var pos : formerStates.keySet()) {
            var tag = new CompoundTag();

            tag.put("pos", NbtUtils.writeBlockPos(pos));
            tag.put("state", NbtUtils.writeBlockState(formerStates.get(pos)));

            nbt.put("" + i, tag);
            i++;
        }
    }

    public void loadNBTData(CompoundTag nbt) {
        for (var key : nbt.getAllKeys()) {
            var tag = nbt.getCompound(key);
            formerStates.put(NbtUtils.readBlockPos(tag.getCompound("pos")), NbtUtils.readBlockState(tag.getCompound("state")));
        }
    }
}
