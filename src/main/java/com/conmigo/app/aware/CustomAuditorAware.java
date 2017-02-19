package com.conmigo.app.aware;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.conmigo.app.dto.CustomUserDetails;

@Component
public class CustomAuditorAware implements AuditorAware<Long> {

	@Override
	public Long getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if( authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof CustomUserDetails) ) {
			return null;
		}
		return ((CustomUserDetails) authentication.getPrincipal()).getId();
	}

}
