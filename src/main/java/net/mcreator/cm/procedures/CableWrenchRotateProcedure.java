package net.mcreator.cm.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class CableWrenchRotateProcedure extends CmModElements.ModElement {
	public CableWrenchRotateProcedure(CmModElements instance) {
		super(instance, 103);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				CmMod.LOGGER.warn("Failed to load dependency direction for procedure CableWrenchRotate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure CableWrenchRotate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure CableWrenchRotate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure CableWrenchRotate!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure CableWrenchRotate!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		try {
			BlockState _bs = world.getBlockState(new BlockPos((int) x, (int) y, (int) z));
			DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (_property != null) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
						_bs.with(_property, (direction.getAxis().isVertical() ? direction : direction.rotateY())), 3);
			} else {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
						_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"),
								(direction.getAxis().isVertical() ? direction : direction.rotateY()).getAxis()),
						3);
			}
		} catch (Exception e) {
		}
	}
}
