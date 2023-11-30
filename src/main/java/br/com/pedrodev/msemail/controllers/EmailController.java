package br.com.pedrodev.msemail.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pedrodev.msemail.dtos.EmailDTO;
import br.com.pedrodev.msemail.models.EmailModel;
import br.com.pedrodev.msemail.services.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
       
        
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        emailService.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel, HttpStatus.CREATED);
    }
    
}
