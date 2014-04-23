package redgear.morebackpacks.config;

import net.minecraft.item.ItemStack;
import redgear.core.util.ItemRegUtil;
import forestry.api.storage.IBackpackDefinition;

public class BackpackData {
	
	String backpackKey;
	
	String[] items;

	public String getBackpackKey() {
		return backpackKey;
	}

	public void setBackpackKey(String backpackKey) {
		this.backpackKey = backpackKey;
	}

	public String[] getItems() {
		return items;
	}

	public void setItems(String[] values) {
		this.items = values;
	}
	
	public void addItems(IBackpackDefinition backpack){
		ItemStack item;
		
		for(String name : items){
			item = ItemRegUtil.findStack(name.trim());
			
			if(item != null)
				backpack.addValidItem(item);
		}
	}
}
