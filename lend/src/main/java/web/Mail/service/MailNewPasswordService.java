package web.Mail.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailNewPasswordService {

	private String customerEmail;
	private String newPassword;
//	private String customerName;
	
	public MailNewPasswordService(String customerEmail, String newPassword, String customerName) {
		this.customerEmail = customerEmail;
		this.newPassword = newPassword;
//		this.customerName = customerName;
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
			message.setSubject("忘記密碼通知信");
			// 設定信件內容
			message.setText("親愛的會員您好，這是您的臨時新密碼: " + newPassword
							+ "\n提醒:請您立即登入並更改您的密碼");
			
			Transport.send(message);
			
			System.out.println("Successfully sent Fogotten Password Link");
			
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		
	}
	
}
