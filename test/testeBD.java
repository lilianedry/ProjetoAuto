
import database.DAOs.ClienteDAO;
import database.DAOs.EmpregadoDAO;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import model.entities.Cliente;
import model.entities.Empregado;
import model.entities.relationships.GerenciaCliente;

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
//        Empregado emp6 = new Empregado("teste", "teste", "teste", "teste", Date.from(Instant.now()), "teste", "250",
//                "teste", "teste", "teste", "teste", "teste", "teste", "teste", "teste", Date.from(Instant.now()));
//        EmpregadoDAO empDAO5 = new EmpregadoDAO();
//        empDAO5.add(emp6);
////
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

        //Você tem um objeto Cliente
        ClienteDAO cliDAO = new ClienteDAO();
        List<Cliente> clientes = cliDAO.all();
        Cliente cliSel = clientes.get(0);
        //E um empregado
        EmpregadoDAO empDAO = new EmpregadoDAO();
        List<Empregado> emps = empDAO.all();
        Empregado empSel = emps.get(0);
        //Cria um obj GerenciaCliente
        GerenciaCliente gC = new GerenciaCliente();
        //Seta os campos
        gC.setFuncionario(empSel);
        gC.setCliente(cliSel);
        gC.setDataAcesso(Date.from(Instant.now()));
        //Configura
        empSel.getGerenciaCliente().add(gC);
        //E dá update
        EmpregadoDAO empDAO2 = new EmpregadoDAO();
        empDAO2.update(empSel);
        
        //Erros que podem vir a aparecer são de dados faltando nos objetos.
        //Exemplo: Atributo 'emprestado' de 'Carro' ser 'null'
        System.exit(0);
    }
}
