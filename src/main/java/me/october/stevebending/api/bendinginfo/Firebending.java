/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package me.october.stevebending.api.bendinginfo;

import org.bukkit.entity.Player;

import me.october.stevebending.api.central.Bending.BendingType;

public class Firebending extends BendingUtil {
	
	protected Firebending() {}
	
	public static final boolean isFirebender(Player player) {
		return getBending().getBendingType(player) == BendingType.FIRE;
	}

}
