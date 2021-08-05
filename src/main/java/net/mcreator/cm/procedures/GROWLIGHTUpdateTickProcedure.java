package net.mcreator.cm.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.cm.block.Machineblock4Block;
import net.mcreator.cm.block.MachineBlock4OFFBlock;
import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@CmModElements.ModElement.Tag
public class GROWLIGHTUpdateTickProcedure extends CmModElements.ModElement {
	public GROWLIGHTUpdateTickProcedure(CmModElements instance) {
		super(instance, 124);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure GROWLIGHTUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure GROWLIGHTUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure GROWLIGHTUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure GROWLIGHTUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double LocalVAR = 0;
		if ((((CmModVariables.WorldVariables.get(world).Worldgrid) > 1)
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y - 3), (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock()))) {
			LocalVAR = (double) (new Object() {
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
					(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)))) - (LocalVAR));
			CmModVariables.WorldVariables.get(world).syncData(world);
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = Machineblock4Block.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		} else {
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				BlockState _bs = MachineBlock4OFFBlock.block.getDefaultState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
					if (_property != null && _bs.get(_property) != null)
						try {
							_bs = _bs.with(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
