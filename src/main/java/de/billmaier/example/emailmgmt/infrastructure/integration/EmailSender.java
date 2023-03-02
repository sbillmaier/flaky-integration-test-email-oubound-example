package de.billmaier.example.emailmgmt.infrastructure.integration;

import de.billmaier.example.emailmgmt.domain.model.outboundemail.OutboundEmail;
import de.billmaier.example.emailmgmt.domain.model.outboundemail.OutboundEmailRepository;
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

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmailSender
{
    private final OutboundEmailRepository outboundEmailRepository;
    private final MimeMessageSender mimeMessageSender;
    private final JavaMailSender javaMailSender;

    @TransactionalEventListener
    @Async
    @Transactional
    public void outboundEmailCreated(final OutboundEmailCreated outboundEmailCreated) throws MessagingException
    {
        final var outboundEmail = outboundEmailRepository.findByOutboundEmailIdentifier(outboundEmailCreated.getOutboundEmailIdentifier());
        final var mimeMessage = createMimeMessage(outboundEmail);
        mimeMessageSender.send(mimeMessage);
        outboundEmail.setSent(mimeMessage.getSentDate().toInstant());
        outboundEmailRepository.save(outboundEmail);
    }

    @SneakyThrows
    private MimeMessage createMimeMessage(final OutboundEmail outboundEmail)
    {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        mimeMessageHelper.setFrom(outboundEmail.getMailFrom());
        mimeMessageHelper.setTo(outboundEmail.getMailTo());
        mimeMessageHelper.setSubject("subject");
        mimeMessageHelper.setText("<html></html>", true);
        return mimeMessage;
    }
}
