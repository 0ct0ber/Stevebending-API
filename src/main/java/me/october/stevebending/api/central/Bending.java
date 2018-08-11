/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package me.october.stevebending.api.central;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import me.october.stevebending.api.bendinginfo.storage.BendingStorage;

public class Bending {
	
	private Map<UUID, BendingType> playerdata = new ConcurrentHashMap<>();
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
		return playerdata.getOrDefault(player.getUniqueId(), BendingType.NONE);
	}
	
	public BendingType getBendingType(OfflinePlayer oplayer) {
		return oplayer.isOnline() ? 
		playerdata.getOrDefault(oplayer.getUniqueId(), BendingType.NONE) : storage.getBendingType(oplayer.getUniqueId());
	}
	
	void addOnline(Player player) {
		playerdata.put(player.getUniqueId(), storage.getBendingType(player.getUniqueId()));
	}
	
	void removeOnline(Player player) {
		playerdata.remove(player.getUniqueId());
	}
	
	void setBendingType(OfflinePlayer oplayer, BendingType type) {
		playerdata.put(oplayer.getUniqueId(), type);
		storage.setBendingType(oplayer.getUniqueId(), type);
	}

}
