package br.com.cadastroprodutos.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorSenha {

    public static void main(String[] args) {
        String password = "123";
        String passwordEncrypt = new BCryptPasswordEncoder().encode(password);
        System.out.println(passwordEncrypt);
    }
}
