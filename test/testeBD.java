
import database.DAOs.ClienteDAO;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import model.entities.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Enigma
 */
public class testeBD {

    public static void main(String args[]) {
        Cliente cli = new Cliente("teste", "teste", "teste", "teste", Date.from(Instant.now()), "teste", "250",
                "teste", "teste", "teste", "teste", "teste", "teste");
//        Carro car = new Carro("teste", "teste", "teste", "teste", "2018", "teste",
//                "teste", "1000", "teste");
//
        ClienteDAO cliDAO1 = new ClienteDAO();
        cliDAO1.add(cli);
//        
//        car.setCliente(cli);
//        cli.getCarrosCedidos().add(car);
//
//        CarroDAO carDAO = new CarroDAO();
//        carDAO.add(car);
//
        System.out.println("fodac4");
        ClienteDAO cliDAO = new ClienteDAO();
        System.out.println("fodac5");
        List<Cliente> clientes = cliDAO.all();
        System.out.println("Imprime todos os clientes:");
        for(int x = 0; x < clientes.size(); x++)
            System.out.printf("%s\n", clientes.get(x).toString());  

//        SolicitaCarro sC = new SolicitaCarro();
//        sC.setCliente(cli);
//        sC.setCarro(car);
//        sC.setDataRetirada(new GregorianCalendar(2018, 10, 28).getTime());
//        sC.setPrazoFinal(new GregorianCalendar(2018, 10, 28).getTime());
//        
//        cli.getSolicitaCarro().add(sC);
//        
//        ClienteDAO cliDAO2 = new ClienteDAO();
//        cliDAO2.update(cli);
//        
//        CarroDAO carDAO1 = new CarroDAO();
//        List<Carro> carros = carDAO1.all();
//        System.out.println("Imprime todos os carrros:");
//        for(int x = 0; x < carros.size(); x++)
//            System.out.printf("%s\n", carros.get(x).toString());
//    
//        CarroDAO carDAO2 = new CarroDAO();
//        Carro t = carDAO2.selectOne(1);
//        System.out.println("Imprime o carro com ID = 1");
//        System.out.println(t.toString());

//        ClienteDAO cliDAO = new ClienteDAO();
//        System.out.println("Busca o cliente com ID = 1");
//        Cliente c = cliDAO.selectOne(1);
//        System.out.println(c.toString());
//        
//        System.out.println("Imprime os carros solicitados pelo cliente buscado");
//        c.getSolicitaCarro().forEach((sC) -> {
//            System.out.println(sC.getCarro());
//        });
//        
//        System.out.println("Imprime os carros cedidos pelo cliente buscado");
//        c.getCarrosCedidos().forEach(System.out::println);
//        
        System.exit(0);
    }
}
