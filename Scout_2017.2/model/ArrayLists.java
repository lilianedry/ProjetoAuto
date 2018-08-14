package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.entidades.Aluno;
import model.entidades.OfertaBolsa;

public class ArrayLists {

	public static List<OfertaBolsa> tobArray = new ArrayList<OfertaBolsa>();
	public static List<Aluno> alunoArray = new ArrayList<Aluno>();
	public static List<Aluno> alunoAptoArray = new ArrayList<Aluno>();

	public static void adicionaOferta(OfertaBolsa nova) {
		tobArray.add(nova);
		Collections.sort(tobArray);
	}
	
	public static void adicionaAluno(Aluno novo) {
		alunoArray.add(novo);
	}
	
	public static void adicionaAlunoApto(Aluno novo) {
		alunoAptoArray.add(novo);
		Collections.sort(alunoAptoArray, new Comparator<Aluno>() {
			public int compare(Aluno a1, Aluno a2) {
		        if (a1.getRendaBruta() >= a2.getRendaBruta()) return +1;
		        else if (a1.getRendaBruta() < a2.getRendaBruta()) return -1;
		        else return 0;
		    }
		});
	}
	
	public static void imprimeOfertasArray() {
		for(OfertaBolsa a : tobArray)
			System.out.println("Oferta tipo: " + a.getTipoOferta());
	}
	
	public static boolean ofertaNoArray(int ob) {
		for(OfertaBolsa a : tobArray)
			if(a.getTipoOferta() == ob)
				return true;
		return false;
	}
	
	public static boolean cpfNoArray(String cpf) {
		for(Aluno a : alunoArray)
			if(a.getCPFPessoa() == cpf)
				return true;
		return false;
	}
	
	public static String mostraOfertasCadastradas() {
		String oc = "";
		for(OfertaBolsa a : tobArray)
			oc += a.getTipoOferta() + "; ";
		return oc;
	}
	public static OfertaBolsa pegaOfertasCadastradas(int id) {
		for(OfertaBolsa a : tobArray)
			if(a.getTipoOferta() == id) {
				return a;
			}
		return null;
	}
	public static List<Aluno> selecionados(OfertaBolsa of){
		List<Aluno> lst = new ArrayList<Aluno>();
		int i=0;
		
		for(Aluno a : alunoAptoArray) {
			if(i++<of.getNumVagas()) {
				if(a.tipoOferta == of.getTipoOferta()) {
					lst.add(a);
				}
			}else {
				break;
			}
		}
		return lst;
	}
	
	public static List<Aluno> buscar (String nome){
		List<Aluno> lstb = new ArrayList<Aluno>();
		if(nome == null || nome.equals("")) {
			for(Aluno a : alunoArray) {
				lstb.add(a);
			}
			for(Aluno a : alunoAptoArray) {
				lstb.add(a);
			}
		}
		else {
			for(Aluno a : alunoArray) {
				if(a.getNomePessoa().toLowerCase().contains(nome) || a.getNomePessoa().toLowerCase() == nome.toLowerCase()) {
					lstb.add(a);
				}
			}
			for(Aluno a : alunoAptoArray) {
				if(a.getNomePessoa().toLowerCase().contains(nome) || a.getNomePessoa().toLowerCase() == nome.toLowerCase())
					lstb.add(a);
			}
		}
		return lstb;
	}
	
	public static float mediaRenda() {
		float media=0;
		int i=0;

		for(Aluno a : alunoAptoArray) {
			media += a.getRendaBruta();
			i++;
		}
		
		return media/i;
	}
	
	public static float mediaDistCidade() {
		float media=0;
		int i=0;

		for(Aluno a : alunoAptoArray) {
			media += a.getDistanciaCidade();
			i++;
		}
		
		return media/i;
	}
	
	public static float mediaFamiliares() {
		float media=0;
		int i=0;

		for(Aluno a : alunoAptoArray) {
			media += a.familiares.size();
			i++;
		}
		
		return media/i;
	}
}
