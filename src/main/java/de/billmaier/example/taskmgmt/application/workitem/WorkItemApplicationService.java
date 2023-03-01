package de.billmaier.example.taskmgmt.application.workitem;

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
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void answerByEmail()
    {
        applicationEventPublisher.publishEvent(new WorkItemAnsweredByEmail("workItemIdentifier"));
    }
}
