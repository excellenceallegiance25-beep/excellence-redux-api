package com.eapl.excellence.mailConfig;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String senderEmail;

	public void sendMail(String[] recipientMail, String[] ccRecipient, String[] bccRecipient, String mailSubject,
			Map<String, String> replacers, String emailTemplatePath) throws IOException, MessagingException {

		ClassPathResource resource = new ClassPathResource(emailTemplatePath);

		String mailBody;
		try (InputStream is = resource.getInputStream()) {
			mailBody = StreamUtils.copyToString(is, StandardCharsets.UTF_8);
		}

		for (Map.Entry<String, String> entry : replacers.entrySet()) {
			mailBody = mailBody.replace(entry.getKey(), entry.getValue());
		}

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

		helper.setFrom(senderEmail);
		helper.setTo(recipientMail);

		if (ccRecipient != null)
			helper.setCc(ccRecipient);

		if (bccRecipient != null)
			helper.setBcc(bccRecipient);

		helper.setSubject(mailSubject);
		helper.setText(mailBody, true);

		mailSender.send(message);
	}

}
