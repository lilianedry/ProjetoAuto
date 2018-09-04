/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.alerts.Alertas;
import controller.verificadores.verCPF;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Carro;
import model.entities.Cliente;
import model.entities.relationships.SolicitaCarro;
/**
 * FXML Controller class
 *
 * @author lilia
 */
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
    private Button botaoPesquisa;
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

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void locarVeiculo(ActionEvent event) {
        Carro car = new Carro();
        Cliente cli = new Cliente();
        SolicitaCarro sol = new SolicitaCarro();
        
        /*try {
            if (!(verCPF.isValidCPF(campoCPFCli.getText().trim())))
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF válido.");
                return;
        }
        cli.setCpf(campoCPFCli.getText()); 
        
        car.setPlaca(campoPlaca.getText());        
        LocalDate data = campoDataRetira.getValue();
        Date retira = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        car.setDataCede(retira);
        
        LocalDate data2 = campoDataEntrega.getValue();
        Date entrega = Date.from(data2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        car.setDataCede(entrega);
        
        LocalDate data3 = campoPrazoFinal.getValue();
        Date prazo = Date.from(data3.atStartOfDay(ZoneId.systemDefault()).toInstant());
        car.setDataCede(entrega);
        
        sol.setCliente(cli);
        sol.setCarro(car);
        sol.setDataRetirada(retira);
        sol.setDataEntrega(entrega);
        sol.setPrazoFinal(prazo);
        sol.setValor(null);
        */
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
    
}
