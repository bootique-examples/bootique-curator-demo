package io.bootique.curator.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.transaction.CuratorTransactionBridge;
import org.apache.curator.framework.api.transaction.CuratorTransactionResult;

import java.util.Collection;

public class CrudExample {
    public static void transaction(CuratorFramework curatorFramework) throws Exception {

        CuratorTransactionBridge curatorTransactionBridge = curatorFramework.inTransaction().create().forPath("/a", "origin data".getBytes())
                .and().setData().forPath("/a", "changed data".getBytes())
                .and().setData().forPath("/a", "changed again data".getBytes())
                .and().delete().forPath("/a");
        Collection<CuratorTransactionResult> results = curatorTransactionBridge.and().commit();

        results.forEach(r -> {
            System.out.println(r.getForPath() + ": " + r.getType());
            System.out.println(" version: " + ((r.getResultStat() != null) ? r.getResultStat().getVersion() : "none"));
        });
    }
}
