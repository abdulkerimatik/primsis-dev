package com.primsis.core.entity.base;

import com.primsis.core.entity.UserSessionToken;

import lombok.Data;

/**
 * @author abdulkerim.ATIK
 *
 */
public @Data class ValidMappingResponse {
	
	private boolean valid;
    private UserSessionToken userTokenSession;


    public ValidMappingResponse(boolean valid, UserSessionToken userTokenSessionFromDB) {
		this.valid=valid;
		this.userTokenSession=userTokenSessionFromDB;
	}
}
