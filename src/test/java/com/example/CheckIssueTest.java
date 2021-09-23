package com.example;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import com.hazelcast.scheduledexecutor.TaskUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class CheckIssueTest {

    public static final String RUNNABLES = "runnables";
    public static final String CALLABLES = "callables";
    public static HazelcastInstance hazelcast;

    @BeforeClass
    public static void setup() {
        Config config = new Config();
        config.getScheduledExecutorConfig(RUNNABLES).setCapacity(2);
        config.getScheduledExecutorConfig(CALLABLES).setCapacity(2);
        hazelcast = Hazelcast.newHazelcastInstance(config);
    }

    @Test
    public void checkAutoDisposableRunnable() throws InterruptedException {
        IScheduledExecutorService runnables = hazelcast.getScheduledExecutorService(RUNNABLES);

        for (int i = 0; i < 4; i++) {
            runnables.schedule(TaskUtils.autoDisposable(new RunnableExample()), 1, TimeUnit.SECONDS);
            Thread.sleep(1000);
        }
    }

    @Test
    public void checkAutoDisposableCallable() throws InterruptedException {
        IScheduledExecutorService callables = hazelcast.getScheduledExecutorService(CALLABLES);

        for (int i = 0; i < 4; i++) {
            callables.schedule(TaskUtils.autoDisposable(new CallableExample()), 1, TimeUnit.SECONDS);
            Thread.sleep(1000);
        }
    }
}
