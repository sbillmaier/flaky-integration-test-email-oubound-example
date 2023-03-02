package de.billmaier.example.emailmgmt.domain.model.outboundemail;

import org.springframework.data.repository.CrudRepository;

public interface OutboundEmailRepository extends CrudRepository<OutboundEmail, Long>
{
    OutboundEmail findByOutboundEmailIdentifier(String outboundEmailIdentifier);
}
