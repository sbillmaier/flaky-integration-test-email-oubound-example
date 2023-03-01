package de.billmaier.example.taskmgmt.domain.model.workitem.event;

import lombok.Value;

@Value
public class WorkItemAnsweredByEmail
{
    private final String workItemIdentifier;
}
