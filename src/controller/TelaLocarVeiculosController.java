/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.alerts.Alertas;
import database.DAOs.CarroDAO;
import database.DAOs.ClienteDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Carro;
import model.entities.Cliente;
import model.entities.relationships.SolicitaCarro;

public class TelaLocarVeiculosController implements Initializable {
    private static boolean janela;

    public static boolean getJanela() {
        return janela;
    }

    public static void setJanela(boolean janela) {
        TelaLocarVeiculosController.janela = janela;
    }
    
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TextField campoCPFCli;
    @FXML
    private TextField campoPlaca;
    @FXML
    private DatePicker campoDataRetira;
    @FXML
    private DatePicker campoDataEntrega;
    @FXML
    private DatePicker campoPrazoFinal;
    @FXML
    private Button locarVeiculo;
    @FXML
    private Button devolveVeiculo;
    @FXML
    private Button voltar;
    @FXML
    private TextField campoValor;
    @FXML
    private TableView<?> listaAlunos;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCPF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void locarVeiculo(ActionEvent event) {
    Cliente aux = new Cliente();
        aux.setCpf(campoCPFCli.getText());
        ClienteDAO cliDAO2 = new ClienteDAO();
        System.out.println(aux);
        Cliente cli = cliDAO2.selectParam(aux).get(0);
     
    Carro auxCar = new Carro();
        auxCar.setPlaca(campoPlaca.getText());
        CarroDAO carDAO = new CarroDAO();
        Carro car = carDAO.selectParam(auxCar).get(0);
        
    SolicitaCarro sC = new SolicitaCarro();
        sC.setCliente(cli);
        sC.setCarro(car);
        
        LocalDate data = campoDataRetira.getValue();        
        Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        sC.setDataRetirada(nasc);
        
        LocalDate data1 = campoDataEntrega.getValue();
        Date nasc1 = Date.from(data1.atStartOfDay(ZoneId.systemDefault()).toInstant());
        sC.setDataEntrega(nasc1);
        
        LocalDate data2 = campoPrazoFinal.getValue();
        Date nasc2 = Date.from(data2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        sC.setPrazoFinal(nasc2);
        
        sC.setValor(campoValor.getText());
        
        cli.getSolicitaCarro().add(sC);
        
        ClienteDAO cliDAO3 = new ClienteDAO();
        cliDAO3.update(cli);        
        
        Alertas.mostraAlertaInfo("Locação de Veículo", "Locação realizada com sucesso!");
	
    }

    @FXML
    private void devolveVeiculo(ActionEvent event) {
        /*SolicitaCarro sol = new SolicitaCarro();
        
        sol.setValor(campoValor.getText()); // inserir valor somente na entrega*/
        
        Alertas.mostraAlertaInfo("Devolução", "Devolução realizada com sucesso!");		
    }

    @FXML
    private void voltar(ActionEvent event) {
       if(janela == true){
            ChangeScreen change = new ChangeScreen();

            Stage mainStage;
            try {
                mainStage = change.change(event, Caminho.telaGerente, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            } catch (Exception ex) {
                Logger.getLogger(TelaGerenciaCarroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
             ChangeScreen change = new ChangeScreen();

            Stage mainStage;
            try {
                mainStage = change.change(event, Caminho.telaFunc, Especificacoes.getSoftwareNome(), true);
                mainStage.show();
            } catch (Exception ex) {
                Logger.getLogger(TelaGerenciaCarroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btPesquisa(ActionEvent event) {
    }


    
}
