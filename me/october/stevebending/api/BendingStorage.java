package com.october.stevebending.api;

/**
*Part of Stevebending API
*Project License: https://github.com/0ct0ber/Stevebending-API/blob/master/LICENSE.txt
*/


import java.util.UUID;

import com.october.stevebending.api.Bending.BendingType;

public interface BendingStorage {
	
	public BendingType getBendingType(UUID uuid);
	public void setBendingType(UUID uuid, BendingType type);

}
