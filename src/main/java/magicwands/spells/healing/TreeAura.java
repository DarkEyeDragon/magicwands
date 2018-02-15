package magicwands.spells.healing;

import magicwands.MagicWands;
import magicwands.utils.ColorConverter;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.Random;

public class TreeAura{

    private Random random = new Random();
    private MagicWands plugin;

    public TreeAura(MagicWands plugin){
        this.plugin = plugin;
    }

    public void createAreaOfEffect(Location loc, int radius, int r, int g, int b){
        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(plugin, () -> {
            for (int i = 0; i < 10; i++){

                double angle = Math.random() * Math.PI * 2;
                double x = loc.getX() + Math.cos(angle) * random.nextInt(radius);
                double z = loc.getZ() + Math.sin(angle) * random.nextInt(radius);

                loc.setY(loc.getY() + (Math.random()));
                loc.setX(x);
                loc.setZ(z);

                loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 0, 0.001, 1, 0, 1);
            }
        }, 0L, 100L);

    }


}
