package magicwands;

import magicwands.commands.CreateWandCommand;
import magicwands.events.WandLeftClick;
import magicwands.spells.Spells;
import magicwands.spells.healing.TreeAura;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicWands extends JavaPlugin{


    private Spells spells;
    private TreeAura treeAura;


    @Override
    public void onEnable(){
        spells = new Spells(this);
        this.getCommand("wand").setExecutor(new CreateWandCommand());
        getServer().getPluginManager().registerEvents(new WandLeftClick(this), this);
        this.treeAura = new TreeAura(this);
    }

    @Override
    public void onDisable(){

    }

    public Spells getSpells(){
        return spells;
    }

    public TreeAura getTreeAura(){
        return treeAura;
    }

}
