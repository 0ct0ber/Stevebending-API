/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package me.october.stevebending.api.central;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.october.stevebending.api.bendinginfo.storage.BendingStorage;
import me.october.stevebending.api.bendinginfo.storage.YamlBendingStorage;

/**Main class for the plugin*/

public final class StevebendingAPI extends JavaPlugin {
	
	private static Bending bending = null;
	
	@Override
	public void onEnable() {
		saveDefaultConfig();
		File playerdata = getPlayerData();
		if (playerdata == null) {
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		BendingStorage storage = createStorage(playerdata);
		if (storage == null) {
			Bukkit.getPluginManager().disablePlugin(this);
			return;
		}
		
		bending = new Bending(storage);
		
		BendingCommands bc = new BendingCommands(bending, getConfig().getBoolean("allow-switch-elements"));
		this.getCommand("fire").setExecutor(bc);
		this.getCommand("water").setExecutor(bc);
		this.getCommand("earth").setExecutor(bc);
		this.getCommand("air").setExecutor(bc);
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			bending.addOnline(player);
		}
	}
	
	public static final Bending getBending() {
		return bending;
	}
	
	@Override
	public void onDisable() {
		bending = null;
	}
	
	private File getPlayerData() {
		saveDefaultConfig();
		File folder = this.getDataFolder();
		if (!folder.exists()) try {
			folder.createNewFile();
			folder.mkdir();
		} catch (IOException ex) {
			getLogger().warning("An I/O exception occurred while trying to create the plugin folder, disabling: ");
			ex.printStackTrace();
			return null;
		}
		
		if (!folder.isDirectory()) {
			getLogger().warning("Plugin folder is not a folder, disabling");
			return null;
		}
		
		File playerdata = new File(folder, "playerdata.yml");
		if (!playerdata.exists()) try {
			playerdata.createNewFile();
		}  catch (IOException ex) {
			getLogger().warning("An I/O exception occurred while trying to create the playerdata file, disabling: ");
			ex.printStackTrace();
			return null;
		}
		return playerdata;
	}
	
	private BendingStorage createStorage(File playerdata) {
		BendingStorage storage = null;
		try {
			storage = new YamlBendingStorage(playerdata, getLogger());
		} catch (RuntimeException ex) {
			getLogger().warning("An exception occurred while trying to create the bending storage, disabling plugin: ");
			ex.printStackTrace();
		}
		
		return storage;
	}

}
