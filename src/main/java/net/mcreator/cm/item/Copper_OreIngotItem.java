
package net.mcreator.cm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.cm.itemgroup.CmMCMODItemGroup;
import net.mcreator.cm.CmModElements;

@CmModElements.ModElement.Tag
public class Copper_OreIngotItem extends CmModElements.ModElement {
	@ObjectHolder("cm:copper_ore_ingot")
	public static final Item block = null;
	public Copper_OreIngotItem(CmModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CmMCMODItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("copper_ore_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
