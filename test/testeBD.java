
import database.DAOs.CarroDAO;
import database.DAOs.ClienteDAO;
import java.time.Instant;
import java.util.Date;
import model.entities.Carro;
import model.entities.Cliente;
import model.entities.relationships.SolicitaCarro;

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
                "teste", "teste", "teste", "teste", "teste");
        Carro car = new Carro("teste", "teste", "teste", "teste", "2018", "teste",
                "teste", "1000", "teste");

        ClienteDAO cliDAO1 = new ClienteDAO();
        cliDAO1.add(cli);
        
        car.setCliente(cli);
        cli.getCarrosCedidos().add(car);

        CarroDAO carDAO = new CarroDAO();
        carDAO.add(car);

        SolicitaCarro sC = new SolicitaCarro();
        sC.setCliente(cli);
        sC.setCarro(car);
        sC.setDataSolicitacao(Date.from(Instant.now()));
        
        cli.getSolicitaCarro().add(sC);
        
        ClienteDAO cliDAO2 = new ClienteDAO();
        cliDAO2.update(cli);
    }

}
