package model;

/* CLASSE BÃ�SICA DE USUÃ�RIO PARA VALIDAÃ‡ÃƒO DE LOGIN */

public class Usuario {

    private static final String login = "admin";
    private static final String senha = "admin";
    
    private static final String loginFunc = "func";
    private static final String senhaFunc = "func";
    
    public static boolean login (String log, String pass){

        return (login.equals(log) && senha.equals(pass));

    }
    public static boolean loginFunc (String log, String pass){

        return (loginFunc.equals(log) && senhaFunc.equals(pass));

    }

}
