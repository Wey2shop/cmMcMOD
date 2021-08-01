package net.mcreator.cm.procedures;

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
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) (((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new CmModVariables.PlayerVariables())).GridPower) - 100);
			entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.GridPower = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(
					new StringTextComponent((("You Used 100 Grid Power. You have ") + ""
							+ ((((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new CmModVariables.PlayerVariables())).GridPower) + 100))
							+ "" + (" Energy left on your grid."))),
					(true));
		}
	}
}
