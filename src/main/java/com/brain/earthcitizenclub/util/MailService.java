package com.brain.earthcitizenclub.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private static final Logger logger = LoggerFactory.getLogger(MailService.class);
	private static final long serialVersionUID = -3454874906870197995L;

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendMail(MailDTO mail) {

		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(mail.getSubject());
			
			// 수신인 다수
			String[] toArrayResult = new String[mail.getToUser().size()];

			for (int i = 0; i < mail.getToUser().size(); i++) {

				toArrayResult[i] = mail.getToUser().get(i);
				logger.debug("받는 사람 : {}", mail.getToUser().get(i));

			}
			messageHelper.setTo(toArrayResult);
			messageHelper.setText(mail.getText(), true);

			// 여러개의 파일첨부시
			if (mail.getFile() != null) {
				for (int i = 0; i < mail.getFile().size(); i++) {
					if (mail.getFile().get(i).isFile()) {
						messageHelper.addAttachment(mail.getAttcheFileName().get(i), mail.getFile().get(i));
						logger.debug("첨부 파일명 : {}", mail.getAttcheFileName().get(i));
					}
				}
			}

			logger.debug("메일 제목 : {}", mail.getSubject());
			mailSender.send(message);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			logger.debug("메일 에러 : {}", e.getMessage());
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.debug("메일 에러  : {}", ex.getMessage());
			return false;
		}
	}
}