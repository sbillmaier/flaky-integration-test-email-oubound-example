package de.billmaier.example.taskmgmt.domain.model.workitem;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Data
public class WorkItem extends AbstractPersistable<Long>
{
    private String workItemIdentifier;
    private String mailTo;
}
