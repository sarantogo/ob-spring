package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;


public class EncryptionTest {
    /**
     * BCrypt that generates its own salt of 16 bytes
     *
     * The result of encoding with bcrypt will be a string of 60 characters:
     *
     * $a version
     * $10 strength (it goes from 4 to 31, default value is 10)
     * The next 22 characters are the salt
     * */
    @Test
    void  bcryptTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        System.out.println(passwordEncoder.matches("admin", hashedPassword));
    }

    @Test
    void bcryptCheckMultiplePasswords(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for(int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void pbkdf2(){
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder("secret", 10, 120, 100);
        for(int i = 0; i < 30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void stringPasswordEncoders(){
        Map<String, PasswordEncoder> encoders = new HashMap<>();

        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder("secret", 10, 120, 100));
        //encoders.put("argon2", new Argon2PasswordEncoder());
        //encoders.put("scrypt", new SCryptPasswordEncoder());
        //no seguro:
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

        System.out.println(passwordEncoder.encode("admin"));
    }
}
