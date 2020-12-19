package com.desarrollo.josue.platzimarket.domain.service;

import com.desarrollo.josue.platzimarket.domain.Product;
import com.desarrollo.josue.platzimarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Este es un servicio de dominio sirve como intermediario entre el controlador y el repositorio
@Service
public class PlatziUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("josue","{noop}josuejosue", new ArrayList<>());
    }
}
