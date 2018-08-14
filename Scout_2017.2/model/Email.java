package model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import controller.alertas.Alertas;

public class Email {
	public static void emitirEmailCadastro(String email, String modalidade, String nomeAluno){
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("suportescout@gmail.com", "@scout123");
					}
				});

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("suportescout@gmail.com")); //Remetente

			Address[] toUser = InternetAddress.parse(email);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("AUXÍLIO "+modalidade.toUpperCase()+": CADASTRO REALIZADO COM SUCESSO!");//Assunto
			message.setText("Olá, "+nomeAluno+"!\n\nVocê foi cadastrado com sucesso no Programa de Permanência Acadêmica da UFERSA!\n\tDISCENTE: "+nomeAluno+"\n\tMODALIDADE: "+modalidade+"\nCaso esse email tenha chegado em sua caixa de mensagens por engano, por favor nos comunique o mais breve possível!\n\nAtt.: Assistência Estudantil da UFERSA & Time Scout");

			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			Alertas.mostraAlertaInfo("O e-mail não é reconhecido", "Verifique se o e-mail foi inserido corretamente e tente novamente");
		}
	}
	
	public static void emitirEmailSituacao(String email, String modalidade, String nomeAluno){
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(prop,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication("suportescout@gmail.com", "@scout123");
					}
				});

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("suportescout@gmail.com")); //Remetente

			Address[] toUser = InternetAddress.parse(email);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("AUXÍLIO "+modalidade.toUpperCase()+": APROVADO");//Assunto
			message.setText("Olá, "+nomeAluno+"!\n\nSua inscrição no Permanência Acadêmica da UFERSA foi APROVADA!\n\tDISCENTE: "+nomeAluno+"\n\tMODALIDADE: "+modalidade+"\nProcure com urgência o setor de Assistência estudantil do campus urgentemente para mais detalhes sobre o local e data reunião de posse.\n\nCaso esse email tenha chegado em sua caixa de mensagens por engano, por favor nos comunique o mais breve possível!\n\nAtt.: Assistência Estudantil da UFERSA & Time Scout");

			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			Alertas.mostraAlertaInfo("O e-mail não é reconhecido", "Verifique se o e-mail foi inserido corretamente e tente novamente");
		}
	}
}
