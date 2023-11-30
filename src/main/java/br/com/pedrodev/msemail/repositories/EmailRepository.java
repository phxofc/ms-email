package br.com.pedrodev.msemail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pedrodev.msemail.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long>{
    
}
