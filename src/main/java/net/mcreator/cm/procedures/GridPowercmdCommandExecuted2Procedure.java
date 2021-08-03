package net.mcreator.cm.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
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
		double local2 = 0;
		if (((new Object() {
			public boolean canExtractEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.canExtract()));
				return _retval.get();
			}
		}.canExtractEnergy(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
				(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)))) && ((new Object() {
					public int getEnergyStored(IWorld world, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
						(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)))) >= 0))) {
			local2 = (double) (new Object() {
				public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null)
								.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
					return _retval.get();
				}
			}.extractEnergySimulate(
					world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
							(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
					(int) 100));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
						(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
				int _amount = (int) (local2);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			CmModVariables.WorldVariables.get(world).Worldgrid = (double) ((new Object() {
				public int getEnergyStored(IWorld world, BlockPos pos) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
					return _retval.get();
				}
			}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
					(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)))) - (local2));
			CmModVariables.WorldVariables.get(world).syncData(world);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity)
						.sendStatusMessage(
								new StringTextComponent((("You Used 100 Grid Power. You have ") + ""
										+ (((CmModVariables.WorldVariables.get(world).Worldgrid) + 0)) + "" + (" Energy left on your grid."))),
								(false));
			}
		}
	}
}
