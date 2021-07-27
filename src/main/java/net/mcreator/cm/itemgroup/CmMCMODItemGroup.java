
package net.mcreator.cm.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.cm.item.DiamondFireSwordItem;
import net.mcreator.cm.CmModElements;

@CmModElements.ModElement.Tag
public class CmMCMODItemGroup extends CmModElements.ModElement {
	public CmMCMODItemGroup(CmModElements instance) {
		super(instance, 51);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcm_mcmod") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DiamondFireSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
