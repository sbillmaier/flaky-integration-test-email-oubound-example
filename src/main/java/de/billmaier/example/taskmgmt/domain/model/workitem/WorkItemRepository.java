package de.billmaier.example.taskmgmt.domain.model.workitem;

import org.springframework.data.repository.CrudRepository;

public interface WorkItemRepository extends CrudRepository<WorkItem, Long>
{
    WorkItem findByWorkItemIdentifier(String workItemIdentifier);
}
