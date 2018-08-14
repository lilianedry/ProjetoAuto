package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.alertas.Alertas;
import controller.verificadores.verCPF;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ArrayLists;
import model.Caminho;
import model.ChangeScreen;
import model.Email;
import model.Especificacoes;
import model.entidades.Aluno;
import model.entidades.DocumentoAluno;
import model.entidades.Familiar;
import model.entidades.TipoOfertaBolsa;

public class TelaAlunosCadastroController {

	List<Familiar> familiares = new ArrayList<Familiar>();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Tab abaIdade;

	@FXML
	private CheckBox boxIdade;

	@FXML
	private Tab abaPessoal;

	@FXML
	private TextField campoNomeAluno;

	@FXML
	private TextField campoCPFAluno;

	@FXML
	private TextField campoRGAluno;

	@FXML
	private TextField campoMatAluno;

	@FXML
	private CheckBox boxAtestatoMatriculaAluno;

	@FXML
	private CheckBox boxCarteiraDeTrabalhoAluno;

	@FXML
	private CheckBox boxExtratoBancarioAluno;

	@FXML
	private TextField campoEmailAluno;

	@FXML
	private TextField campoNumeroFamiliaresAluno;

	@FXML
	private TextField campoDistanciaCidadeAluno;

	@FXML
	private TextField campoRendaBrutaAluno;

	@FXML
	private CheckBox boxFamiliares;

	private List<TipoOfertaBolsa> lista = new ArrayList<>();

	private ObservableList<TipoOfertaBolsa> olista;

	@FXML
	private ComboBox<TipoOfertaBolsa> comboTipoOfertaAluno;

	@FXML
	private CheckBox boxFormularioInscricaoAluno;

	@FXML
	private CheckBox boxComprovanteInscricaoAluno;

	@FXML
	private CheckBox boxAuxilioAluno;

	@FXML
	private CheckBox boxDocEstadoCivilAluno;

	@FXML
	private CheckBox boxSUSAluno;

	@FXML
	private CheckBox boxHistoricoEscolarAluno;

	@FXML
	private Tab abaFamiliar;

	@FXML
	private TextField campoParentescoFamiliar;

	@FXML
	private CheckBox boxRGFamiliar;

	@FXML
	private TextField campoCPFFamiliar;

	@FXML
	private TextField campoRGFamiliar;

	@FXML
	private CheckBox boxCarteiraDeTrabalhoFamiliar;

	@FXML
	private CheckBox boxCertidaoFamiliar;

	@FXML
	private CheckBox boxComprovanteRendaFamiliar;

	@FXML
	private CheckBox boxDecImpostoRendaFamiliar;

	@FXML
	private CheckBox boxExtratoBancarioFamiliar;

	@FXML
	private Tab abaEconomico;

	@FXML
	private CheckBox boxDispEnergia;

	@FXML
	private CheckBox boxDispAgua;

	@FXML
	private CheckBox boxDispTelefone;

	@FXML
	private CheckBox boxDispInternet;

	@FXML
	private CheckBox boxDispOutro;

	@FXML
	private CheckBox boxDispSaude;

	@FXML
	private Button botaoCancelar;

	@FXML
	private Button botaoAdicionar;

	@FXML
	private Button botaoCadastrar;

	public void carregaTipoOfertaAluno() throws Exception {
		comboTipoOfertaAluno.setItems(GerarComboBoxModalidade.gerarCadastradas(lista, olista));
	}

	@FXML
	public void cliqueBotaoAdicionar(ActionEvent event) throws Exception {
		Familiar temp = pegaFamiliar();
		familiares.add(temp);
		campoParentescoFamiliar.clear();
		campoCPFFamiliar.clear();
		campoRGFamiliar.clear();
		boxRGFamiliar.selectedProperty().set(false);
		boxCarteiraDeTrabalhoFamiliar.selectedProperty().set(false);
		boxCertidaoFamiliar.selectedProperty().set(false);
		boxComprovanteRendaFamiliar.selectedProperty().set(false);
		boxDecImpostoRendaFamiliar.selectedProperty().set(false);
		boxExtratoBancarioFamiliar.selectedProperty().set(false);

	}
	
	public void insereNoArray(Aluno aln, DocumentoAluno docA) {
		if (aln.isCarteiraTrabalho() && aln.isExtratoBancario() && docA.isAtestDeMatricula() && docA.isCompInscricao()
				&& docA.isDispesaMoradia() && docA.isDocSUS() && docA.isFormInscricao() && docA.isHistoricoEscolar()) {
			aln.adicionaFamiliar(familiares);
			ArrayLists.adicionaAlunoApto(aln);
		} else {
			aln.adicionaFamiliar(familiares);
			ArrayLists.adicionaAluno(aln);
		}
	}
	
