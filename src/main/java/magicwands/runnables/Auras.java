package magicwands.runnables;

import magicwands.MagicWands;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Random;

public class Auras extends BukkitRunnable{

    private Random random = new Random();
    private MagicWands plugin;

    private int counter;

    Location loc;
    int radius, r, g, b;


    public Auras(MagicWands plugin){
        this.plugin = plugin;
    }

    public void createAreaOfEffect(Location loc, int radius, int r, int g, int b){
        for (int i = 0; i < 10; i++){

            double angle = Math.random() * Math.PI * 2;
            double x = loc.getX() + Math.cos(angle) * random.nextInt(radius);
            double z = loc.getZ() + Math.sin(angle) * random.nextInt(radius);

            loc.setY(loc.getY() + (Math.random()));
            loc.setX(x);
            loc.setZ(z);

            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 0, 0.001, 1, 0, 1);
        }

    }

    @Override
    public void run(){
        if (counter > 0) counter--;
        else{
            this.cancel();
        }
        createAreaOfEffect();
    }
}
