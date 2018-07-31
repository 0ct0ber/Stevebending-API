/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package com.october.stevebending.api;

import static com.october.stevebending.api
public abstract class BendingUtil {
	
	protected BendingUtil() {}
	
	protected static final Bending getBending() {
		return StevebendingAPI.getBending();
	}
	
	public static boolean isNonBender(Player player) {
		return getBending().getBendingType(player) == BendingType.NONE;
	}
	
	public static boolean isWaterbender(Player player) {
		return getBending().getBendingType(player) == BendingType.WATER;
	}
	
	public static boolean isFirebender(Player player) {
		return getBending().getBendingType(player) == BendingType.FIRE;
	}
	
	public static final boolean isEarthbender(Player player) {
		return getBending().getBendingType(player) == BendingType.EARTH;
	}
	
	public static final boolean isAirbender(Player player) {
		return getBending().getBendingType(player) == BendingType.AIR;
	}

}
