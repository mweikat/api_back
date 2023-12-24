package cl.back.api.src.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Encrypt {

    private BCryptPasswordEncoder passwordEncoder;

    public String getPasswordEncrypt(String password){

        passwordEncoder = new BCryptPasswordEncoder();

        //System.out.println(hashedPassword);
        return passwordEncoder.encode(password);

    }

    public boolean comparaPass(String pass1, String pass2){
        passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(pass1, pass2);
    }
}
