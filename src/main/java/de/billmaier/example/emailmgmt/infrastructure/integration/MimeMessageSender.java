package de.billmaier.example.emailmgmt.infrastructure.integration;

import de.billmaier.example.emailmgmt.infrastructure.config.EMailConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.mail.MailException;

import javax.mail.internet.MimeMessage;

@MessagingGateway
@ConditionalOnProperty(prefix = "emailmgmt.adapter", name = "enabled")
public interface MimeMessageSender
{
    @Gateway(requestChannel = EMailConfig.OUTBOUND_MAIL_CHANNEL_NAME)
    void send(MimeMessage mimeMessage) throws MailException;
}
