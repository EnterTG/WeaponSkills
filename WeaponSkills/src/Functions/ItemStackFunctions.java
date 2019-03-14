package Functions;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class ItemStackFunctions {

	public static double findValueInItemStack(ItemStack item, String name,String seperator,int pos)
	{
		List<String> lore = item.getItemMeta().getLore();
		String str = lore.stream().filter( s -> s.contains(name)).findFirst().orElse(null);
		if(str == null) return 0d;
		
		String[] splitedstr = str.split(seperator);
		try
		{
			return  Double.parseDouble(splitedstr[pos]);
		}
		catch (NumberFormatException e) 
		{
			return 0d;
		}
	}
}
