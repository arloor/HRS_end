package util;

import com.sun.mail.smtp.SMTPAddressFailedException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * 发送邮件通知
 */
public class JavaMail {

    public static void sendEmail(String userEmail,String theme,String content) {
// 收件人电子邮箱
        String to = userEmail;
// 发件人电子邮箱 这里使用学校邮箱
        String from = "151250095@smail.nju.edu.cn";
// 指定发送邮件的主机为 smtp.exmail.qq.com
        String host = "smtp.exmail.qq.com"; //QQ 邮件服务器
// 获取系统属性
        Properties properties = System.getProperties();
// 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
// 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("151250095@smail.nju.edu.cn", "!@QWqw426543"); //发件人邮件用户名、密码
            }
        });
        try {
// 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
// Set From: 头部头字段
            message.setFrom(new InternetAddress(from));
// Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
// Set Subject: 头部头字段
            message.setSubject(theme);
// 设置消息体
            message.setText(content);
// 发送消息
            try {
                Transport.send(message);
            }catch (Exception e){
                System.out.println(userEmail+"是不正确的邮件格式");
            }
            System.out.println("邮件发送成功");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}