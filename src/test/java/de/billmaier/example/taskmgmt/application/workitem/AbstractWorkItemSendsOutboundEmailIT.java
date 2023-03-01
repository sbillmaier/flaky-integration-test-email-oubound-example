package de.billmaier.example.taskmgmt.application.workitem;

import de.billmaier.example.CleanupNonReferenceDataExecutionListener;
import de.billmaier.example.emailmgmt.AbstractEmailMgmtAdapterEnabledIT;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

@Getter(AccessLevel.PROTECTED)
@TestExecutionListeners(listeners = CleanupNonReferenceDataExecutionListener.class, mergeMode = TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS)
abstract class AbstractWorkItemSendsOutboundEmailIT extends AbstractEmailMgmtAdapterEnabledIT
{
    @Autowired
    private WorkItemApplicationService workItemApplicationService;
}
