package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhanggq on 2017/8/1.
 */
public class Truth {
    public static void main(String[] args){
//        String[] players = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka", "David Ferrer",
//                "Roger Federer", "Andy Murray",
//                "Tomas Berdych", "Juan Martin Del Potro",
//                "Richard Gasquet", "John Isner"};

//        Arrays.sort(players, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1.compareTo(o2));
//            }
//        });

//        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
//        Arrays.sort(players, sortByName);

//        Arrays.sort(players, (s1, s2) -> (s1.compareTo(s2)));

//        for (String s : players){
//            System.out.println(s);
//        }
//        Arrays.stream(players).forEach(System.out::println);

        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> list = Arrays.asList(atp);

//        list.forEach((p)->System.out.println(p));
//        list.forEach(System.out::println);
//        new Thread(()->System.out.println("lalal")).start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        new Thread(()->System.out.println("匿名lambda")).start();

        Runnable fun = new Runnable() {
            @Override
            public void run() {
                System.out.println("非匿名内部类");
            }
        };
        new Thread(fun).start();

        Runnable lam = ()->System.out.println("非匿名lambda");
        new Thread(lam).start();

        Runnable fun_2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("方法引用非匿名内部类");
            }
        };
        new Thread(fun_2::run).start();

        Runnable lam_2 = ()->System.out.println("方法引用非匿名lambda");
        new Thread(lam_2::run).start();

        new Thread(()->{System.out.println("found you");}).start();
    }
}
