package lambda;

import java.util.stream.IntStream;

/**
 * Created by zhanggq on 2017/8/1.
 */
public class Stream {
    public static void main(String... args){
        long t0 = System.nanoTime();
        int a[] = IntStream.range(0, 1000000).filter(p -> p%2==0).toArray();
        long t1 = System.nanoTime();
        int b[] = IntStream.range(0, 1000000).parallel().filter(p -> p%2==0).toArray();
        long t2 = System.nanoTime();
        System.out.println();
        System.out.printf("serial: %.2fs, parallel: %.2fs%n", (t1-t0)*1e-9, (t2-t1)*1e-9);
    }
}
