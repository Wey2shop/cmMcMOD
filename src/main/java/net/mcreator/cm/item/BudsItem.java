
package net.mcreator.cm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.cm.itemgroup.CmMCMODItemGroup;
import net.mcreator.cm.CmModElements;

@CmModElements.ModElement.Tag
public class BudsItem extends CmModElements.ModElement {
	@ObjectHolder("cm:buds")
	public static final Item block = null;
	public BudsItem(CmModElements instance) {
		super(instance, 122);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(CmMCMODItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("buds");
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
