package com.desarrollo.josue.platzimarket.web.security;

import com.desarrollo.josue.platzimarket.domain.service.PlatziUserDetailsService;
import com.desarrollo.josue.platzimarket.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PlatziUserDetailsService platziUserDetailsService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(platziUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Usando este metodo establecemos que cualquier solicitud terminada en authenticate no necesita se authenticada
        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll()
                //Y todas las restantes deben de autenticarse para poder ser procesadas.
                .anyRequest().authenticated().and().sessionManagement().
                sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    //Con la etiqueta bean establecemos que este metodo sera el gestor de autenticacion de nuestra aplicacion
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        //Debemos de agregar este metodo debido a que en la clase AuthController utilizamos el objeto AuthenticationManager
        //En este caso se deja la configuracion por defecto que viene en la clase padre
        return super.authenticationManagerBean();
    }
}
