package algorithm_analysis;

/**
 * Created by DELL on 2017/8/6.
 * 简单的计时器程序
 */
public class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        Long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
