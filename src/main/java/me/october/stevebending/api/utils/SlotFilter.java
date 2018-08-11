/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package me.october.stevebending.api.utils;

import org.bukkit.entity.Player;

public class SlotFilter {
	
	private boolean[] slots;
	
	public SlotFilter(String slots) {
		if (slots.length() != 9) throw new IllegalArgumentException("Slots string");
		boolean[] storedslots = new boolean[8];
		for (int i = 0; i < 8; i++) {
			storedslots[i] = (slots.charAt(i) == ' ');
		}
		
		this.slots = storedslots;
		
	}
	
	public SlotFilter(boolean[] slots) {
		boolean[] storedslots = new boolean[8];
		for (int i = 0; i < 8; i++) {
			storedslots[i] = slots[i];
		}
	}
	
	public boolean filter(int slot) {
		return slots[slot];
	}
	
	public boolean filterSlot(Player player) {
		return filter(player.getInventory().getHeldItemSlot());
	}

}