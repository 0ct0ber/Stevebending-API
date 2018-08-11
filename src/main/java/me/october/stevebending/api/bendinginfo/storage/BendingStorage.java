package me.october.stevebending.api.bendinginfo.storage;

/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/


import java.util.UUID;

import me.october.stevebending.api.central.Bending.BendingType;

public interface BendingStorage {
	
	public BendingType getBendingType(UUID uuid);
	public void setBendingType(UUID uuid, BendingType type);

}
