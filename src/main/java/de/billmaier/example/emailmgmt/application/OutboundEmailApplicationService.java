package de.billmaier.example.emailmgmt.application;

import de.billmaier.example.emailmgmt.domain.model.outboundemail.OutboundEmail;
import de.billmaier.example.emailmgmt.domain.model.outboundemail.OutboundEmailRepository;
import de.billmaier.example.emailmgmt.domain.model.outboundemail.event.OutboundEmailCreated;
import de.billmaier.example.taskmgmt.domain.model.workitem.WorkItemRepository;
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
    private final WorkItemRepository workItemRepository;
    private final OutboundEmailRepository outboundEmailRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @TransactionalEventListener
    @Async
    @Transactional
    public void workItemAnsweredByEmail(final WorkItemAnsweredByEmail workItemAnsweredByEmail)
    {
        final var workItem = workItemRepository.findByWorkItemIdentifier(workItemAnsweredByEmail.getWorkItemIdentifier());
        final var outboundEmail = new OutboundEmail();
        outboundEmail.setOutboundEmailIdentifier("outboundEmailIdentifier");
        outboundEmail.setMailTo(workItem.getMailTo());
        outboundEmail.setMailFrom("from@example.com");
        outboundEmailRepository.save(outboundEmail);
        applicationEventPublisher.publishEvent(new OutboundEmailCreated(outboundEmail.getOutboundEmailIdentifier()));
    }
}
