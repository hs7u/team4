package web.Mail.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailVerificationService {

	private int	type;
	private String customerEmail;
	private String myHash;
	private String customerName;
	
	public MailVerificationService(int	type ,String customerEmail, String myHash, String customerName) {
		this.type = type;
		this.customerEmail = customerEmail;
		this.myHash = myHash;
		this.customerName = customerName;
	}
	
	public void sendMail() {
		// Enter the email address and password for the account from which verification link will be send
		String email = "XXX@gmail.com";
		String password = "XXX";
		
		Properties theProperties = new Properties();
		
		theProperties.put("mail.smtp.auth", "true");
		theProperties.put("mail.smtp.starttls.enable", "true");
		theProperties.put("mail.smtp.host", "smtp.gmail.com");
		theProperties.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(theProperties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(customerEmail));
			// 設定信件標題
			message.setSubject("會員驗證信");
			
			// 設定信件內容
			message.setText("請點擊以下連結來啟用您的帳號"
					+ "\n\n點此驗證: " + "http://localhost:8081/XXX/ActivateAccount?key=" + type + "&key1=" + customerEmail + "&key2=" + myHash);
			
			Transport.send(message);
			
			System.out.println("Successfully sent Verification Link");
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	
}
