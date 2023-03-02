package de.billmaier.example.taskmgmt.application.workitem;

import de.billmaier.example.taskmgmt.domain.model.workitem.WorkItem;
import de.billmaier.example.taskmgmt.domain.model.workitem.WorkItemRepository;
import de.billmaier.example.taskmgmt.domain.model.workitem.event.WorkItemAnsweredByEmail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkItemApplicationService
{
    public final WorkItemRepository workItemRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void answerByEmail()
    {
        final var workItem = new WorkItem();
        workItem.setWorkItemIdentifier("workItemIdentifier");
        workItem.setMailTo("to@example.com");
        workItemRepository.save(workItem);
        applicationEventPublisher.publishEvent(new WorkItemAnsweredByEmail(workItem.getWorkItemIdentifier()));
    }
}
