package me.october.stevebending.api;

/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class Bending {
	
	private Map<UUID, BendingType> playerdata = new HashMap<>();
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
	
	public void addOnline(Player player) {
		playerdata.put(player.getUniqueId(), storage.getBendingType(player.getUniqueId()));
	}
	
	public void removeOnline(Player player) {
		playerdata.remove(player.getUniqueId());
	}

}
