package mx.com.pruebarsg.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import mx.com.pruebarsg.service.Impl.UsuarioServiceImpl;



@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
   @Bean
    public UserDetailsService userDetailsService() {
        return new UsuarioServiceImpl();
    }
   
    /**
     * Encripta la contrase�a del usuario
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
   
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
       
        return authProvider;
    }
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
   
    /**
     * Se configura la p�gina de login para el usuario, el nombre del par�metro, la p�gina
     */
 
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http.authorizeRequests()
             .antMatchers("/users/**").access("hasAuthority('ADMIN')")
             .antMatchers("/users/**").access("hasAnyAuthority('ADMIN', 'USER')")
             .antMatchers("/resources/**").permitAll()
             .anyRequest().permitAll()
             .and()
             .formLogin()
             .loginPage("/").permitAll()
                 .usernameParameter("email")
                 //.defaultSuccessUrl("/home")
                 .successHandler(loginSuccessHandler)
                 .permitAll()
             .and()
             .logout().logoutSuccessUrl("/logout").permitAll();
         http.sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
             .invalidSessionUrl("/");
     }
    
    
}
