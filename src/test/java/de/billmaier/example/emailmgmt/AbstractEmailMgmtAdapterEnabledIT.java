package de.billmaier.example.emailmgmt;

import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.store.FolderException;
import de.billmaier.example.GreenMailExtensionConfigurer;
import de.billmaier.example.IntegrationTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.test.context.TestPropertySource;

@IntegrationTest
@TestPropertySource(properties = "emailmgmt.adapter.enabled=true")
public abstract class AbstractEmailMgmtAdapterEnabledIT
{
    @RegisterExtension
    protected static final GreenMailExtension GREEN_MAIL = GreenMailExtensionConfigurer.configuredGreenMailExtension();

    @BeforeEach
    void purgeEmailsAndStartMailInboundEndpoint() throws FolderException
    {
        GREEN_MAIL.purgeEmailFromAllMailboxes();
    }

    @AfterEach
    void stopMailInboundEndpointAndPurgeEmails() throws FolderException
    {
        GREEN_MAIL.purgeEmailFromAllMailboxes();
    }
}
