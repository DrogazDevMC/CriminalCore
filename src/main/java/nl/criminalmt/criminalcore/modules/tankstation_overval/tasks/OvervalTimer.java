package nl.criminalmt.criminalcore.modules.tankstation_overval.tasks;

import nl.criminalmt.criminalcore.modules.tankstation_overval.TankstationModule;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class OvervalTimer extends BukkitRunnable {


        private final TankstationModule module;
        private int seconds = 1800;

        public OvervalTimer(TankstationModule module) {
                this.module = module;
        }

        @Override
        public void run() {
                seconds--;

                if (seconds == 0) {
//                        Bukkit.broadcastMessage("De overval is gelukt!");
                        module.setOverval(false);
                }
        }
}
