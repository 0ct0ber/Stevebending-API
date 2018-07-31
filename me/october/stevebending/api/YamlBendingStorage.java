package com.october.stevebending.api;

/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/


import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.october.stevebending.api.Bending.BendingType;

/**
*A basic YAML BendingStorage
*@author 0ct0ber
*/

public class YamlBendingStorage implements BendingStorage {
	
	private FileConfiguration config;
	private File file;
	private Logger errorlogger;
	
	public YamlBendingStorage(File file, Logger errorlogger) {
		config = YamlConfiguration.loadConfiguration(file);
		this.file = file;
	}

	@Override
	public BendingType getBendingType(UUID uuid) {
		String configString = uuid.toString() + ".element";
		String result = null;
		synchronized (config) {
			result = config.getString(configString);
		}
		if (result == null) return BendingType.NONE;
		return BendingType.valueOf(result);
	}

	@Override
	public void setBendingType(UUID uuid, BendingType type) {
		String configString = uuid.toString() + ".element";
		String typeString = type.toString();
		synchronized (config) {
		config.set(configString, typeString);
		save();
		}
	}
	
	private void save() {
		try {
			config.save(file);
		} catch (IOException ex) {
			errorlogger.log(Level.WARNING, "A problem occurred while trying to save bending data", ex);
			ex.printStackTrace();
		}
	}

}
