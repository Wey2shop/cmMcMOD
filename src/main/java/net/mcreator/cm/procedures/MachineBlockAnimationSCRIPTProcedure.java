package net.mcreator.cm.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.Property;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.cm.item.Tin_OreIngotItem;
import net.mcreator.cm.item.TinPressedplateItem;
import net.mcreator.cm.item.IronPressedplateItem;
import net.mcreator.cm.item.GoldPressedplateItem;
import net.mcreator.cm.item.Copper_OreIngotItem;
import net.mcreator.cm.item.CopperPressedplateItem;
import net.mcreator.cm.item.BronzePressedplateItem;
import net.mcreator.cm.item.BronzeItem;
import net.mcreator.cm.item.AluminumPressedplateItem;
import net.mcreator.cm.item.Aluminium_OreIngotItem;
import net.mcreator.cm.block.MachinePressLIDBlock;
import net.mcreator.cm.block.MachinePressBlock;
import net.mcreator.cm.block.MachinePressAnimation3Block;
import net.mcreator.cm.block.MachinePressAnimation2Block;
import net.mcreator.cm.block.MachinePressAnimation1Block;
import net.mcreator.cm.block.MachineBaseBlock;
import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@CmModElements.ModElement.Tag
public class MachineBlockAnimationSCRIPTProcedure extends CmModElements.ModElement {
	public MachineBlockAnimationSCRIPTProcedure(CmModElements instance) {
		super(instance, 73);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure MachineBlockAnimationSCRIPT!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure MachineBlockAnimationSCRIPT!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure MachineBlockAnimationSCRIPT!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure MachineBlockAnimationSCRIPT!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure MachineBlockAnimationSCRIPT!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double LocalVAR = 0;
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == MachineBaseBlock.block.getDefaultState().getBlock())
				&& ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == MachinePressLIDBlock.block.getDefaultState()
						.getBlock()))) {
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachinePressBlock.block.getDefaultState().getBlock())
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(BronzeItem.block, (int) (1)).getItem()))) {
				if (((CmModVariables.WorldVariables.get(world).Worldgrid) > 500)) {
					LocalVAR = (double) (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
							(int) 500));
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
						int _amount = (int) 500;
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
					}.getEnergyStored(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
							- (LocalVAR));
					CmModVariables.WorldVariables.get(world).syncData(world);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Removing 1 bronze ingot From Stack"), (false));
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
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
							{
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bso, _bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("2"), (false));
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
									{
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										BlockState _bs = MachinePressAnimation3Block.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										TileEntity _te = world.getTileEntity(_bp);
										CompoundNBT _bnbt = null;
										if (_te != null) {
											_bnbt = _te.write(new CompoundNBT());
											_te.remove();
										}
										world.setBlockState(_bp, _bs, 3);
										if (_bnbt != null) {
											_te = world.getTileEntity(_bp);
											if (_te != null) {
												try {
													_te.read(_bso, _bnbt);
												} catch (Exception ignored) {
												}
											}
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3"), (false));
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("4"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("5"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("6"), (false));
											}
											if (entity instanceof PlayerEntity) {
												ItemStack _setstack = new ItemStack(BronzePressedplateItem.block, (int) (1));
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You need ") + "" + (((new Object() {
							public int getEnergyStored(IWorld world, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
								- 500)) + "" + ("- More grid power"))), (true));
					}
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachinePressBlock.block.getDefaultState()
					.getBlock())
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Copper_OreIngotItem.block, (int) (1)).getItem()))) {
				if (((CmModVariables.WorldVariables.get(world).Worldgrid) > 500)) {
					LocalVAR = (double) (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
							(int) 500));
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
						int _amount = (int) 500;
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
					}.getEnergyStored(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
							- (LocalVAR));
					CmModVariables.WorldVariables.get(world).syncData(world);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Removing 1 copper ingot From Stack"), (false));
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
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
							{
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bso, _bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("2"), (false));
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
									{
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										BlockState _bs = MachinePressAnimation3Block.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										TileEntity _te = world.getTileEntity(_bp);
										CompoundNBT _bnbt = null;
										if (_te != null) {
											_bnbt = _te.write(new CompoundNBT());
											_te.remove();
										}
										world.setBlockState(_bp, _bs, 3);
										if (_bnbt != null) {
											_te = world.getTileEntity(_bp);
											if (_te != null) {
												try {
													_te.read(_bso, _bnbt);
												} catch (Exception ignored) {
												}
											}
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3"), (false));
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("4"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("5"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("6"), (false));
											}
											if (entity instanceof PlayerEntity) {
												ItemStack _setstack = new ItemStack(CopperPressedplateItem.block, (int) (1));
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You need ") + "" + (((new Object() {
							public int getEnergyStored(IWorld world, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
								- 500)) + "" + ("- More grid power"))), (true));
					}
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachinePressBlock.block.getDefaultState()
					.getBlock())
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Aluminium_OreIngotItem.block, (int) (1)).getItem()))) {
				if (((CmModVariables.WorldVariables.get(world).Worldgrid) > 500)) {
					LocalVAR = (double) (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
							(int) 500));
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
						int _amount = (int) 500;
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
					}.getEnergyStored(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
							- (LocalVAR));
					CmModVariables.WorldVariables.get(world).syncData(world);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Removing 1 aluminium ingot From Stack"), (false));
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
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
							{
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bso, _bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("2"), (false));
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
									{
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										BlockState _bs = MachinePressAnimation3Block.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										TileEntity _te = world.getTileEntity(_bp);
										CompoundNBT _bnbt = null;
										if (_te != null) {
											_bnbt = _te.write(new CompoundNBT());
											_te.remove();
										}
										world.setBlockState(_bp, _bs, 3);
										if (_bnbt != null) {
											_te = world.getTileEntity(_bp);
											if (_te != null) {
												try {
													_te.read(_bso, _bnbt);
												} catch (Exception ignored) {
												}
											}
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3"), (false));
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("4"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("5"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("6"), (false));
											}
											if (entity instanceof PlayerEntity) {
												ItemStack _setstack = new ItemStack(AluminumPressedplateItem.block, (int) (1));
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You need ") + "" + (((new Object() {
							public int getEnergyStored(IWorld world, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
								- 500)) + "" + ("- More grid power"))), (true));
					}
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachinePressBlock.block.getDefaultState()
					.getBlock())
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Tin_OreIngotItem.block, (int) (1)).getItem()))) {
				if (((CmModVariables.WorldVariables.get(world).Worldgrid) > 500)) {
					LocalVAR = (double) (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
							(int) 500));
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
						int _amount = (int) 500;
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
					}.getEnergyStored(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
							- (LocalVAR));
					CmModVariables.WorldVariables.get(world).syncData(world);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Removing 1 Tin ingot From Stack"), (false));
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
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
							{
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bso, _bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("2"), (false));
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
									{
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										BlockState _bs = MachinePressAnimation3Block.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										TileEntity _te = world.getTileEntity(_bp);
										CompoundNBT _bnbt = null;
										if (_te != null) {
											_bnbt = _te.write(new CompoundNBT());
											_te.remove();
										}
										world.setBlockState(_bp, _bs, 3);
										if (_bnbt != null) {
											_te = world.getTileEntity(_bp);
											if (_te != null) {
												try {
													_te.read(_bso, _bnbt);
												} catch (Exception ignored) {
												}
											}
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3"), (false));
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("4"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("5"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("6"), (false));
											}
											if (entity instanceof PlayerEntity) {
												ItemStack _setstack = new ItemStack(TinPressedplateItem.block, (int) (1));
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You need ") + "" + (((new Object() {
							public int getEnergyStored(IWorld world, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
								- 500)) + "" + ("- More grid power"))), (true));
					}
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachinePressBlock.block.getDefaultState()
					.getBlock())
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Items.IRON_INGOT, (int) (1)).getItem()))) {
				if (((CmModVariables.WorldVariables.get(world).Worldgrid) > 500)) {
					LocalVAR = (double) (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
							(int) 500));
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
						int _amount = (int) 500;
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
					}.getEnergyStored(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
							- (LocalVAR));
					CmModVariables.WorldVariables.get(world).syncData(world);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Removing 1 Iron ingot From Stack"), (false));
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
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
							{
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bso, _bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("2"), (false));
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
									{
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										BlockState _bs = MachinePressAnimation3Block.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										TileEntity _te = world.getTileEntity(_bp);
										CompoundNBT _bnbt = null;
										if (_te != null) {
											_bnbt = _te.write(new CompoundNBT());
											_te.remove();
										}
										world.setBlockState(_bp, _bs, 3);
										if (_bnbt != null) {
											_te = world.getTileEntity(_bp);
											if (_te != null) {
												try {
													_te.read(_bso, _bnbt);
												} catch (Exception ignored) {
												}
											}
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3"), (false));
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("4"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("5"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("6"), (false));
											}
											if (entity instanceof PlayerEntity) {
												ItemStack _setstack = new ItemStack(IronPressedplateItem.block, (int) (1));
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You need ") + "" + (((new Object() {
							public int getEnergyStored(IWorld world, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
								- 500)) + "" + ("- More grid power"))), (true));
					}
				}
			} else if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == MachinePressBlock.block.getDefaultState()
					.getBlock())
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(Items.GOLD_INGOT, (int) (1)).getItem()))) {
				if (((CmModVariables.WorldVariables.get(world).Worldgrid) > 500)) {
					LocalVAR = (double) (new Object() {
						public int extractEnergySimulate(IWorld world, BlockPos pos, int _amount) {
							AtomicInteger _retval = new AtomicInteger(0);
							TileEntity _ent = world.getTileEntity(pos);
							if (_ent != null)
								_ent.getCapability(CapabilityEnergy.ENERGY, null)
										.ifPresent(capability -> _retval.set(capability.extractEnergy(_amount, true)));
							return _retval.get();
						}
					}.extractEnergySimulate(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)),
							(int) 500));
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ)));
						int _amount = (int) 500;
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
					}.getEnergyStored(world,
							new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
									(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
							- (LocalVAR));
					CmModVariables.WorldVariables.get(world).syncData(world);
					(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)).shrink((int) 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Removing 1 Gold ingot From Stack"), (false));
					}
					{
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
						BlockState _bso = world.getBlockState(_bp);
						for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
							Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
							if (_property != null && _bs.get(_property) != null)
								try {
									_bs = _bs.with(_property, (Comparable) entry.getValue());
								} catch (Exception e) {
								}
						}
						TileEntity _te = world.getTileEntity(_bp);
						CompoundNBT _bnbt = null;
						if (_te != null) {
							_bnbt = _te.write(new CompoundNBT());
							_te.remove();
						}
						world.setBlockState(_bp, _bs, 3);
						if (_bnbt != null) {
							_te = world.getTileEntity(_bp);
							if (_te != null) {
								try {
									_te.read(_bso, _bnbt);
								} catch (Exception ignored) {
								}
							}
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("1"), (false));
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
							{
								BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
								BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
								BlockState _bso = world.getBlockState(_bp);
								for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
									Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
									if (_property != null && _bs.get(_property) != null)
										try {
											_bs = _bs.with(_property, (Comparable) entry.getValue());
										} catch (Exception e) {
										}
								}
								TileEntity _te = world.getTileEntity(_bp);
								CompoundNBT _bnbt = null;
								if (_te != null) {
									_bnbt = _te.write(new CompoundNBT());
									_te.remove();
								}
								world.setBlockState(_bp, _bs, 3);
								if (_bnbt != null) {
									_te = world.getTileEntity(_bp);
									if (_te != null) {
										try {
											_te.read(_bso, _bnbt);
										} catch (Exception ignored) {
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("2"), (false));
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
									{
										BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
										BlockState _bs = MachinePressAnimation3Block.block.getDefaultState();
										BlockState _bso = world.getBlockState(_bp);
										for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
											Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
											if (_property != null && _bs.get(_property) != null)
												try {
													_bs = _bs.with(_property, (Comparable) entry.getValue());
												} catch (Exception e) {
												}
										}
										TileEntity _te = world.getTileEntity(_bp);
										CompoundNBT _bnbt = null;
										if (_te != null) {
											_bnbt = _te.write(new CompoundNBT());
											_te.remove();
										}
										world.setBlockState(_bp, _bs, 3);
										if (_bnbt != null) {
											_te = world.getTileEntity(_bp);
											if (_te != null) {
												try {
													_te.read(_bso, _bnbt);
												} catch (Exception ignored) {
												}
											}
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("3"), (false));
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation2Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("4"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressAnimation1Block.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("5"), (false));
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
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
											{
												BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
												BlockState _bs = MachinePressBlock.block.getDefaultState();
												BlockState _bso = world.getBlockState(_bp);
												for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
													Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
													if (_property != null && _bs.get(_property) != null)
														try {
															_bs = _bs.with(_property, (Comparable) entry.getValue());
														} catch (Exception e) {
														}
												}
												TileEntity _te = world.getTileEntity(_bp);
												CompoundNBT _bnbt = null;
												if (_te != null) {
													_bnbt = _te.write(new CompoundNBT());
													_te.remove();
												}
												world.setBlockState(_bp, _bs, 3);
												if (_bnbt != null) {
													_te = world.getTileEntity(_bp);
													if (_te != null) {
														try {
															_te.read(_bso, _bnbt);
														} catch (Exception ignored) {
														}
													}
												}
											}
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("6"), (false));
											}
											if (entity instanceof PlayerEntity) {
												ItemStack _setstack = new ItemStack(GoldPressedplateItem.block, (int) (1));
												_setstack.setCount((int) 1);
												ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
				} else {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("You need ") + "" + (((new Object() {
							public int getEnergyStored(IWorld world, BlockPos pos) {
								AtomicInteger _retval = new AtomicInteger(0);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null)
									_ent.getCapability(CapabilityEnergy.ENERGY, null)
											.ifPresent(capability -> _retval.set(capability.getEnergyStored()));
								return _retval.get();
							}
						}.getEnergyStored(world, new BlockPos((int) (CmModVariables.WorldVariables.get(world).GridX),
								(int) (CmModVariables.WorldVariables.get(world).Gridy), (int) (CmModVariables.WorldVariables.get(world).GridZ))))
								- 500)) + "" + ("- More grid power"))), (true));
					}
				}
			}
		}
	}
}
