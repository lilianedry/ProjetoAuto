
package model;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import controller.alertas.Alertas;
import model.entidades.Aluno;
import model.entidades.OfertaBolsa;
import model.entidades.TipoOfertaBolsa;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class GerarPDF {
	static Font[] fonts = {
			new Font(),
			new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, new BaseColor(0, 0, 0)/*Padr�o RGB*/)/*T�tulo*/,
			new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL, new BaseColor(0, 0, 0))/*Cabe�alho*/,
			new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0))/*Sub-t�tulos*/,
			new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, new BaseColor(0, 0, 0))/*Corpo*/,
			new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC, new BaseColor(0, 0, 0))/*Corpo*/
	};
	
	public static void geraListaSelecionados(TipoOfertaBolsa of, List<Aluno> list, OfertaBolsa oferta) {
		Document doc = new Document();
		int i = 0;
		doc.setPageSize(PageSize.A4);
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(of.getNome()+".pdf"));
			doc.open();
			Paragraph p = new Paragraph();
			p.add(new Paragraph("UNIVERSIDADE FEDERAL RURAL DO SEMI-�RIDO\nRIO GRANDE DO NORTE\nCENTRO MULTIDISCIPLINAR DE PAU DOS FERROS\n\n", fonts[3]));
			p.add(new Paragraph("LISTA DE APROVADOS: ", fonts[5]));
			p.add(new Paragraph(""+of.getNome()+"\n", fonts[3]));
			for(Aluno a : list) {
				if((i++) < oferta.getNumVagas()) {
					if(a.getTipoOferta() == of.getId()) {
						p.add(new Paragraph((i)+". "+a.getNomePessoa()+" :: CPF: "+a.getCPFPessoa()+" :: RENDA:"+a.getRendaBruta()+"\n", fonts[4]));
						Email.emitirEmailSituacao(a.getEmail(), of.getNome(), a.nomePessoa);
					} else {
						break;
					}
				}
			}
			doc.add(p);
			doc.close();
		} catch (FileNotFoundException | DocumentException e) {
			Alertas.mostraAlertaInfo("Documento n�o encontrado!", "ERRO: "+e);
		}
	}
	
	public static void geraRelatorioOferta(TipoOfertaBolsa of, OfertaBolsa oferta) {
		Document doc = new Document();
		doc.setPageSize(PageSize.A4);
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("Relat�rio_"+of.getNome()+".pdf"));
			doc.open();
			Paragraph p = new Paragraph();
			p.add(new Paragraph("UNIVERSIDADE FEDERAL RURAL DO SEMI-�RIDO\nRIO GRANDE DO NORTE\n"
					+ "CENTRO MULTIDISCIPLINAR DE PAU DOS FERROS\n\n", fonts[3]));
			p.add(new Paragraph("RELAT�RIO DE MODALIDADE: ", fonts[5]));
			p.add(new Paragraph(""+of.getNome()+"\n", fonts[3]));
			p.add(new Paragraph("\nEste relat�rio corresponde aos dados inseridos para alunos que foram "
					+"inscritos na modalidade "+of.getNome()+". A n�vel de pesquisa institucional, "
							+ "seguem dados obtidos a partir dos mesmos.\n\n", fonts[5]));
			if(!ArrayLists.alunoAptoArray.isEmpty()) {
				p.add(new Paragraph("Renda m�dia dos alunos cadastrados: ", fonts[4]));
				p.add(new Paragraph(""+ArrayLists.mediaRenda(), fonts[5]));
				p.add(new Paragraph("Tamanho m�dio da fam�lia: ", fonts[4]));
				p.add(new Paragraph(""+ArrayLists.mediaFamiliares(), fonts[5]));
				p.add(new Paragraph("Dist�ncia m�dia das cidades dos alunos cadastrados em rela��o ao campus: ", fonts[4]));
				p.add(new Paragraph(""+ArrayLists.mediaDistCidade(), fonts[5]));
			} else {
				p.add(new Paragraph("N�O HOUVERAM ALUNOS INSCRITOS NESTA MODALIDADE.", fonts[5]));
			}
			
			doc.add(p);
			doc.close();
		} catch (FileNotFoundException | DocumentException e) {
			Alertas.mostraAlertaInfo("Documento n�o encontrado!", "ERRO: "+e);
		}
	}
}
