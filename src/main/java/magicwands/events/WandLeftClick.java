package magicwands.events;

import magicwands.MagicWands;
import magicwands.spells.Spells;
import magicwands.spells.healing.TreeAura;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WandLeftClick implements Listener{

    private MagicWands plugin;

    public WandLeftClick(MagicWands plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onWandLeftClick(PlayerInteractEvent e){
        if ((e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && e.getItem().getData().getItemType() == Material.STICK){
            Spells spells = plugin.getSpells();
            spells.createSpellAnimation(e.getPlayer());
            if (spells.getEndLocation().getBlock().getType() == Material.LOG){
                e.getPlayer().sendMessage("Suk me dik");
                plugin.getTreeAura().createAreaOfEffect(spells.getEndLocation(), 20, 255, 0, 0);
            }
        }
    }
}
