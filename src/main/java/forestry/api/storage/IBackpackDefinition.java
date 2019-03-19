package forestry.api.storage;

import java.util.List;
import net.minecraft.item.ItemStack;

public abstract interface IBackpackDefinition
{
  public abstract String getKey();
  
  public abstract String getName(ItemStack nameItemStack);
  
  public abstract int getPrimaryColour();
  
  public abstract int getSecondaryColour();
  
  public abstract void addValidItem(ItemStack nameItemStack);
  
  public abstract void addValidItems(List<ItemStack> nameList);
  
  public abstract boolean isValidItem(ItemStack nameItemStack);
}


/* Location:              D:\Program Files\0E Games\Minecraft\Instances\Volentus\mods\forestry_1.7.10-4.2.16.64.jar!\forestry\api\storage\IBackpackDefinition.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */