package net.mcreator.cm.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;
import java.util.Collections;

@CmModElements.ModElement.Tag
public class HomeProcedureProcedure extends CmModElements.ModElement {
	public HomeProcedureProcedure(CmModElements instance) {
		super(instance, 55);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure HomeProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CmModVariables.PlayerVariables())).has_home) == 0)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You have not set a home yet."), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Teleporting home..."), (false));
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(
						((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CmModVariables.PlayerVariables())).home_x),
						((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CmModVariables.PlayerVariables())).home_y),
						((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new CmModVariables.PlayerVariables())).home_z));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(
							((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new CmModVariables.PlayerVariables())).home_x),
							((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new CmModVariables.PlayerVariables())).home_y),
							((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new CmModVariables.PlayerVariables())).home_z),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		}
	}
}
