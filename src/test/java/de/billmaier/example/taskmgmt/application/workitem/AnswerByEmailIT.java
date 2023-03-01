package de.billmaier.example.taskmgmt.application.workitem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AnswerByEmailIT extends AbstractWorkItemSendsOutboundEmailIT
{
    @Test
    void testAnswerByEmail()
    {
        getWorkItemApplicationService().answerByEmail();

        assertTrue(GREEN_MAIL.waitForIncomingEmail(2000, 1));
    }
}