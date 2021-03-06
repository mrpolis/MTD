package main.java.net.teepee.MTD.Automation;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Teleport {

	/**
	 * Teleport a player to a location without reserving the vehicle (if
	 * applicable).
	 * 
	 * @param p
	 *            The player
	 * @param to
	 *            The location
	 */
	public static void teleport(Player p, Location to) {
		teleport(p, to, false);
	}

	/**
	 * Teleport a player to a location.
	 * 
	 * @param p
	 *            The player
	 * @param to
	 *            The location
	 * @param keepVehicle
	 *            Whether or not to keep the vehicle
	 */
	public static void teleport(Player p, Location to, boolean keepVehicle) {
		if (to == null || p == null)
			return;

		if (p.isInsideVehicle()) {
			// Eject the vehicle...
			Entity vehicle = p.getVehicle();
			vehicle.eject();
			// Teleport the player...
			p.teleport(to);
			// Remove the vehicle if it's not persisting.
			if (!keepVehicle)
				vehicle.remove();
			else {
				// Otherwise teleport the vehicle and remount.
				vehicle.teleport(to);
				vehicle.setPassenger(p);
			}
			return;
		}

		p.teleport(to);
	}
}
