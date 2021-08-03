package net.mcreator.cm.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@CmModElements.ModElement.Tag
public class FanblockCMRedstoneOnProcedure extends CmModElements.ModElement {
	public FanblockCMRedstoneOnProcedure(CmModElements instance) {
		super(instance, 111);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure FanblockCMRedstoneOn!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure FanblockCMRedstoneOn!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure FanblockCMRedstoneOn!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure FanblockCMRedstoneOn!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public int getEnergyStored(IWorld world, BlockPos pos) {
				AtomicInteger _retval = new AtomicInteger(0);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
				return _retval.get();
			}
		}.getEnergyStored(world, new BlockPos((int) x, (int) y, (int) z))) > (CmModVariables.WorldVariables.get(world).Worldgrid))) {
			CmModVariables.WorldVariables.get(world).GridX = (double) x;
			CmModVariables.WorldVariables.get(world).syncData(world);
			CmModVariables.WorldVariables.get(world).Gridy = (double) y;
			CmModVariables.WorldVariables.get(world).syncData(world);
			CmModVariables.WorldVariables.get(world).GridZ = (double) z;
			CmModVariables.WorldVariables.get(world).syncData(world);
			CmModVariables.WorldVariables.get(world).Worldgrid = (double) (new Object() {
				public int getEnergyStored(IWorld world, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos((int) x, (int) y, (int) z)));
			CmModVariables.WorldVariables.get(world).syncData(world);
			CmMod.LOGGER.info((("Changed Energy Source block") + "" + ("X") + "" + ((CmModVariables.WorldVariables.get(world).GridX)) + "" + ("/ Y")
					+ "" + ((CmModVariables.WorldVariables.get(world).Gridy)) + "" + ("/ Z") + ""
					+ ((CmModVariables.WorldVariables.get(world).GridZ))));
		}
	}
}
