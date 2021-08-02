package net.mcreator.cm.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class FanblockCMOnBlockRightClickedProcedure extends CmModElements.ModElement {
	public FanblockCMOnBlockRightClickedProcedure(CmModElements instance) {
		super(instance, 109);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure FanblockCMOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new CmModVariables.PlayerVariables())).GridPower) < 10000000)) {
			{
				double _setval = (double) (((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new CmModVariables.PlayerVariables())).GridPower) + 10);
				entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.GridPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
