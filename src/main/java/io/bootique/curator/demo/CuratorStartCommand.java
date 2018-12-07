package io.bootique.curator.demo;

import com.google.inject.Inject;
import io.bootique.cli.Cli;
import io.bootique.command.Command;
import io.bootique.command.CommandOutcome;
import org.apache.curator.framework.CuratorFramework;

import javax.inject.Provider;

public class CuratorStartCommand implements Command {

    @Inject
    private Provider<CuratorFramework> curatorFrameworkProvider;

    @Override
    public CommandOutcome run(Cli cli) {
        CuratorFramework curatorFramework = curatorFrameworkProvider.get();

        try {
            CrudExample.transaction(curatorFramework);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommandOutcome.succeeded();
    }

}
