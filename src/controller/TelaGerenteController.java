package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import database.DAOs.SolicitaCarroDAO;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Caminho;
import model.ChangeScreen;
import model.Especificacoes;
import model.entities.relationships.SolicitaCarro;

public class TelaGerenteController implements Initializable {

    private static void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private Button gerarRelatorio;
    @FXML
    private TextField campoPesquisa;
    @FXML
    private Button gerenciaFunc;
    @FXML
    private Button gerenciaCarro;
    @FXML
    private Button gerenciaCli;
    @FXML
    private Button locarVeiculo;
    @FXML
    private TableColumn<SolicitaCarro, String> colunaNome;
    @FXML
    private TableColumn<SolicitaCarro, String> colunaPlaca;
    @FXML
    private TableColumn<SolicitaCarro, Date> colunaDataVenc;
    @FXML
    private TableView<SolicitaCarro> listaAluguel;
    
    private SolicitaCarro selecionado;
    
    public void initialize(URL url, ResourceBundle rb) {
        initTable();        
        listaAluguel.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (SolicitaCarro) newValue;  
                System.out.println(selecionado.toString());
            }
        });  
    }    

    @FXML
    private void geraRelatorio(ActionEvent event) throws Exception {
        Document doc = new Document();        
      
        PdfWriter.getInstance(doc, new FileOutputStream("p.pdf"));
        doc.open();
        SolicitaCarroDAO dao = new SolicitaCarroDAO();
        List<SolicitaCarro> car = dao.allf();
        
        doc.add(new Paragraph("                                     Relatorio dos Alugueis\n"));
        doc.add(new Paragraph("  "));
        for(int x=0; x<car.size();x++){
            if(car.get(x).isAtivo() == false){
            doc.add(new Paragraph("Data de Retirada: "+car.get(x).getDataEntrega()+
                    "       Data de Entrega: "+car.get(x).getDataEntrega()+
                    "       Valor do aluguel: "+car.get(x).getValor()));
            doc.add(new Paragraph("Carro: "+car.get(x).getCarro().getIdCarro()+
                    "       Placa: "+car.get(x).getCarro().getPlaca()+
                    "       Modelo: "+car.get(x).getCarro().getModelo()+
                    "       Chassi: "+car.get(x).getCarro().getChassi()));
            doc.add(new Paragraph("Cliente: "+car.get(x).getCliente().getIdPessoa()+
                    "       Nome: "+car.get(x).getCliente().getNome()+
                    "       CPF: "+ car.get(x).getCliente().getCpf()+
                    "       CNH: "+ car.get(x).getCliente().getCnh()));
            doc.add(new Paragraph("---------------------------------------------------------------------"));
            }
        }
        
        doc.close();
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setHeaderText("PDF Gerado com sucesso");
        a.show();  
    }

    @FXML
    private void gerenciaFunc(ActionEvent event) {
        try {
            ChangeScreen change = new ChangeScreen();            
            Stage mainStage = change.change(event, Caminho.telaGerFunc, Especificacoes.getSoftwareNome(), true);
            mainStage.show();
        } catch (Exception ex) {
            Logger.getLogger(TelaGerenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gerenciaCarro(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaGerenciaCarroController car = new TelaGerenciaCarroController();
        car.setJanela(true);
        Stage mainStage = change.change(event, Caminho.telaGerCarro, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void gerenciaCli(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaGerenciaCliController cli = new  TelaGerenciaCliController();
        cli.setJanela(true);
        Stage mainStage = change.change(event, Caminho.telaGerCli, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }

    @FXML
    private void locarVeiculo(ActionEvent event) throws Exception {
        ChangeScreen change = new ChangeScreen();
        TelaLocarVeiculosController locar = new  TelaLocarVeiculosController();
        locar.setJanela(true);
        Stage mainStage = change.change(event, Caminho.telaLocar, Especificacoes.getSoftwareNome(), true);
        mainStage.show();
    }
    
    public void initTable(){
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaPlaca.setCellValueFactory(new PropertyValueFactory("placa"));
        colunaDataVenc.setCellValueFactory(new PropertyValueFactory("vencimento"));
        listaAluguel.setItems(atualizaTabela());
    }
    
    public ObservableList<SolicitaCarro> atualizaTabela(){
        /*CarroDAO dao = new CarroDAO();
        return FXCollections.observableArrayList(dao.all());*/
        return null;
    }

    @FXML
    private void btPesquisa(ActionEvent event) {
    }
   
    @FXML
    private void itemSair(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Tem certeza que deseja sair?");
        alert.setContentText("Terá que logar novamente.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } 
        else { }
    }   
}
