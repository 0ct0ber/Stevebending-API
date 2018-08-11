/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package me.october.stevebending.api.bendinginfo;

import org.bukkit.entity.Player;

import me.october.stevebending.api.central.Bending.BendingType;

public class Earthbending extends BendingUtil {
	
	public static final boolean isEarthbender(Player player) {
		return getBending().getBendingType(player) == BendingType.EARTH;
	}

}
