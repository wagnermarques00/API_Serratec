package org.serratec.borracharia.service;

import org.serratec.borracharia.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    //Variáveis puxadas do application.properties
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private int port;
    @Value("${spring.mail.username}")
    private String userName;
    @Value("${spring.mail.password}")
    private String senha;
    @Value("${spring.mail.protocol}")
    private String protocol;
    @Value("${spring.mail.default-encoding}")
    private String defaultEncoding;
    @Value("${spring.mail.destinatario}")
    private String emailDestinatario;

    //NÁO MODIFICAR ESSES MÉTODOS
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
        Properties prop = new Properties();

        enviarEmail.setHost(host);
        enviarEmail.setPort(port);
        enviarEmail.setUsername(userName);
        enviarEmail.setPassword(senha);
        enviarEmail.setProtocol("smtp");
        enviarEmail.setDefaultEncoding("UTF-8");
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.ssl.enable", true);
        enviarEmail.setJavaMailProperties(prop);

        return enviarEmail;
    }

    public void sendMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(userName);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    //Modelo de método
    public void emailTeste() throws MessagingException, EmailException {
        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setFrom(userName);
            helper.setTo(emailDestinatario);
            helper.setSubject("Email teste");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(
                    "<html>\r\n"
                            + "<body>\r\n"
                            + "<div>\r\n"
                            + "Email teste"
                            + "<br></br>"
                            + "</div>\r\n"
                            + "</body>\r\n"
                            + "</html>\r\n"
            );

            helper.setText(stringBuilder.toString(), true);
            emailSender.send(message);

        } catch (Exception exception) {
            throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
        }
    }

    //Automações

    public void emailServicoPrestado(Double valorServico, String nomeServico, LocalDate dataServico, Integer idCarro, String carroModelo, String carroMarca, String carroAno) throws MessagingException, EmailException {
        this.emailSender = javaMailSender();
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        try {
            helper.setFrom(userName);
            helper.setTo(emailDestinatario);
            helper.setSubject("Seu serviço foi efetuado!");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(
                    "<html>\r\n"
                            + "<body>\r\n"
                            + "<div>\r\n"
                            + "<title> Relação do serviço prestado</title>\r\n "
                            + "<h2> Segue relação do serviço prestado dia " + dataServico + ": </h2>"
                            + "<p> Serviço: " + nomeServico + "</p>"
                            + "<p> Valor: R$" + valorServico + "</p>"
                            + "<h2> Dados do carro" + idCarro + "</h2>"
                            + "<p> Modelo: " + carroModelo + "</p>"
                            + "<p> Marca: " + carroMarca + "</p>"
                            + "<p> Ano: " + carroAno + "</p>"
                            + "<br></br>"
                            + "</div>\r\n"
                            + "</body>\r\n"
                            + "</html>\r\n"
            );

            helper.setText(stringBuilder.toString(), true);
            emailSender.send(message);

        } catch (Exception exception) {
            throw new EmailException("Houve erro ao enviar o email: " + exception.getMessage());
        }
    }
}
