package net.mcreator.cm.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.block.Machineblock4Block;
import net.mcreator.cm.block.MachineBlock4OFFBlock;
import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

@CmModElements.ModElement.Tag
public class VoltageSenseprocedureProcedure extends CmModElements.ModElement {
	public VoltageSenseprocedureProcedure(CmModElements instance) {
		super(instance, 93);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("direction") == null) {
			if (!dependencies.containsKey("direction"))
				CmMod.LOGGER.warn("Failed to load dependency direction for procedure VoltageSenseprocedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure VoltageSenseprocedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure VoltageSenseprocedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure VoltageSenseprocedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure VoltageSenseprocedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure VoltageSenseprocedure!");
			return;
		}
		Direction direction = (Direction) dependencies.get("direction");
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos((int) x, (int) y, (int) z))) || (new Object() {
			public boolean canExtractEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.canExtract()));
				return _retval.get();
			}
		}.canExtractEnergy(world, new BlockPos((int) x, (int) y, (int) z))))) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((((new Object() {
					public int getEnergyStored(IWorld world, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, direction).ifPresent(capability -> _retval.set(capability.getEnergyStored()));
						return _retval.get();
					}
				}.getEnergyStored(world, new BlockPos((int) x, (int) y, (int) z)))) + "" + ("/") + "" + ((new Object() {
					public int getMaxEnergyStored(IWorld world, BlockPos pos) {
						AtomicInteger _retval = new AtomicInteger(0);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null)
							_ent.getCapability(CapabilityEnergy.ENERGY, direction)
									.ifPresent(capability -> _retval.set(capability.getMaxEnergyStored()));
						return _retval.get();
					}
				}.getMaxEnergyStored(world, new BlockPos((int) x, (int) y, (int) z)))) + "" + (" energy at ") + "" + (direction))), (true));
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Machineblock4Block.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Yep, We got power."), (false));
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachineBlock4OFFBlock.block.getDefaultState()
				.getBlock())) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You need more power on the grid."), (false));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(
								(("You have  ") + "" + ((CmModVariables.WorldVariables.get(world).Worldgrid)) + "" + (" left on the energy Grid."))),
						(false));
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent((("Source: ") + "" + ("X ") + "" + ((CmModVariables.WorldVariables.get(world).GridX)) + ""
										+ ("  Y ") + "" + ((CmModVariables.WorldVariables.get(world).Gridy)) + "" + ("  Z ") + ""
										+ ((CmModVariables.WorldVariables.get(world).GridZ)))),
								(false));
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 10);
		}
	}
}
