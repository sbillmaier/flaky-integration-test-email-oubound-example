package de.billmaier.example;

import com.icegreen.greenmail.configuration.GreenMailConfiguration;
import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.util.ServerSetupTest;

public final class GreenMailExtensionConfigurer
{
    public static final String MAIL_SERVER_USER_LOGIN = "info@example.com";

    private GreenMailExtensionConfigurer()
    {
    }

    public static GreenMailExtension configuredGreenMailExtension()
    {
        return new GreenMailExtension(ServerSetupTest.SMTP_POP3)
                .withPerMethodLifecycle(false)
                .withConfiguration(GreenMailConfiguration.aConfig().withUser(GreenMailExtensionConfigurer.MAIL_SERVER_USER_LOGIN, "test"));
    }
}
