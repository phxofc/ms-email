package br.com.pedrodev.msemail.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.pedrodev.msemail.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="tb_email")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String owerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime senDateTime;
    private StatusEmail statusEmail;


}
