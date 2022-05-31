package org.serratec.borracharia.controller;

import org.serratec.borracharia.exception.EmailException;
import org.serratec.borracharia.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/email")
    public void enviarEmailTeste() throws MessagingException, EmailException {
        emailService.emailTeste();
    }
}
