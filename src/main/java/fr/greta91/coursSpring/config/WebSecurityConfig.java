package fr.greta91.coursSpring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

@Configuration
public class WebSecurityConfig 
	extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println(passwordEncoder().encode("user"));
//		System.out.println(passwordEncoder().encode("admin"));
//		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
//		.withUser("user").password(passwordEncoder().encode("user")).roles("USER")
//		.and()
//		.withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");
		//fluent api
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		//configuration des ressources communes
		web
			.ignoring()
			.mvcMatchers("/css/**")
			.mvcMatchers("/images/**")
			.mvcMatchers("/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//système d'autorisation
//		http.authorizeRequests().anyRequest().anonymous();//on autorise tout le monde

		http
			.authorizeRequests()
			.mvcMatchers("/admin/**").hasRole("ADMIN")//"ROLE_ADMIN"
//			.mvcMatchers("/user/**").hasAuthority("USER")//"USER"
			.mvcMatchers("/user/**").access("hasRole('ADMIN') or hasAuthority('USER')")
//			.anyRequest().authenticated()
			.mvcMatchers("/**").permitAll()//on autorise tout le monde
			.and()
			.formLogin().permitAll()// /login -> accès à tous
			.and()
			.logout().logoutUrl("/deconnecter");
	}
	
	
}
