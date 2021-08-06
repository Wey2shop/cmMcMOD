package net.mcreator.cm.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.item.BurnerphoneItem;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.Map;

@CmModElements.ModElement.Tag
public class BurnerphoneRightClickedOnBlockProcedure extends CmModElements.ModElement {
	public BurnerphoneRightClickedOnBlockProcedure(CmModElements instance) {
		super(instance, 131);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure BurnerphoneRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure BurnerphoneRightClickedOnBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Connecting.."), (true));
		}
		if ((Math.random() < 0.7)) {
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
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hello."), (true));
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
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Meet me around the block."), (true));
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
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											_ent.world.getServer().getCommandManager()
													.handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4), "spawnnpc");
										}
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Cya soon.."), (true));
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Disconnected..."), (true));
									}
									if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
											.getItem() == new ItemStack(BurnerphoneItem.block, (int) (1)).getItem())) {
										if (entity instanceof PlayerEntity) {
											ItemStack _stktoremove = new ItemStack(BurnerphoneItem.block, (int) (1));
											((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
													((PlayerEntity) entity).container.func_234641_j_());
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 10);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 10);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 10);
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("No one answered the phone"), (false));
			}
		}
	}
}
