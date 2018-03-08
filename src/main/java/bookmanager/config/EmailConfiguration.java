package bookmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @description 邮件配置
 */
@Configuration
public class EmailConfiguration {
    private static final String USERNAME="test@jieblog.cn";
    private static final String HOST="smtp.exmail.qq.com";
    private static final int PORT=465;
    private static final String PASSWORD="123aAA";
     @Bean
    public JavaMailSender mailSender(){
        JavaMailSenderImpl mailSender=new JavaMailSenderImpl();
        mailSender.setHost(HOST);
        mailSender.setPort(PORT);
        mailSender.setUsername(USERNAME);
        mailSender.setPassword(PASSWORD);
        mailSender.setDefaultEncoding("UTF-8");//设置编码
         Properties properties=new Properties();
         properties.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");//设置ssl
         mailSender.setJavaMailProperties(properties);
        return mailSender;
    }
}
