package br.com.pedrodev.msemail.dtos;

import lombok.Data;

@Data
public class EmailDTO {


    
    private Long emailId;
    private String owerRed;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    
}
