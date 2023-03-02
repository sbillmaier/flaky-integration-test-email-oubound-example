package de.billmaier.example.emailmgmt.domain.model.outboundemail;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
@Data
public class OutboundEmail extends AbstractPersistable<Long>
{
    private String outboundEmailIdentifier;
    private String mailFrom;
    private String mailTo;
    private Instant sent;
}
