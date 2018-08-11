/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package me.october.stevebending.api.central;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
	
	private Bending bending;
	
	JoinListener(Bending bending) {
		this.bending = bending;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		bending.addOnline(event.getPlayer());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		bending.removeOnline(event.getPlayer());
	}

}
