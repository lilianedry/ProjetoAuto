package controller;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entidades.OfertaBolsa;
import model.entidades.TipoOfertaBolsa;
import model.ArrayLists;

public class GerarComboBoxModalidade {

	public static ObservableList<TipoOfertaBolsa> gerar(List<TipoOfertaBolsa> lista,
			ObservableList<TipoOfertaBolsa> olista) {

		TipoOfertaBolsa t1 = new TipoOfertaBolsa(1, "Permanência Acadêmica");
		TipoOfertaBolsa t2 = new TipoOfertaBolsa(2, "Apoio ao Esporte");
		TipoOfertaBolsa t3 = new TipoOfertaBolsa(3, "Aux. ao Portador de Necessidades Especiais");
		TipoOfertaBolsa t4 = new TipoOfertaBolsa(4, "Aux. Alimentação");
		TipoOfertaBolsa t5 = new TipoOfertaBolsa(5, "Aux. Didático-Pedagógico");
		TipoOfertaBolsa t6 = new TipoOfertaBolsa(6, "Aux. Transporte");
		TipoOfertaBolsa t7 = new TipoOfertaBolsa(7, "Aux. Creche");
		TipoOfertaBolsa t8 = new TipoOfertaBolsa(8, "Aux. Moradia");
		TipoOfertaBolsa t9 = new TipoOfertaBolsa(9, "Moradia Estudantil");

		lista.add(t1);
		lista.add(t2);
		lista.add(t3);
		lista.add(t4);
		lista.add(t5);
		lista.add(t6);
		lista.add(t7);
		lista.add(t8);
		lista.add(t9);

		olista = FXCollections.observableArrayList(lista);

		return olista;

	}

	public static ObservableList<TipoOfertaBolsa> gerarCadastradas(List<TipoOfertaBolsa> lista,
			ObservableList<TipoOfertaBolsa> olista) {

		if (!(ArrayLists.tobArray.isEmpty())) {
			for (OfertaBolsa a : ArrayLists.tobArray) {
				switch (a.getTipoOferta()) {
				case 1:
					lista.add(new TipoOfertaBolsa(1, "Permanência Acadêmica"));
					break;
				case 2:
					lista.add(new TipoOfertaBolsa(2, "Apoio ao Esporte"));
					break;
				case 3:
					lista.add(new TipoOfertaBolsa(3, "Aux. ao Portador de Necessidades Especiais"));
					break;
				case 4:
					lista.add(new TipoOfertaBolsa(4, "Aux. Alimentação"));
					break;
				case 5:
					lista.add(new TipoOfertaBolsa(5, "Aux. Didático-Pedagógico"));
					break;
				case 6:
					lista.add(new TipoOfertaBolsa(6, "Aux. Transporte"));
					break;
				case 7:
					lista.add(new TipoOfertaBolsa(7, "Aux. Creche"));
					break;
				case 8:
					lista.add(new TipoOfertaBolsa(8, "Aux. Moradia"));
					break;
				case 9:
					lista.add(new TipoOfertaBolsa(9, "Moradia Estudantil"));
					break;
				}
			}
		}

		olista = FXCollections.observableArrayList(lista);

		return olista;

	}

}
