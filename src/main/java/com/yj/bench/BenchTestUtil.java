package com.yj.bench;

import com.yj.xiuxian.panel.fulu.FuLu;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author YuJin
 * @version 1.0.0
 * @apiNote this class make for
 * @since 2023/9/4 10:26
 *      todo 这个类是使用了JMH的一个通用测试类
 *      我们只需要将我们要测试的代码方法在benchTest中调用执行即可
 */
public class BenchTestUtil {
    @Benchmark
    public void benchTest(Blackhole bh) {

        int cycle = 1;
        for (int i = 0; i < cycle; i++) {
            FuLu.compareByMatrix();
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(com.yj.bench.BenchTestUtil.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(10)
                .build();
        new Runner(opt).run();
    }


}

