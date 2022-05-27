package org.serratec.backend.projeto08.service;

import org.serratec.backend.projeto08.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class EmailService {

    private final String emailRemetente = "wagnermarques00@gmail.com";
    private final String emailDestinatario = "renan.ribeiro15@hotmail.com";

    @Autowired
    private JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String userName;

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.port}")
    private Integer port;


    public JavaMailSender javaMailSender() {

        JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
        Properties prop = new Properties();

        enviarEmail.setHost(host);
        enviarEmail.setPort(port);
        enviarEmail.setUsername(userName);
        enviarEmail.setPassword(password);
        enviarEmail.setProtocol("smtp");
        enviarEmail.setDefaultEncoding("UTF-8");

        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.enable", true);
        enviarEmail.setJavaMailProperties(prop);

        return enviarEmail;
    }

    public void sendMessage(String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailRemetente);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void emailTeste() throws MessagingException, EmailException {

        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setFrom(userName);
            helper.setTo(emailDestinatario);
            helper.setSubject("Wagner");

            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append("""
                    <html>
                        <body>
                            <h0> A nova loira do Tchan! </h0>
                            <h1> É linda, deixa ela entrar </h1>
                            <h2> É linda, deixa ela entrar </h2>
                            <h2> Tem 60 de cintura </h2>
                            <h3> que gostosura </h3>
                            <h2> 105 de bundinha </h2>
                            <h3> que bonitinha </h3>
                            <h2> 1, 70 de altura </h2>
                            <h3> ninguém segura </h3>
                            <h1> Mas que loirinha danadinha </h1>
                            </div>
                        </body>
                    </html>
                    """
            );

            helper.setText(sBuilder.toString(), true);
            emailSender.send(message);
        } catch (Exception e) {
            throw new EmailException();
        }
    }
}
