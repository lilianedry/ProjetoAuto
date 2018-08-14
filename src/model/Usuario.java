package model;

/* CLASSE BÃ�SICA DE USUÃ�RIO PARA VALIDAÃ‡ÃƒO DE LOGIN */

public class Usuario {

    private static final String login = "admin";
    private static final String senha = "admin";

    public static boolean login (String log, String pass){

        return (login.equals(log) && senha.equals(pass));

    }

}
