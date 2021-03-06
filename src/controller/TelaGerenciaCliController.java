package controller;

import controller.alerts.Alertas;
import controller.verificadores.verCPF;
import database.DAOs.ClienteDAO;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.Cliente;

public class TelaGerenciaCliController implements Initializable {
    private static boolean janela;

    public static boolean getJanela() {
        return janela;
    }
    public static void setJanela(boolean janela) {
        TelaGerenciaCliController.janela = janela;
    }

    @FXML
    private TextField campoPesquisa;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaCPF;
    @FXML
    private Button voltar;
    @FXML
    private Button editaCli;
    @FXML
    private Button removeCli;
    @FXML
    private Button insereCli;
    @FXML
    private TableView<Cliente> listaClientes;
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
    private TextField campoBairro;
    @FXML
    private TextField campoNum;
    @FXML
    private TextField campoCnh;
    @FXML
    private TextField campoRua;
    @FXML
    private DatePicker campoDataNasc;
    @FXML
    private TextField campoCidade;
    @FXML
    private TextField campoEstado;
    @FXML
    private TextField campoEmail;
    
    private Cliente selecionado;
    
    private ObservableList<Cliente> clients = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
        
        listaClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (Cliente) newValue;  
                System.out.println(selecionado.toString());
            }
        });  
    }    
        
    public void initCliente(){
        campoRG.setText(selecionado.getRg());
        campoBairro.setText(selecionado.getBairro());
        campoCidade.setText(selecionado.getCidade());
        campoEstado.setText(selecionado.getEstado());
        campoEmail.setText(selecionado.getEmail());
        campoTel.setText(selecionado.getTelefone());
        campoCnh.setText(selecionado.getCnh());
    }
    
    @FXML
    void btPesquisa(ActionEvent event) {
        listaClientes.setItems(busca());
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
    private void editaCli(ActionEvent event) {
        if(selecionado==null){
            try {
                if (selecionado==null)
                        throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("Edição de Funcionário", "Clique em um funcionário para editar!");	
                    return;
            }
        }
        else{
            campoNome.setText(selecionado.getNome());
            campoCPF.setText(selecionado.getCpf());
            campoRua.setText(selecionado.getRua());
            campoNum.setText(selecionado.getNumCasa());
            campoRG.setText(selecionado.getRg());
            campoBairro.setText(selecionado.getBairro());
            campoCidade.setText(selecionado.getCidade());
            campoEstado.setText(selecionado.getEstado());
            campoEmail.setText(selecionado.getEmail());
            campoTel.setText(selecionado.getTelefone());
            campoCnh.setText(selecionado.getCnh());
        }        
    }

    @FXML
    private void removeCli(ActionEvent event) throws Exception {
        if(selecionado!=null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Tem certeza que deseja excluir o cliente?");
            alert.setContentText("Todos os dados serão deletados do banco de dados");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                    remove(event);
            } 
            else { }
        }
        else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione um Cliente");
            a.setContentText("Cliente não selecionado!");
            a.show();
        }
    }
    private void remove(ActionEvent event) throws Exception {
        deleta();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("Cliente excluído com Sucesso");
        a.show();
        listaClientes.setItems(atualizaTabela());
    }
     public void deleta(){
        ClienteDAO cli = new ClienteDAO();
        selecionado.setAtivo(false);
        cli.update(selecionado);
    }

    @FXML
    private void insereCli(ActionEvent event) {
        if(selecionado != null){
            Cliente cli = new Cliente();

            cli.setNome(campoNome.getText()); 
            try {
                if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                    Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF válido.");
                    return;
            }
            cli.setCpf(campoCPF.getText()); 

            if(campoMasc.isSelected()){
                cli.setSexo("M");
            }
            if(campoFem.isSelected()){
                cli.setSexo("F");
            }
            cli.setRua(campoRua.getText());
            cli.setNumCasa(campoNum.getText());

            try {
                if (campoRG.getText().length()>10)
                    throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("Erro no campo RG!", "Digite um RG válido.");
                    return;
            }
            cli.setIdPessoa(selecionado.getIdPessoa());
            cli.setRg(campoRG.getText());        
            cli.setBairro(campoBairro.getText());
            cli.setCidade(campoCidade.getText());
            cli.setEstado(campoEstado.getText());
            cli.setEmail(campoEmail.getText());
            cli.setTelefone(campoTel.getText());
            cli.setCnh(campoCnh.getText());
            cli.setAtivo(true);

            LocalDate data = campoDataNasc.getValue();
            Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
            cli.setDataNascimento(nasc);

            ClienteDAO cliDAO = new ClienteDAO();
            cliDAO.update(cli);
            listaClientes.setItems(atualizaTabela());
            Alertas.mostraAlertaInfo("Edição de Clientes", "Edição realizado com sucesso!");
        }
        else{
            Cliente cli = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            List<Cliente> fun = dao.all();
            
            try {
                if (!(verCPF.isValidCPF(campoCPF.getText().trim())))
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF válido.");
                return;
            }
            cli.setCpf(campoCPF.getText()); 
            
            for(int x=0; x<fun.size() ; x++){
                
                if (!campoCPF.getText().equals(fun.get(x).getCpf())){                    
                    if(x == fun.size()-1){
                        cli.setNome(campoNome.getText()); 
                        if(campoMasc.isSelected()){
                            cli.setSexo("M");
                        }
                        if(campoFem.isSelected()){
                            cli.setSexo("F");
                        }
                        cli.setRua(campoRua.getText());
                        cli.setNumCasa(campoNum.getText());
                        try {
                            if (campoRG.getText().length()>10)
                                throw new IllegalArgumentException();
                        } catch (IllegalArgumentException e) {
                            Alertas.mostraAlertaInfo("Erro no campo RG!", "Digite um RG válido.");
                                return;
                        }
                        cli.setRg(campoRG.getText());        
                        cli.setBairro(campoBairro.getText());
                        cli.setCidade(campoCidade.getText());
                        cli.setEstado(campoEstado.getText());
                        cli.setEmail(campoEmail.getText());
                        cli.setTelefone(campoTel.getText());
                        cli.setCnh(campoCnh.getText());
                        cli.setAtivo(true);
                        LocalDate data = campoDataNasc.getValue();
                        Date nasc = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
                        cli.setDataNascimento(nasc);

                        ClienteDAO cliDAO = new ClienteDAO();
                        cliDAO.add(cli);
                        listaClientes.setItems(atualizaTabela());
                        Alertas.mostraAlertaInfo("Cadastro de Clientes", "Cadastro realizado com sucesso!");   
                    }
                }                   
                else{
                    Alertas.mostraAlertaInfo("Cadastro de Clientes", "CPF já cadastrado!!");  
                    break;                    
                }
            }
        }        
    }    
    
    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        listaClientes.setItems(atualizaTabela());
    }
    
    public ObservableList<Cliente> atualizaTabela(){
        ClienteDAO dao = new ClienteDAO();
        clients = FXCollections.observableArrayList(dao.all());
        return clients;
    }
    
    private ObservableList<Cliente> busca(){
        ObservableList<Cliente> empPesquisa = FXCollections.observableArrayList();
        for(int x = 0; x<clients.size(); x++){
            if(clients.get(x).getNome().toLowerCase().contains(campoPesquisa.getText().toLowerCase())){
                empPesquisa.add(clients.get(x));
            }
        }
        return empPesquisa;
    }
}