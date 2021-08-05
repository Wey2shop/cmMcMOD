package net.mcreator.cm.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;
import java.util.HashMap;

@CmModElements.ModElement.Tag
public class SpawnnnpcProcedure extends CmModElements.ModElement {
	public SpawnnnpcProcedure(CmModElements instance) {
		super(instance, 130);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure Spawnnnpc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			SummonNPCProcedure.executeProcedure($_dependencies);
		}
	}
}
