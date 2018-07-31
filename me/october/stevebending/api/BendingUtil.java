/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/

package com.october.stevebending.api;

public abstract class BendingUtil {
	
	protected BendingUtil() {}
	
	protected static final Bending getBending() {
		return StevebendingAPI.bending;
	}

}
