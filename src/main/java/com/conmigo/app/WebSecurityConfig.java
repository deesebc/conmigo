package com.conmigo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

import com.conmigo.app.service.impl.CustomSocialUsersDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;

	private final static String[] PUBLIC_PAGES = { "/", "/auth/**", "/login", "/signup/**", "/trends", "/products", "/user/social/register/**", "/recommend/**" };
	private final static String[] RESTRICTED_PAGES = { "/userData", "/interes", "/rest/userProduct/**", "/myList/**" };
	private final static String[] ANONYMOUS_PAGES = { "/password/**" };
	private final static String[] ADMIN_PAGES = { "/admin/**" };
	private final static String LOGIN_PAGE = "/login";
	private final static String LOGOUT_PAGE = "/logout";

	@Override
	public void configure( final WebSecurity web ) throws Exception {
		web.ignoring().antMatchers( "/**/*.css", "/**/*.png", "/**/*.gif", "/**/*.jpg" );
	}

	@Override
	protected void configure( final HttpSecurity http ) throws Exception {
		// @formatter:off
		// configures form login
		http.formLogin().loginPage( LOGIN_PAGE ).permitAll()
				// configure form logout
				.and().logout().logoutUrl( LOGOUT_PAGE ).deleteCookies( "JSESSIONID" ).logoutSuccessUrl( "/" ).permitAll()
				// configure free access urls
				.and().authorizeRequests().antMatchers( PUBLIC_PAGES ).permitAll()
				// configure user pages
				.antMatchers( RESTRICTED_PAGES ).fullyAuthenticated()
				// configure admin pages
				.antMatchers( ADMIN_PAGES ).hasAnyAuthority( "ADMIN", "SUPERADMIN" )
				// anonymous
				.antMatchers( ANONYMOUS_PAGES ).anonymous()
				// configure remember me
				.and().rememberMe()
				// Adds the SocialAuthenticationFilter to Spring Security's filter chain. Nos permite que funcione la url /auth/provider
				.and().apply( new SpringSocialConfigurer().postLoginUrl( "/" ).alwaysUsePostLoginUrl( true ) );
		// @formatter:on
	}

	@Bean
	public SocialUserDetailsService socialUserDetailsService() {
		return new CustomSocialUsersDetailService( userDetailsService );
	}

	@Bean( name = "passwordEncoder" )
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configAuthentication( final AuthenticationManagerBuilder auth ) throws Exception {
		auth.userDetailsService( userDetailsService ).passwordEncoder( passwordencoder() );
	}

	/**
	 * Crea el metodo que permite obtener los connection sociales de la request
	 *
	 * @param connectionFactoryLocator
	 * @param connectionRepository
	 * @return
	 */
	@Bean
	public ProviderSignInUtils providerSignInUtils( final ConnectionFactoryLocator connectionFactoryLocator, final UsersConnectionRepository connectionRepository ) {
		return new ProviderSignInUtils( connectionFactoryLocator, connectionRepository );
	}

}
