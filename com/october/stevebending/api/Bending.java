package com.october.stevebending.api;

/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

import java.util.HashMap;
import java.util.Map;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Bending {
	
	private Map<Player, BendingType> playerdata = new HashMap<>();
	private BendingStorage storage;
	
	public enum BendingType {
		FIRE,
		WATER,
		EARTH,
		AIR,
		NONE;
	}
	
	public Bending(BendingStorage storage) {
		this.storage = storage;
	}
	
	public BendingType getBendingType(Player player) {
		return playerdata.getOrDefault(player, BendingType.NONE);
	}
	
	public BendingType getBendingType(OfflinePlayer oplayer) {
		if (oplayer.isOnline()) {
			Player player = oplayer.getPlayer();
			if (player != null) return playerdata.getOrDefault(player, BendingType.NONE);
		}
		
		return storage.getBendingType(oplayer.getUniqueId());
	}

}
