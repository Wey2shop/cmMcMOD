package net.mcreator.cm.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class TempleSpawnAdditionalGenerationConditionProcedure extends CmModElements.ModElement {
	public TempleSpawnAdditionalGenerationConditionProcedure(CmModElements instance) {
		super(instance, 126);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure TempleSpawnAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure TempleSpawnAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure TempleSpawnAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure TempleSpawnAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z)).isSolid()) == (true)) && (((world
				.getBlockState(new BlockPos((int) (x - 6), (int) (y - 1), (int) z)).isSolid()) == (true))
				&& (((world.getBlockState(new BlockPos((int) (x - 6), (int) (y - 1), (int) (z - 6))).isSolid()) == (true)) && (((world
						.getBlockState(new BlockPos((int) (x - 6), (int) (y - 1), (int) (z - 6))).isSolid()) == (true))
						&& (((world.getBlockState(new BlockPos((int) (x - 5), (int) (y - 1), (int) (z - 5))).isSolid()) == (true)) && (((world
								.getBlockState(new BlockPos((int) (x - 4), (int) (y - 1), (int) (z - 4))).isSolid()) == (true))
								&& (((world.getBlockState(new BlockPos((int) (x - 3), (int) (y - 1), (int) (z - 3))).isSolid()) == (true)) && (((world
										.getBlockState(new BlockPos((int) (x - 2), (int) (y - 1), (int) (z - 2))).isSolid()) == (true))
										&& (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y - 1), (int) (z + 2))).isSolid()) == (true))
												&& (((world.getBlockState(new BlockPos((int) (x + 3), (int) (y - 1), (int) (z + 3)))
														.isSolid()) == (true))
														&& (((world.getBlockState(new BlockPos((int) (x + 4), (int) (y - 1), (int) (z + 4)))
																.isSolid()) == (true))
																&& (((world.getBlockState(new BlockPos((int) (x + 5), (int) (y - 1), (int) (z + 5)))
																		.isSolid()) == (true))
																		&& (((world
																				.getBlockState(
																						new BlockPos((int) (x + 6), (int) (y - 1), (int) (z + 6)))
																				.isSolid()) == (true))
																				&& (world.getBlockState(
																						new BlockPos((int) (x + 7), (int) (y - 1), (int) (z + 7)))
																						.isSolid()))))))))))))))) {
			return (true);
		}
		return (false);
	}
}
