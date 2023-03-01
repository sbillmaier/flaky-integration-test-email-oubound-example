package de.billmaier.example.emailmgmt.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.integration.dsl.SourcePollingChannelAdapterSpec;
import org.springframework.integration.scheduling.PollerMetadata;

@Data
@ConfigurationProperties(prefix = "mail")
public class MailProperties
{
    private POP3 pop3;
    private Poller poller;

    public MailProperties()
    {
        this.pop3 = new POP3();
        this.poller = new Poller();
    }

    @Data
    public static class POP3
    {
        private String host;
        private int port;
        private String username;
        private String password;
        private int maxFetchSize;

        public POP3()
        {
            this.maxFetchSize = 10;
        }
    }

    @Data
    public static class Poller
    {
        private int period;
        private int maxMessagesPerPoll;

        /**
         * Defines poller properties.
         * Presets maximum number of messages to be polled from message source per poller period with default value of SourcePollingChannelAdapterSpec
         * when configured with Java DSL (which is 1).
         *
         * @see SourcePollingChannelAdapterSpec#poller(PollerMetadata)
         */
        public Poller()
        {
            this.maxMessagesPerPoll = 1;
        }
    }
}
