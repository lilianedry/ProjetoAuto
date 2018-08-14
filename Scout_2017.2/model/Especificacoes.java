package model;

/**Esta classe contém informações sobre a aplicação que serão retornadas ao usuário na tela de Login*/

public class Especificacoes {

    private static String softwareNome = "Scout";
    private static String softwareVersao = "1.0.1";

    public static String getSoftwareNome ()
    {
        return softwareNome;
    }

    public String getSoftwareVersao ()
    {
        return softwareVersao;
    }
}
