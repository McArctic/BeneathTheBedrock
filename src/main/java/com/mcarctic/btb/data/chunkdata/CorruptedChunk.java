package com.mcarctic.btb.data.chunkdata;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class CorruptedChunk {

    private final Map<BlockPos, BlockState> formerStates = new HashMap<>();

    private boolean cleaned = false;

    public void addFormerState(BlockPos pos, BlockState state) {
        formerStates.put(pos, state);
    }

    public BlockState getAndRemoveFormerState(BlockPos pos) {
        if (!formerStates.containsKey(pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return formerStates.remove(pos);
    }

    public boolean isCleaned() {
        return cleaned;
    }

    public void setCleaned(boolean cleaned) {
        this.cleaned = cleaned;
    }

    public void saveNBTData(CompoundTag nbt) {
        var list = new ListTag();

        for (var pos : formerStates.keySet()) {
            var tag = new CompoundTag();

            tag.put("pos", NbtUtils.writeBlockPos(pos));
            tag.put("state", NbtUtils.writeBlockState(formerStates.get(pos)));

            list.add(tag);
        }
        nbt.put("states", list);
        nbt.putBoolean("cleaned", cleaned);
    }

    public void loadNBTData(CompoundTag nbt) {
        for (var element : nbt.getList("states", 10)) {
            if (element instanceof CompoundTag compound) {
                formerStates.put(NbtUtils.readBlockPos(compound.getCompound("pos")), NbtUtils.readBlockState(compound.getCompound("state")));
            }
        }

        cleaned = nbt.getBoolean("cleaned");
    }
}
