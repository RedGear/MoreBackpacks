package redgear.morebackpacks.config;

import java.util.LinkedList;
import java.util.List;

import net.minecraftforge.oredict.OreDictionary;
import redgear.core.util.SimpleItem;
import redgear.morebackpacks.core.BasicBackpack;

public class BackpackDataBuilder {
	
	private final String backpackKey;
	private final List<String> values = new LinkedList<String>();
	
	public BackpackDataBuilder(String backpackKey){
		this.backpackKey = backpackKey;
	}
	
	public BackpackDataBuilder(BasicBackpack pack){
		this.backpackKey = pack.getKey();
		
		for(SimpleItem item : pack.itemsList)
			add(item.getName() + (item.meta == OreDictionary.WILDCARD_VALUE ? "" : ("@" + item.meta)));
	}
	
	public void add(String value){
		values.add(value);
	}
	
	public BackpackData build(){
		BackpackData data = new BackpackData();
		
		data.setBackpackKey(backpackKey);
		data.setItems(values.toArray(new String[values.size()]));
		
		return data;
	}

}
