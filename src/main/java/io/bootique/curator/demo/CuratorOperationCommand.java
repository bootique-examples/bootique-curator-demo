package io.bootique.curator.demo;

import java.util.List;

import com.google.inject.Inject;
import io.bootique.cli.Cli;
import io.bootique.command.Command;
import io.bootique.command.CommandOutcome;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;

import javax.inject.Provider;

public class CuratorOperationCommand implements Command {

    @Inject
    private Provider<CuratorFramework> curatorFrameworkProvider;

    @Override
    public CommandOutcome run(Cli cli) {
        try {
            List<CuratorTransactionResult> results = performCuratorTransaction();
            results.forEach(r -> {
                System.out.println(r.getForPath() + ": " + r.getType());
                System.out.println(" version: " + ((r.getResultStat() != null) ? r.getResultStat().getVersion() : "none"));
            });
        } catch (Exception e) {
            return CommandOutcome.failed(-1, e);
        }
        return CommandOutcome.succeeded();
    }

    private List<CuratorTransactionResult> performCuratorTransaction() throws Exception {
        CuratorFramework curator = curatorFrameworkProvider.get();
        return curator.transaction().forOperations(
                curator.transactionOp().create().forPath("/path", "origin data".getBytes()),
                curator.transactionOp().setData().forPath("/path", "changed data".getBytes()),
                curator.transactionOp().setData().forPath("/path", "changed again data".getBytes()),
                curator.transactionOp().delete().forPath("/path")
        );
    }

}
