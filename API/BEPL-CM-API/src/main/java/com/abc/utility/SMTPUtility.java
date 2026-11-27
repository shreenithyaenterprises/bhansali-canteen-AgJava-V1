package com.abc.utility;

import java.io.ByteArrayOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.abc.Startup;

@Component
public class SMTPUtility
{
	static Logger logger = LoggerFactory.getLogger(SMTPUtility.class);
	@Autowired
	private Environment env;

    String smtpHost="", smtpAuth="", smtpSSL="", accountId="",accountPass="";
//	public SMTPUtility()
//	{
//		smtpHost=env.getProperty("smtpHost");
//		smtpAuth=env.getProperty("smtpAuth");
//		smtpSSL=env.getProperty("smtpSSL");
//		accountId=env.getProperty("accountId");
//		accountPass=env.getProperty("accountPass");
//	}
	public static boolean sendMail(String emailTo, String emailCC, String emailBCC, String Body, String Subject,
			MultipartFile filePath)
	{
		System.out.println("#### Email Request Received###");
		System.out.println("Email Body:"+Body);
		Boolean Status = false;
		Properties props = new Properties();
		//SMTPUtility util = new SMTPUtility();
		props.put("mail.smtp.host", Startup.enviromentProperties.get("smtpHost"));
		props.put("mail.smtp.auth", Startup.enviromentProperties.get("smtpAuth"));
		props.put("mail.smtp.ssl.enable", Startup.enviromentProperties.get("smtpSSL"));
		ByteArrayOutputStream outputStream = null;
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(Startup.enviromentProperties.get("emailId"),
						Startup.enviromentProperties.get("emailPass"));
			}
		});

		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Startup.enviromentProperties.get("emailId"), ""));
			message.addRecipients(Message.RecipientType.TO, emailTo);

			if (!isEmptyOrNull(emailCC))
				message.addRecipients(Message.RecipientType.CC, emailCC);
			if (!isEmptyOrNull(emailBCC))
				message.addRecipients(Message.RecipientType.BCC, emailBCC);
			message.setSubject(Subject);
			MimeBodyPart BodyMessage = new MimeBodyPart();
			BodyMessage.setText(Body, "utf-8", "html");
			 
			
				MimeMultipart mimeMultipart = new MimeMultipart();
				if(null !=filePath)
				{
					MimeBodyPart AttachmentPart = new MimeBodyPart();
					AttachmentPart.setDataHandler(new DataHandler(new ByteArrayDataSource(filePath.getBytes(), "application/vnd.ms-excel")));
					AttachmentPart.setFileName(filePath.getOriginalFilename());
					mimeMultipart.addBodyPart(AttachmentPart);
				}
				mimeMultipart.addBodyPart(BodyMessage);
		        message.setContent(mimeMultipart);
			
	        System.out.println("#### Sending Email ###");
			Transport.send(message);
			Status = true;
			System.out.println("#### Email Sent Successfully###");
		} catch (MessagingException e)
		{
			logger.error("SMTP Utility Error: " + e.toString());
			Status = false;
		} catch (Exception e)
		{
			logger.error("SMTP Utility Error: " + e.toString());
			Status = false;
		}

		return Status;
	}

	public static boolean isEmptyOrNull(String str)
	{
		boolean isEmpty = str == null || str.trim().length() == 0;
		return isEmpty;
	}
}
