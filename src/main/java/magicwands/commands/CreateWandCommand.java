package magicwands.commands;

import de.tr7zw.itemnbtapi.NBTEntity;
import de.tr7zw.itemnbtapi.NBTFile;
import de.tr7zw.itemnbtapi.NBTItem;
import de.tr7zw.itemnbtapi.NBTTileEntity;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class CreateWandCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (command.getName().equalsIgnoreCase("wand")){
            if (args.length > 0){
                if (args[0].equalsIgnoreCase("create")){
                    //TODO add wand shizzle
                    NBTItem nbti = new NBTItem(new ItemStack(Material.STICK));
                }
            }
        }
        return false;
    }
}
