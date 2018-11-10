package net.lrsoft.phantomcraft2.worldgen;
import net.lrsoft.phantomcraft2.blocks.BlocksRegister;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import java.util.Random;
import cpw.mods.fml.common.IWorldGenerator;
public class WorldGenerator implements IWorldGenerator { 
	private WorldGenMinable normalore;
	private WorldGenMinable energyore;
	public WorldGenerator() {
	    normalore = new WorldGenMinable(BlocksRegister.normalore, 9);//Each chunk less than 10 blocks
	    energyore = new WorldGenMinable(BlocksRegister.energyore, 10);
	}
	private void runGenerator(WorldGenMinable normalore, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("LT_TEST:ERR_Height");
	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        normalore.generate(world, rand, x, y, z);
	    }
	}
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
	IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	  switch(world.provider.dimensionId) {
	   case -1: 
	     break;
	   case 0: 
		   this.runGenerator(this.normalore, world, random, chunkX, chunkZ, 20, 0, 70);
		   this.runGenerator(this.energyore, world, random, chunkX, chunkZ, 20, 0, 70);
		    break;
		   default:
	   }
	}
}


