package com.mcarctic.btb.world.structure.structures;

public class VoidRemnantStructure {
} /*extends Structure<NoFeatureConfig> {
    public VoidRemnantStructure() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public GenerationStage.Decoration getDecorationStage() {
        return GenerationStage.Decoration.STRONGHOLDS;
    }
    @Override
    protected boolean func_230363_a_(ChunkGenerator chunkGenerator, BiomeProvider biomeSource,
                                     long seed, SharedSeedRandom chunkRandom, int chunkX, int chunkZ,
                                     Biome biome, ChunkPos chunkPos, NoFeatureConfig featureConfig) {
        BlockPos centerOfChunk = new BlockPos(
                (chunkX << 4) + 7,
                 0, //0
                (chunkZ << 4) + 7);
        int landHeight = chunkGenerator.getHeight(centerOfChunk.getX(), centerOfChunk.getZ(),
                Heightmap.Type.WORLD_SURFACE_WG);

        IBlockReader columnOfBlocks = chunkGenerator.func_230348_a_(centerOfChunk.getX(), centerOfChunk.getZ());
        BlockState topBlock = columnOfBlocks.getBlockState(centerOfChunk.up(landHeight));

        return topBlock.getFluidState().isEmpty();
    }

    @Override
    public IStartFactory<NoFeatureConfig> getStartFactory() {
        return VoidRemnantStructure.Start::new;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> structureIn, int chunkX, int chunkZ,
                     MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
            super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
        }

        @Override //generatePieces
        public void func_230364_a_(DynamicRegistries dynamicRegistryManager, ChunkGenerator chunkGenerator,
                                   TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn,
                                   NoFeatureConfig config) {
            //turns chuck cords to real cords
            int x = (chunkX << 4) + 7;
            int z = (chunkZ << 4) + 7;
            int min = -20;
            int max = -58;
            // DEFAULT 0 Math.floor(Math.random()*(max-min+1)+min)
            BlockPos blockpos = new BlockPos(x, 0, z);

            //addpieces()
            JigsawManager.func_242837_a(dynamicRegistryManager,
                    new VillageConfig(() -> dynamicRegistryManager.getRegistry(Registry.JIGSAW_POOL_KEY)
                            .getOrDefault(new ResourceLocation(BeneathTheBedrock.MOD_ID, "void_remnant/start_pool")),
                            10), AbstractVillagePiece::new, chunkGenerator, templateManagerIn,
                    blockpos, this.components, this.rand,false,true);


            this.components.forEach(piece -> piece.offset(0, 1, 0));
            this.components.forEach(piece -> piece.getBoundingBox().minY -= 1);

            this.recalculateStructureSize();

            LogManager.getLogger().log(Level.DEBUG, "House at " +
                    this.components.get(0).getBoundingBox().minX + " " +
                    this.components.get(0).getBoundingBox().minY + " " +
                    this.components.get(0).getBoundingBox().minZ);

        }
    }
}*/ //TODO Generation