package de.billmaier.example.emailmgmt.application;

import de.billmaier.example.emailmgmt.domain.model.outboundemail.event.OutboundEmailCreated;
import de.billmaier.example.taskmgmt.domain.model.workitem.event.WorkItemAnsweredByEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
@RequiredArgsConstructor
public class OutboundEmailApplicationService
{
    private final ApplicationEventPublisher applicationEventPublisher;

    @TransactionalEventListener
    @Async
    @Transactional
    public void workItemAnsweredByEmail(final WorkItemAnsweredByEmail workItemAnsweredByEmail)
    {
        applicationEventPublisher.publishEvent(new OutboundEmailCreated("outboundEmailIdentifier"));
    }
}
