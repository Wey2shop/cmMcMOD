package net.mcreator.cm.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cm.item.CableWrenchItem;
import net.mcreator.cm.CmModVariables;
import net.mcreator.cm.CmModElements;
import net.mcreator.cm.CmMod;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;

@CmModElements.ModElement.Tag
public class FanblockCMOnBlockRightClickedProcedure extends CmModElements.ModElement {
	public FanblockCMOnBlockRightClickedProcedure(CmModElements instance) {
		super(instance, 109);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				CmMod.LOGGER.warn("Failed to load dependency entity for procedure FanblockCMOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				CmMod.LOGGER.warn("Failed to load dependency x for procedure FanblockCMOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				CmMod.LOGGER.warn("Failed to load dependency y for procedure FanblockCMOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				CmMod.LOGGER.warn("Failed to load dependency z for procedure FanblockCMOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				CmMod.LOGGER.warn("Failed to load dependency world for procedure FanblockCMOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((entity.getCapability(CmModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new CmModVariables.PlayerVariables())).GridPower) > 0)
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(CableWrenchItem.block, (int) (1)).getItem()))) {
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Connection to Grid Successful "), (true));
			}
		}
	}
}
