package model;

/* CLASSE BÁSICA DE USUÁRIO PARA VALIDAÇÃO DE LOGIN */

public class Usuario {

    private static final String login = "admin";
    private static final String senha = "admin";

    public static boolean login (String log, String pass)
    {

        return (login.equals(log) && senha.equals(pass));

    }

}
