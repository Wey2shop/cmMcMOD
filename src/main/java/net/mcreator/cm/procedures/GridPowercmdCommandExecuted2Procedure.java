package net.mcreator.cm.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class GridPowercmdCommandExecuted2Procedure extends CmModElements.ModElement {
	public GridPowercmdCommandExecuted2Procedure(CmModElements instance) {
		super(instance, 106);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure GridPowercmdCommandExecuted2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure GridPowercmdCommandExecuted2!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		CmModVariables.WorldVariables.get(world).Worldgrid = (double) ((CmModVariables.WorldVariables.get(world).Worldgrid) - 100);
		CmModVariables.WorldVariables.get(world).syncData(world);
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You Used 100 Grid Power. You have ") + ""
					+ (((CmModVariables.WorldVariables.get(world).Worldgrid) + 100)) + "" + (" Energy left on your grid."))), (true));
		}
	}
}
