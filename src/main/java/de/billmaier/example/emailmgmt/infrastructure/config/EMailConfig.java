package de.billmaier.example.emailmgmt.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mail.dsl.Mail;
import org.springframework.mail.MailSender;

@Configuration
@ConditionalOnProperty(prefix = "emailmgmt.adapter", name = "enabled")
@RequiredArgsConstructor
public class EMailConfig
{
    public static final String MAIL_OUTBOUND_ENDPOINT_ID = "mailOutbound.mailOutboundAdapter";
    public static final String OUTBOUND_MAIL_CHANNEL_NAME = "outboundMailChannel";

    @Bean
    public IntegrationFlow mailOutbound(final MailSender mailSender)
    {
        return IntegrationFlows.from(OUTBOUND_MAIL_CHANNEL_NAME)
                .handle(Mail.outboundAdapter(mailSender), e -> e.id(MAIL_OUTBOUND_ENDPOINT_ID))
                .get();
    }
}
