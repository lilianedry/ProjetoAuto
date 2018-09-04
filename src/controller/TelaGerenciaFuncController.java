
package controller;

import controller.alerts.Alertas;
import controller.verificadores.verCPF;
import database.DAOs.FuncionarioDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.entities.Empregado;
import model.entities.Funcionario;
import model.entities.Pessoa;


public class TelaGerenciaFuncController extends Pessoa implements Initializable {
   
    @FXML
    private Button editaFunc;
    @FXML
    private Button removeFunc;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCPF;
    @FXML
    private Button insereFunc;
    @FXML
    private Button voltar;
    @FXML
    private TableView<?> listaFunc;
    @FXML
    private RadioButton campoMasc;
    @FXML
    private RadioButton campoFem;
    @FXML
    private TextField campoNome;
    @FXML
    private TextField campoRG;
    @FXML
    private TextField campoCPF;
    @FXML
    private TextField campoTel;
    @FXML
    private TextField campoRua;
    @FXML
    private TextField campoNumCasa;
    @FXML
    private DatePicker campoDataNasc;
    @FXML
    private TextField campoBairro;
    @FXML
    private TextField campoCargo;
    @FXML
    private TextField campoSalario;
    @FXML
    private DatePicker campoDataEnt;
    @FXML
    private TextField campoHoraSemana;
    @FXML
    private TextField campoCidade;
    @FXML
    private TextField campoEstado;
    @FXML
    private TextField campoLogin; //não tem no banco
    @FXML
    private TextField campoSenha;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML 
    private void insereFunc(ActionEvent event) {
        Empregado func = new Empregado();  
        
        func.setLogin(campoLogin.getText());
        func.setSenha(campoSenha.getText());
        func.setNome(campoNome.getText());
        
        try {
            if (campoRG.getText().length()>10)
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            Alertas.mostraAlertaInfo("Erro no campo RG!", "Digite um RG válido.");
                return;
        }
        func.setRg(campoRG.getText());
        func.setTelefone(campoTel.getText());
        func.setRua(campoRua.getText());
        func.setCidade(campoCidade.getText());        
        func.setEstado(campoEstado.getText());
        func.setBairro(campoBairro.getText());
        func.setCargo(campoCargo.getText());   
        func.setNumCasa(campoNumCasa.getText()); 
        func.setSalario(campoSalario.getText()); 
        func.setCargaHorSem(campoHoraSemana.getText());
               
        try {
            if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
                    throw new IllegalArgumentException();
	} catch (IllegalArgumentException e) {
            Alertas.mostraAlertaInfo("Erro no campo CPF!", "Digite um CPF válido.");
		return;
	}
       /*verifica no banco
        try {
            if (func.cpfNoArray(campoCPF.getText().trim()))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("No campo CPF do Aluno", "O CPF informado j� est� cadastrado.");
                return;
        }*/   
        func.setCpf(campoCPF.getText());
        if(campoMasc.isSelected()){
            func.setSexo("M");
        }
        if(campoFem.isSelected()){
            func.setSexo("F");
        }
        LocalDate data = campoDataNasc.getValue();
        Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
        func.setDataNascimento(nasc);
        
        LocalDate data2 = campoDataEnt.getValue();
        Date entra = Date.from(data2.atStartOfDay(ZoneId.systemDefault()).toInstant());
        func.setDataEntrada(entra); 
        
        
       
        Alertas.mostraAlertaInfo("Cadastro de Funcionario", "Cadastro realizado com sucesso!");
		
        FuncionarioDAO FuncDAO = new FuncionarioDAO();
        FuncDAO.add(func);
    }
    
    @FXML
    private void editaFunc(ActionEvent event) {
    
    }

    @FXML
    private void removeFunc(ActionEvent event) {
        
    
    } 
    
    @FXML
    private void voltar(ActionEvent event) {
        System.out.println("Voltando de Cadastro para Login");
        Stage stage = new Stage();  
            try{
                Parent root = FXMLLoader.load(getClass().getResource("../view/TelaGerente.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Titulo");
                stage.show();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                stage = (Stage) voltar.getScene().getWindow();
                stage.close(); //fecha a pagina atual antes de sair
            }
    }
    
}
