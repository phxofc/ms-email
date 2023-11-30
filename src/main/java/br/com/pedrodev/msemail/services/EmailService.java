package br.com.pedrodev.msemail.services;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.pedrodev.msemail.enums.StatusEmail;
import br.com.pedrodev.msemail.models.EmailModel;
import br.com.pedrodev.msemail.repositories.EmailRepository;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    EmailRepository emailRepository;

    public EmailModel sendEmail(EmailModel emailModel){
        emailModel.setSenDateTime(LocalDateTime.now());
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        
            mimeMessageHelper.setFrom(emailModel.getEmailFrom());
            mimeMessageHelper.setTo(emailModel.getEmailTo());
            mimeMessageHelper.setSubject(emailModel.getSubject());
            mimeMessageHelper.setText(emailModel.getText());
            
            javaMailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
            
        } catch (Exception e) {
            
        emailModel.setStatusEmail(StatusEmail.ERROR); 
           } finally{
             return emailRepository.save(emailModel);
           }

       

    }

}
