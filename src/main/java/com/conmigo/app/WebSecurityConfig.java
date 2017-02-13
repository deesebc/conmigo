package com.conmigo.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final static String LOGIN_PAGE = "/login";
	private final static String LOGOUT_PAGE = "/logout";
	private final static String[] PUBLIC_PAGES = { "/", "/auth/**", "/login", "/signup/**", "/**/**" };

	@Override
	protected void configure( final HttpSecurity http ) throws Exception {
		http.formLogin().loginPage( LOGIN_PAGE ).and().authorizeRequests().antMatchers( PUBLIC_PAGES ).permitAll();
		// @formatter:off
		// configures form login
		// http.formLogin().loginPage( LOGIN_PAGE ).permitAll().and().logout().logoutUrl( LOGOUT_PAGE ).deleteCookies( "JSESSIONID" ).logoutSuccessUrl( "/" ).permitAll();
		// // configure form logout
		// .and().logout().logoutUrl( LOGOUT_PAGE ).deleteCookies( "JSESSIONID" ).logoutSuccessUrl( "/" ).permitAll()
		// // configure free access urls
		// .and().authorizeRequests().antMatchers( PUBLIC_PAGES ).permitAll()
		// // configure user pages
		// .antMatchers( RESTRICTED_PAGES ).fullyAuthenticated()
		// // configure admin pages
		// .antMatchers( ADMIN_PAGES ).hasAnyAuthority( "ADMIN", "SUPERADMIN" )
		// // anonymous
		// .antMatchers( ANONYMOUS_PAGES ).anonymous()
		// // configure remember me
		// .and().rememberMe()
		// // Adds the SocialAuthenticationFilter to Spring Security's filter chain. Nos permite que funcione la url /auth/provider
		// .and().apply( new SpringSocialConfigurer().postLoginUrl( "/" ).alwaysUsePostLoginUrl( true ) );
		// @formatter:on
	}

	@Override
	public void configure( final WebSecurity web ) throws Exception {
		web.ignoring().antMatchers( "/**/*.css", "/**/*.png", "/**/*.gif", "/**/*.jpg" );
	}

}
