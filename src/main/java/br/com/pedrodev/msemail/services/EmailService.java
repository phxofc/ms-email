package br.com.pedrodev.msemail.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pedrodev.msemail.repositories.EmailRepository;

@Service
public class EmailService {
    
        @Autowired
        EmailRepository emailRepository;

}
