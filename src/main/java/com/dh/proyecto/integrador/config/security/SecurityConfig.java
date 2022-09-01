package com.dh.proyecto.integrador.config.security;

import com.dh.proyecto.integrador.config.security.jwt.JwtEntryPointConfig;
import com.dh.proyecto.integrador.config.security.jwt.JwtTokenFilterConfig;
import com.dh.proyecto.integrador.model.service.jwt.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;


/**
 * @author dpanquev
 * @version 2022-09-01
 * <p>
 * Clase encargada de orquestar la configuración del jwt token para temas de seguridad
 * Estaré trabajando sobre el componente websecurityConfigurerAdapter deprecado para
 * actualizarlo
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtEntryPointConfig jwtEntryPointConfig;

    /**
     * Registro de propiedades a implementar
     */
    @Bean
    public JwtTokenFilterConfig jwtTokenFilter() {
        return new JwtTokenFilterConfig();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }*/
    @Bean("authenticationManager")
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Registro de los endpoints, definiendo quien tiene acceso a cada uno de ellos, esto con el fin de darle
     * seguridad a nuestra aplicación
     */
   // @Override
    @Primary
    @Bean
    protected HttpSecurity configure(HttpSecurity http) throws Exception {


        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth/**", "/api/v1/user/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/city/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/cit/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**"
                        , "/api/v1/role/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/cit/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**"
                        , "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/product/**", "/api/v1/category/**"
                        , "/api/v1/cit/**", "/api/v1/feature/**", "/api/v1/policy/**", "/api/v1/product-feature/**"
                        , "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/role/**", "/api/v1/user/**").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/v1/booking/**", "/api/v1/favorite/**").hasAnyRole("USER", "ADMIN")

                 //.anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPointConfig)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return  http;
    }

    /**
     * Se registran los cors origin para que el ecosistema permita el libre consumo de los endpoints desde
     * el front
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**", config);
        return cors;
    }

    /**
     * Registro los filtros configurados anteriormente para que sea un filter implementado por sprinb
     * de esta manera uso e implemento el registro y apertura de los cors
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
