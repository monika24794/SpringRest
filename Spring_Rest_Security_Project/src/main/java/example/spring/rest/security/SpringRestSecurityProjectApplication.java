package example.spring.rest.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity // enables spring security customized using this annotation
public class SpringRestSecurityProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecurityProjectApplication.class, args);
	}

	// Configuring password Encoder - BCryptPasswordEncoder
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();

	}

	// config user and roles
	@Bean
	public UserDetailsService getUserDetailsService() {
		UserDetails adminUser = User.withUsername("admin").password(encoder().encode("phonix123")).roles("ADMIN").build();
		UserDetails regularUser = User.withUsername("regular").password(encoder().encode("phonix123")).roles("REGULAR").build();
		InMemoryUserDetailsManager usersManager=
				new InMemoryUserDetailsManager(adminUser,regularUser);
		
		return usersManager;

	}
	//configure SecurityFilterChain
	@Bean
	public SecurityFilterChain getsecurityFilterChain(HttpSecurity http)throws Exception
	{
		http.authorizeHttpRequests(auth -> {
			auth.requestMatchers("/greet").permitAll().
			
			requestMatchers("/regular-work").hasAnyRole("ADMIN","REGULAR").
			     requestMatchers("/admin-work").hasAnyRole("ADMIN").anyRequest().authenticated();
		});
		http.formLogin(Customizer.withDefaults());
		http.httpBasic(Customizer.withDefaults());
		return http.build();
		
	}
	

}
