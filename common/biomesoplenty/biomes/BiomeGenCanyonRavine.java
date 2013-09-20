package biomesoplenty.biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import biomesoplenty.api.Blocks;
import biomesoplenty.worldgen.WorldGenCanyonShrub;
import biomesoplenty.worldgen.tree.WorldGenPineTree;

public class BiomeGenCanyonRavine extends BiomeGenBase
{
	private BiomeDecoratorBOP customBiomeDecorator;

	public BiomeGenCanyonRavine(int par1)
	{
		super(par1);
		spawnableCreatureList.clear();
		theBiomeDecorator = new BiomeDecoratorBOP(this);
		customBiomeDecorator = (BiomeDecoratorBOP)theBiomeDecorator;
		topBlock = (byte)Blocks.hardDirt.get().blockID;
		fillerBlock = (byte)Blocks.hardDirt.get().blockID;
		customBiomeDecorator.treesPerChunk = 4;
		customBiomeDecorator.flowersPerChunk = -999;
		customBiomeDecorator.canyonGrassPerChunk = 3;
		customBiomeDecorator.aloePerChunk = 2;
		customBiomeDecorator.generatePumpkins = false;
		customBiomeDecorator.generateCanyon = true;
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
	{
		return par1Random.nextInt(9) == 0 ? new WorldGenPineTree() : new WorldGenCanyonShrub(0,0);
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		super.decorate(par1World, par2Random, par3, par4);
		int var5 = 12 + par2Random.nextInt(6);

		for (int var6 = 0; var6 < var5; ++var6)
		{
			int var7 = par3 + par2Random.nextInt(16);
			int var8 = par2Random.nextInt(28) + 4;
			int var9 = par4 + par2Random.nextInt(16);
			int var10 = par1World.getBlockId(var7, var8, var9);

			Block block = Block.blocksList[var10]; 
			if (block != null && block.isGenMineableReplaceable(par1World, var7, var8, var9, Block.stone.blockID))
			{
				par1World.setBlock(var7, var8, var9, Blocks.amethystOre.get().blockID, 2, 2);
			}
		}
	}

	/**
	 * Provides the basic foliage color based on the biome temperature and rainfall
	 */
	@Override
	public int getBiomeFoliageColor()
	{
		return 11123300;
	}

	/**
	 * Provides the basic foliage color based on the biome temperature and rainfall
	 */
	@Override
	public int getBiomeGrassColor()
	{
		return 11123300;
	}
}