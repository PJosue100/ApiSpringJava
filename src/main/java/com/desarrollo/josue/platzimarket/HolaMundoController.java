/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.josue.platzimarket;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Josue
 */
@RestController
@RequestMapping("/saludar")
public class HolaMundoController {
    
    
    @GetMapping("/hola")
    public String HolaHundo() {
        String saludo= "Hola perro mundo jajajajaj.";
        System.out.println("Hola perro mundo jajajajaj.");
        return saludo;
    }
    
}
