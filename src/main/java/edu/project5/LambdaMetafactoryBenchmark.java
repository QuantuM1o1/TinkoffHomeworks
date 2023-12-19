package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
@SuppressWarnings("UncommentedMain")
public class LambdaMetafactoryBenchmark {
    public static final int WARMUP_TIME = 5;
    public static final int MEASUREMENT_TIME = 5;
    public static final int WARMUP_ITERATIONS = 3;
    public static final int MEASUREMENT_ITERATIONS = 10;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(LambdaMetafactoryBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(WARMUP_ITERATIONS)
            .warmupTime(TimeValue.seconds(WARMUP_TIME))
            .measurementIterations(MEASUREMENT_ITERATIONS)
            .measurementTime(TimeValue.seconds(MEASUREMENT_TIME))
            .build();
        new Runner(options).run();
    }

    private Student student;
    private Function<Student, String> function;


    @Setup
    public void setup() throws Throwable {
        student = new Student("Mikhail", "Vorobev");
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class);
        MethodHandle getter = lookup.findVirtual(Student.class, "name", mt);
        final CallSite site = LambdaMetafactory.metafactory(lookup, "apply",
            MethodType.methodType(Function.class),
            MethodType.methodType(Object.class, Object.class),
            getter,
            getter.type());
        function = (Function<Student, String>) site.getTarget().invokeExact();
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void lambdaMetafactory(Blackhole bh) {
        String name = function.apply(student);
        bh.consume(name);
    }
}
