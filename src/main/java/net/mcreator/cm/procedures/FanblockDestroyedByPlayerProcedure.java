package net.mcreator.cm.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class FanblockDestroyedByPlayerProcedure extends CmModElements.ModElement {
	public FanblockDestroyedByPlayerProcedure(CmModElements instance) {
		super(instance, 110);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure FanblockDestroyedByPlayer!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		CmModVariables.WorldVariables.get(world).Worldgrid = (double) 0;
		CmModVariables.WorldVariables.get(world).syncData(world);
	}
}
