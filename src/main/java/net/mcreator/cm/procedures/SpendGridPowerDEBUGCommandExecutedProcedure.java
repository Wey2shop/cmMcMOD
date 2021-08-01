package net.mcreator.cm.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class SpendGridPowerDEBUGCommandExecutedProcedure extends CmModElements.ModElement {
	public SpendGridPowerDEBUGCommandExecutedProcedure(CmModElements instance) {
		super(instance, 104);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure SpendGridPowerDEBUGCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity)
					.sendStatusMessage(
							new StringTextComponent((("You have got ") + ""
									+ (((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new CmModVariables.PlayerVariables())).GridPower))
									+ "" + (" Energy left on your grid."))),
							(true));
		}
	}
}
