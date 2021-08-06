package net.mcreator.cm.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class SummonNPCProcedure extends CmModElements.ModElement {
	public SummonNPCProcedure(CmModElements instance) {
		super(instance, 127);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure SummonNPC!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"summon villager ~30 ~1 ~30 {VillagerData:{profession:nitwit,level:4,type:snow},Invulnerable:1,PersistenceRequired:1,Offers:{Recipes:[{buy:{id:\"cm:buds\",Count:1},buyB:{id:paper,Count:1},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:1},{buy:{id:\"cm:hemp_seeds\",Count:64},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:64},{buy:{id:\"cm:hemp_seeds\",Count:64},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:64},{buy:{id:\"cm:buds\",Count:1},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:1},{buy:{id:\"cm:hemp_seeds\",Count:64},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:1},{buy:{id:\"cm:buds\",Count:64},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:1},{buy:{id:\"cm:hemp_seeds\",Count:64},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:1},{buy:{id:\"cm:hemp_seeds\",Count:64},sell:{id:emerald,Count:1},rewardExp:0b,maxUses:1}]}}");
			}
		}
	}
}
