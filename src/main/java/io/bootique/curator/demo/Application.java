package io.bootique.curator.demo;

import io.bootique.BQCoreModule;
import io.bootique.Bootique;
import io.bootique.di.BQModule;
import io.bootique.di.Binder;

public class Application implements BQModule {

    public static void main(String[] args) {
        Bootique.app(args)
                .autoLoadModules()
                .module(Application.class)
                .exec()
                .exit();
    }

    @Override
    public void configure(Binder binder) {
        BQCoreModule.extend(binder)
                .addConfig("classpath:config.yml")
                .addCommand(CuratorOperationCommand.class)
                .setDefaultCommand(CuratorOperationCommand.class);
    }

}
