package Finders;

import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.inventory.ItemStack;

public class StandardFinders implements Finder{

	private final Pattern matcher;
	public StandardFinders(String s)
	{
		matcher = Pattern.compile(s+"\\: (\\d+)");
	}
	
	@Override
	public double find(ItemStack item)
	{
		List<String> lore= item.getItemMeta().getLore();
		String a = lore.parallelStream().filter( s -> matcher.matcher(s).find()).findAny().orElse(null);
		String out = matcher.matcher(a).group(1);
		return a == null ? 0d : Double.parseDouble(out);
	}


}
