
package controller;

import controller.alerts.Alertas;
import controller.verificadores.verCPF;
import database.DAOs.ClienteDAO;
import database.DAOs.FuncionarioDAO;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.entities.Cliente;
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
    private TableColumn<Funcionario, String> colunaNome;
    @FXML
    private TableColumn<Funcionario, String> colunaCPF;
    @FXML
    private Button insereFunc;
    @FXML
    private Button voltar;
    @FXML
    private TableView<Funcionario> listaFunc;
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
    
    private Funcionario selecionado;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        listaFunc.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               selecionado = (Funcionario) newValue;  
                System.out.println(selecionado.toString());
            }
        });  
    }    
    
    @FXML 
    private void insereFunc(ActionEvent event) {
        if(selecionado != null){
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
        func.setAtivo(true);
        func.setIdPessoa(selecionado.getIdPessoa());
               
        try {
            if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
                    throw new IllegalArgumentException();
	} catch (IllegalArgumentException e) {
            Alertas.mostraAlertaInfo("Erro no campo CPF!", "Digite um CPF válido.");
		return;
	}
        
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
        
        FuncionarioDAO FuncDAO = new FuncionarioDAO();
        FuncDAO.update(func);
       
        listaFunc.setItems(atualizaTabela());
        Alertas.mostraAlertaInfo("Cadastro de Funcionario", "Cadastro realizado com sucesso!");
        }else{
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
        func.setAtivo(true);
               
        try {
            if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
                    throw new IllegalArgumentException();
	} catch (IllegalArgumentException e) {
            Alertas.mostraAlertaInfo("Erro no campo CPF!", "Digite um CPF válido.");
		return;
	}
        
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
        
        FuncionarioDAO FuncDAO = new FuncionarioDAO();
        FuncDAO.add(func);
       
        listaFunc.setItems(atualizaTabela());
        Alertas.mostraAlertaInfo("Cadastro de Funcionario", "Cadastro realizado com sucesso!");	
        }
    }
    
    @FXML
    private void editaFunc(ActionEvent event) {
        campoLogin.setText(selecionado.getLogin());
        campoSenha.setText(selecionado.getSenha());
        campoNome.setText(selecionado.getNome());
        campoRG.setText(selecionado.getRg());
        campoTel.setText(selecionado.getTelefone());
        campoRua.setText(selecionado.getRua());
        campoCidade.setText(selecionado.getCidade());
        campoEstado.setText(selecionado.getEstado());
        campoBairro.setText(selecionado.getBairro());
        campoCargo.setText(selecionado.getCargo());
        campoNumCasa.setText(selecionado.getNumCasa());
        campoSalario.setText(selecionado.getSalario());
        campoHoraSemana.setText(selecionado.getCargaHorSem());
        campoCPF.setText(selecionado.getCpf());
        
    }

    @FXML
    private void removeFunc(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Tem certeza que deseja excluir o funcionário?");
        alert.setContentText("Todos os dados serão deletados do banco de dados");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
                remove(event);
        } else {
        }
    }
    private void remove(ActionEvent event) throws Exception {
      if(selecionado != null){
          deleta();
          Alert a = new Alert(Alert.AlertType.CONFIRMATION);
          a.setHeaderText("Cliente excluído com Sucesso");
          a.show();
          listaFunc.setItems(atualizaTabela());    
      }else{
          Alert a = new Alert(Alert.AlertType.WARNING);
          a.setHeaderText("Selecione um Funcionario");
          a.show();
      }        
   }
    public void deleta(){
        FuncionarioDAO dao = new FuncionarioDAO();
        selecionado.setAtivo(false);
        dao.update(selecionado);
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
    
    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        listaFunc.setItems(atualizaTabela());
    }
    
     public ObservableList<Funcionario> atualizaTabela(){
         FuncionarioDAO dao = new FuncionarioDAO();
         return FXCollections.observableArrayList(dao.all());
     }
    
}
