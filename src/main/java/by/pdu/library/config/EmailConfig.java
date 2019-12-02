package by.pdu.library.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@PropertySource("classpath:email.properties")
public class EmailConfig {
    @Value("${mail.smtps.auth}")
    private boolean smtps;
    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port;
    @Value("${mail.username}")
    private String username;
    @Value("${mail.password}")
    private String password;
    @Value("${mail.protocol}")
    private String protocol;
    @Value("${mail.from}")
    private String from;
    @Value("${mail.subjectRegistration}")
    private String subjectRegistration;
    @Value("${mail.subjectNewPassword}")
    private String subjectNewPassword;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);
        mailSender.setProtocol(protocol);
        Properties props = new Properties();
        props.put("mail.smtps.auth", smtps);
        mailSender.setJavaMailProperties(props);
        return mailSender;
    }

    @Bean
    public SimpleMailMessage registerMessageUpdatePassword() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setSubject(subjectNewPassword);
        return simpleMailMessage;
    }

}
