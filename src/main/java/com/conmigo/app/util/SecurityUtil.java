package com.conmigo.app.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.conmigo.app.dto.CustomUserDetails;

public final class SecurityUtil {
	private SecurityUtil() {
		super();
	}

	public static boolean isFullyAuthenticated() {
		boolean retorno = false;
		if( SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
				&& !(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String && Constant.ANONYMOUS_USER.equals( SecurityContextHolder.getContext().getAuthentication().getPrincipal() )) ) {
			retorno = true;
		}
		return retorno;
	}

	public static Long getIdUser() {
		Long idUser = null;
		if( isFullyAuthenticated() ) {
			final CustomUserDetails usuario = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			idUser = usuario.getId();
		}
		return idUser;
	}
}
