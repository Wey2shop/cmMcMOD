package net.mcreator.cm.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

@CmModElements.ModElement.Tag
public class FanscriptProcedure extends CmModElements.ModElement {
	public FanscriptProcedure(CmModElements instance) {
		super(instance, 97);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure Fanscript!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double energy = 0;
		if ((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
				(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))) {
			energy = (double) (new Object() {
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
							(int) ((CmModVariables.WorldVariables.get(world).Gridy) + 1), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
					(int) 1));
			energy = (double) (new Object() {
				public int receiveEnergySimulate(IWorld world, BlockPos pos, int _amount) {
					AtomicInteger _retval = new AtomicInteger(0);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN)
								.ifPresent(capability -> _retval.set(capability.receiveEnergy(_amount, true)));
					return _retval.get();
				}
			}.receiveEnergySimulate(
					world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
							(int) ((CmModVariables.WorldVariables.get(world).Gridy) + 1), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
					(int) (energy)));
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
						(int) ((CmModVariables.WorldVariables.get(world).Gridy) + 1), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
				int _amount = (int) (energy);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.extractEnergy(_amount, false));
			}
			{
				TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
						(int) ((CmModVariables.WorldVariables.get(world).Gridy) + 1), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
				int _amount = (int) (energy);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
			if (((new Object() {
				public boolean canExtractEnergy(IWorld world, BlockPos pos) {
					AtomicBoolean _retval = new AtomicBoolean(false);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null)
						_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.canExtract()));
					return _retval.get();
				}
			}.canExtractEnergy(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
					(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
					&& ((new Object() {
						public int getEnergyStored(IWorld world, BlockPos pos) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
							return _retval.get();
						}
					}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
							(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)))) > 0))) {
				energy = (double) (new Object() {
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
						(int) 1));
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
							(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
					int _amount = (int) 1;
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
						(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)))) - (energy));
				CmModVariables.WorldVariables.get(world).syncData(world);
			}
		}
	}
}
