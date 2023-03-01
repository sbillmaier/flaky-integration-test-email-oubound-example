package de.billmaier.example;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

@Slf4j
public class CleanupNonReferenceDataExecutionListener extends AbstractTestExecutionListener
{
    @Override
    public void afterTestMethod(final TestContext testContext) throws Exception
    {
        flywayCleanMigrate(testContext);
    }

    private void flywayCleanMigrate(final TestContext testContext)
    {
        if (log.isInfoEnabled())
        {
            log.info("Clean and migrate database");
        }
        final Flyway flyway = testContext.getApplicationContext().getBean(Flyway.class);
        flyway.clean();
        flyway.migrate();
    }
}