	@FXML
	void cliqueBotaoCadastrar(ActionEvent event) throws Exception {
		Aluno aln = new Aluno();
		DocumentoAluno docA = new DocumentoAluno();

		TipoOfertaBolsa of = comboTipoOfertaAluno.getSelectionModel().getSelectedItem();
		aln.setTipoOferta(of.getId());
		aln.setNomePessoa(campoNomeAluno.getText());
		aln.setDistanciaCidade(Float.parseFloat(campoDistanciaCidadeAluno.getText()));
		aln.setRendaBruta(Float.parseFloat(campoRendaBrutaAluno.getText()));
		aln.setMatriculaAluno(Integer.parseInt(campoMatAluno.getText()));
		aln.setEmail(campoEmailAluno.getText());
		try {
			if (!(verCPF.isValidCPF(campoCPFAluno.getText().trim())))
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF válido.");
			return;
		}
		try {
			if (ArrayLists.cpfNoArray(campoCPFAluno.getText().trim()))
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			Alertas.mostraAlertaInfo("No campo CPF do Aluno", "O CPF informado já está cadastrado.");
			return;
		}
		aln.setCPFPessoa(campoCPFAluno.getText().trim());
		aln.setRGPessoa(campoRGAluno.getText());
		aln.setCarteiraTrabalho(boxCarteiraDeTrabalhoAluno.isSelected());
		aln.setExtratoBancario(boxExtratoBancarioAluno.isSelected());
		Email.emitirEmailCadastro(aln.email, of.getNome(), aln.nomePessoa);

		docA.setCpfAluno(aln.getCPFPessoa());
		docA.setAtestDeMatricula(boxAtestatoMatriculaAluno.isSelected());
		docA.setCompInscricao(boxComprovanteInscricaoAluno.isSelected());
		docA.setHistoricoEscolar(boxHistoricoEscolarAluno.isSelected());
		docA.setFormInscricao(boxFormularioInscricaoAluno.isSelected());
		docA.setDocSUS(boxSUSAluno.isSelected());
		docA.setDocRecebeAuxilio(boxAuxilioAluno.isSelected());
		docA.setDispesaSaude(boxDispSaude.isSelected());
		docA.setDispesaMoradia((boxDispAgua.isSelected()) && (boxDispEnergia.isSelected()));
		if (boxRGFamiliar.isSelected()) {
			try {
				if (verCPF.isValidCPF(campoCPFFamiliar.getText().trim()) == false)
					throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				Alertas.mostraAlertaInfo("No campo CPF", "Digite um CPF do familiar válido.");
				return;
			}
		}
		aln.setNumFamiliares(familiares.size());
		insereNoArray(aln, docA);
		Alertas.mostraAlertaInfo("Cadastro de Alunos", "Cadastro realizado com sucesso");
		fecharTela(event);

	}

	public Familiar pegaFamiliar() {
		Familiar f = new Familiar();
		f.setCpfAluno(campoCPFAluno.getText().trim());
		f.setParentesco(campoParentescoFamiliar.getText().trim());
		if (boxRGFamiliar.isSelected()) {

			f.setCPFPessoa(campoCPFFamiliar.getText().trim());
			f.setRGPessoa(campoRGFamiliar.getText().trim());

			f.setCarteiraTrabalho(boxCarteiraDeTrabalhoFamiliar.isSelected());
			f.setExtratoBancario(boxExtratoBancarioFamiliar.isSelected());

			f.docF.setCertidao(boxCertidaoFamiliar.isSelected());
			f.docF.setComprRenda(boxComprovanteRendaFamiliar.isSelected());
			f.docF.setDecImpRenda(boxDecImpostoRendaFamiliar.isSelected());
		} else {
			f.setCarteiraTrabalho(true);
			f.setExtratoBancario(true);
			f.docF.setCertidao(true);
			f.docF.setComprRenda(true);
			f.docF.setDecImpRenda(true);
		}
		return f;
	}

	@FXML
	void cliqueBotaoCancelar(ActionEvent event) throws Exception {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmação");
		alert.setHeaderText("Tem certeza que deseja cancelar?");
		alert.setContentText("Todas as alterações feitas até aqui serão perdidas!");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK)
			fecharTela(event);
	}

	private void fecharTela(ActionEvent event) throws Exception {
		ChangeScreen change = new ChangeScreen();

		Stage alunosStage = change.change(event, Caminho.telaAlunos, Especificacoes.getSoftwareNome(), true);
		alunosStage.show();
	}

	public void desabilitaCampoFamiliar(boolean set) {
		this.campoCPFFamiliar.setDisable(set);
		this.campoRGFamiliar.setDisable(set);
		this.boxCarteiraDeTrabalhoFamiliar.setDisable(set);
		this.boxCertidaoFamiliar.setDisable(set);
		this.boxComprovanteRendaFamiliar.setDisable(set);
		this.boxDecImpostoRendaFamiliar.setDisable(set);
		this.boxExtratoBancarioFamiliar.setDisable(set);
	}

	public void desabilitaCampoAluno(boolean set) {
		boxCarteiraDeTrabalhoAluno.setDisable(set);
	}

	@FXML
	void initialize() throws Exception {
		carregaTipoOfertaAluno();
		botaoCadastrar.setDisable(true);
		botaoAdicionar.setDisable(true);
		abaFamiliar.setDisable(true);
		desabilitaCampoAluno(true);
		desabilitaCampoFamiliar(true);

		boxRGFamiliar.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue)
					desabilitaCampoFamiliar(false);
				else
					desabilitaCampoFamiliar(true);
			}
		});

		boxFamiliares.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue)
					abaFamiliar.setDisable(false);
				else
					abaFamiliar.setDisable(true);
			}
		});

		boxIdade.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue)
					desabilitaCampoAluno(false);
				else
					desabilitaCampoAluno(true);
			}
		});

		abaEconomico.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue)
					botaoCadastrar.setDisable(false);
				else
					botaoCadastrar.setDisable(true);

			}
		});

		abaFamiliar.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (newValue)
					botaoAdicionar.setDisable(false);
				else
					botaoAdicionar.setDisable(true);
			}

		});

	}
}
