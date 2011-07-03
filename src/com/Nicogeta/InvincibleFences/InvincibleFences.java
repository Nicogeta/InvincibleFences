package com.Nicogeta.InvincibleFences;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.Nicogeta.InvincibleFences.InvincibleFencesBlockListener;
import com.Nicogeta.InvincibleFences.InvincibleFences;
import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class InvincibleFences extends JavaPlugin {

	private static final Logger log = Logger.getLogger("Minecraft");
	public static PermissionHandler Permissions;
	private final InvincibleFencesBlockListener blockListener = new InvincibleFencesBlockListener(this);

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_DAMAGE, blockListener, Priority.High, this);
		pm.registerEvent(Event.Type.BLOCK_BREAK, blockListener, Priority.High, this);
		pm.registerEvent(Event.Type.BLOCK_BURN, blockListener, Priority.High, this);
		pm.registerEvent(Event.Type.BLOCK_IGNITE, blockListener, Priority.High, this);
		pm.registerEvent(Event.Type.BLOCK_PHYSICS, blockListener, Priority.High, this);
		pm.registerEvent(Event.Type.BLOCK_DISPENSE, blockListener, Priority.High, this);

		setupPermissions();
		log.info("InvincibleFences ENABLE (by Nicogeta)");
		log.info("InvincibleFences ver 0.1");
	}

	private void setupPermissions() {
		Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");

		if (InvincibleFences.Permissions == null) 
		{
			if (test != null) {
				InvincibleFences.Permissions = ((Permissions)test).getHandler();
				log.info("InvincibleFences has detected Permissions!");
			} else {
				log.info("InvincibleFences has not detected Permissions.");
			}
		}
	}

	public void onDisable() {
		log.info("InvincibleFences DISABLE");
	}

}
