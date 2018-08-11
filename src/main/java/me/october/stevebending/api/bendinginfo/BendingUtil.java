package me.october.stevebending.api.bendinginfo;

import me.october.stevebending.api.central.Bending;
import me.october.stevebending.api.central.StevebendingAPI;

public abstract class BendingUtil {
	
	protected BendingUtil() {}
	
	protected static final Bending getBending() {
		return StevebendingAPI.getBending();
	}

}
