package magicwands.spells;

import magicwands.MagicWands;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Spells{
    private final MagicWands plugin;

    public Spells(MagicWands plugin){
        this.plugin = plugin;
    }

    private Location endLocation;

    public void createSpellAnimation(Player p){
        new BukkitRunnable(){
            Location loc = p.getLocation();

            @Override
            public void run(){
                for (int i = 0; i < 10; i++){
                    Vector dir = loc.getDirection();
                    dir.multiply(i);
                    loc.add(dir);

                    p.getWorld().spawnParticle(Particle.FLAME, loc, 3, Math.random() / 5, Math.random() / 5, Math.random() / 5, 0.05);
                    p.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0.001, 0, 1);
                    if ((loc.getBlock().getType() != Material.AIR) && (loc.getBlock().getType() != Material.GRASS) && (loc.getBlock().getType() != Material.LONG_GRASS) && (loc.getBlock().getType() != Material.CHORUS_FLOWER) && (loc.getBlock().getType() != Material.YELLOW_FLOWER) && (loc.getBlock().getType() != Material.RED_ROSE)){
                        endLocation = loc;
                        this.cancel();
                        break;
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 1);
    }


    public Location getEndLocation(){
        return endLocation;
    }
}
