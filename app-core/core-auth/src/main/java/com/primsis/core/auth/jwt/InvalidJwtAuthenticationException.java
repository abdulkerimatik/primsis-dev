package com.primsis.core.auth.jwt;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6280880562894811156L;

	public InvalidJwtAuthenticationException(String e) {
        super(e);
    }
}
