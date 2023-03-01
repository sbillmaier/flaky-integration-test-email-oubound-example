package de.billmaier.example.emailmgmt.infrastructure.integration;

import de.billmaier.example.emailmgmt.domain.model.outboundemail.event.OutboundEmailCreated;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailSender
{
    private final MimeMessageSender mimeMessageSender;
    private final JavaMailSender javaMailSender;

    @TransactionalEventListener
    @Async
    @Transactional
    public void outboundEmailCreated(final OutboundEmailCreated outboundEmailCreated)
    {
        mimeMessageSender.send(createMimeMessage());
    }

    @SneakyThrows
    private MimeMessage createMimeMessage()
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom("from@example.com");
        mimeMessageHelper.setTo("to@example.com");
        mimeMessageHelper.setSubject("subject");
        mimeMessageHelper.setText("<html></html>", true);
        return mimeMessage;
    }
}
