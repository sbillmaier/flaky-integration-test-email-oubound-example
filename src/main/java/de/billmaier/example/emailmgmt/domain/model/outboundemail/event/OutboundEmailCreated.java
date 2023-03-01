package de.billmaier.example.emailmgmt.domain.model.outboundemail.event;

import lombok.Value;

@Value
public class OutboundEmailCreated
{
    private final String outboundEmailIdentifier;
}
