package net.barecode.howto.java.gmail;

import java.util.Properties;

import java.io.IOException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Sample code to send mail over SMTP via gmail.
 * Wrapped in a servlet to email simple testing.
 * 
 * @author barecode
 */
@WebServlet("/")
public class SendGmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Session session;
	private final String gmail_user = "";
	private final String gmail_password = "";

	public SendEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(gmail_user, gmail_password);
			}
		});
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Send e-mail through a gmail account");
		sendMail();
	}

	/** {@inheritDoc} */
	public void sendMail() {
		try {
			String fromEmail = ""; // Typically this is the same as your gmail account
			String toEmail = "";

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(fromEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Test message");
			message.setText("Hi there, this is a test message sent frmo Java!");

			Transport.send(message);
			result = true;
		} catch (AddressException e) {
			System.out.println("AddressException during sendMail");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.out.println("MessagingException during sendMail");
			e.printStackTrace();
		}
	}
}
