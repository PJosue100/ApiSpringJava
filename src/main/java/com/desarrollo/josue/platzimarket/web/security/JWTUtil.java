package com.desarrollo.josue.platzimarket.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String KEY= "MundoKruel|HOL4F3LiZMund0";

    public String generateToken(UserDetails userDetails){
        //Vamos a generar un json web token
        //tenemos que agregar el usuario en el setSubjet
        //tenemos que establecer la fecha en la que fue creado el jwt por lo cual intanciamos un objeto Date()
        //tenemos que establecer la fecha de  expiracion
        //Y lo firmamos con el algoritmo de nuestra eleccion; esto agregando una llave.
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,KEY).compact();

    }

    public boolean validateToken(String token, UserDetails userDetails){
        return userDetails.getUsername().equals(extractUsername(token))&& !isTokenExpired(token);
    }


    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        //Obtenemos la fecha de expiracion del token y preguntamos si esta antes de la nueva instancia del objeto date.
        return getClaims(token).getExpiration().before(new Date());
    }


    //Los claims son como los objetos en los jwt.
    //Va a revisar primero si el usuario es correcto y si el token no ha expirado
    private Claims getClaims(String token){
        //En esta linea de codigo preguntamos si la firma del token es valida o no si es valida el proceso se termina alli
        return  Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();

    }

}
