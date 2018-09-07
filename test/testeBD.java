
import database.DAOs.CarroDAO;
import database.DAOs.ClienteDAO;
import java.time.Instant;
import java.util.Date;
import model.entities.Carro;
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
        //Como inserir cliente e carro
//        Cliente cli = new Cliente("teste", "teste", "teste", "teste", Date.from(Instant.now()), "teste", "250",
//                "teste", "teste", "teste", "teste", "teste", "teste");
//
//        ClienteDAO cliDAO1 = new ClienteDAO();
//        cliDAO1.add(cli);
//
//        Carro car = new Carro("teste", "teste", "teste", "teste", "2018", "teste",
//                "teste", "1000", "teste");
//        car.setCliente(cli);
//        car.setDataCede(Date.from(Instant.now()));
//        cli.getCarrosCedidos().add(car);
//
//        CarroDAO carDAO1 = new CarroDAO();
//        carDAO1.add(car);

        //Pesquisa de cliente
        Cliente aux = new Cliente();
        aux.setCpf("teste");
        ClienteDAO cliDAO2 = new ClienteDAO();
        System.out.println(aux);
        Cliente cliSel = cliDAO2.selectParam(aux).get(0);
        if(cliSel != null)
            System.out.println(cliSel);
        else
            System.out.println("Cliente não encontrado.");

//        Empregado emp = new Empregado("teste", "teste", "teste", "teste", Date.from(Instant.now()), "teste", "teste",
//            "teste", "teste", "teste", "teste", "teste", "teste", "teste",
//            "teste", Date.from(Instant.now()));
//        EmpregadoDAO empDAO1 = new EmpregadoDAO();
//        empDAO1.add(emp);
//
//        System.out.println("fodac4");
//        ClienteDAO cliDAO = new ClienteDAO();
//        System.out.println("fodac5");
//        List<Cliente> clientes = cliDAO.all();
//        System.out.println("Imprime todos os clientes:");
//        for(int x = 0; x < clientes.size(); x++)
//            System.out.printf("%s\n", clientes.get(x).toString());  

//        EmpregadoDAO empDAO = new EmpregadoDAO();
//        List<Empregado> emps = empDAO.all();
//        
//        for(int x = 0; x < emps.size(); x++)
//            System.out.printf("%s\n", emps.get(x).toString());

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
//            System.out.printf("%s\n", carros.get(x).to"teste"());
//    
//        CarroDAO carDAO2 = new CarroDAO();
//        Carro t = carDAO2.selectOne(1);
//        System.out.println("Imprime o carro com ID = 1");
//        System.out.println(t.to"teste"());

//        ClienteDAO cliDAO = new ClienteDAO();
//        System.out.println("Busca o cliente com ID = 1");
//        Cliente c = cliDAO.selectOne(1);
//        System.out.println(c.to"teste"());
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
