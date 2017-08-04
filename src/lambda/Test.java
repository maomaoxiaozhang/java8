package lambda;

import com.sun.javafx.scene.layout.region.Margins;
import com.sun.xml.internal.ws.commons.xmlutil.Converter;

import java.time.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by zhanggq on 2017/8/2.
 */
public class Test {
    public static void main(String[] args){
//        String[] players = {"Rafael Nadal", "Novak Djokovic",
//                "Stanislas Wawrinka", "David Ferrer",
//                "Roger Federer", "Andy Murray",
//                "Tomas Berdych", "Juan Martin Del Potro",
//                "Richard Gasquet", "John Isner"};
//
//        Comparator<String> nameCompare = new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        };

//        Arrays.asList(players).sort(nameCompare::compare);
//        Arrays.asList(players)
//                .stream()
//                .forEach(System.out::println);

//        Predicate<String> namePre = new Predicate<String>() {
//            @Override
//            public boolean test(String string) {
//                return true;
//            }
//        };
//        Arrays.asList(players)
//                .stream()
//                .filter(s -> {if (s.equals("Richard Gasquet"))return true; return false;})
//                .forEach(System.out::println);

//        int num = 1;
//        lambda.Converter<Integer,String> num2String = (from)->String.valueOf(from+num);
//        lambda.Converter<Integer, String> temp = new lambda.Converter<Integer, String>() {
//            @Override
//            public String convert(Integer from) {
//                return String.valueOf(from);
//            }
//        };
//        System.out.println(temp.convert(33));

//        new Thread(()->System.out.println("lambda")).run();
        Comparator<Integer> com = (n1,n2)->{return (n2-n1);};
//        List<Integer> list = new LinkedList<Integer>(){
//            {
//                add(1);
//                add(2);
//                add(3);
//            }
//        };
//        list.sort(com);
//        list.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });

//        Predicate<String> largethan1 = s->{if (Integer.valueOf(s)>1) return true; return false;};
//        Predicate<String> largethan2 = s->{if (Integer.valueOf(s)>2) return true; return false;};
//        Predicate<String> smallthan4 = s->{if (Integer.valueOf(s)<4) return true; return false;};
//
//        Arrays.asList("1", "2", "3", "4")
//                .stream()
//                .filter(largethan1.and(largethan2).and(smallthan4))
//                .forEach(s -> System.out.println(s));

//        List costBeforeTax = Arrays.asList(100, 200, 300, 400);
//        costBeforeTax.stream()
//                .map()
//                .forEach(System.out::println);

//        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        Double total = costBeforeTax.stream()
//                .map(cost->cost*1.2)
//                .reduce((sum,cost)->sum+cost)
//                .get();
//        System.out.println(total);
//                .forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
//        List<Integer> distinct = numbers.stream().map(i-> i*i).distinct().collect(Collectors.toList());
//        distinct.forEach(System.out::println);

//        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
//        IntSummaryStatistics statistics = primes.stream().mapToInt(i->i).summaryStatistics();
//        System.out.println("max: " + statistics.getMax());
//        System.out.println("min: " + statistics.getMin());
//        System.out.println("sum: " + statistics.getSum());
//        System.out.println("avg: " + statistics.getAverage());

        Clock clock = Clock.systemUTC();
//        System.out.println(clock.instant());
//        System.out.println(clock.millis());

//        LocalDate date = LocalDate.now();
//        LocalDate dateFromClock = LocalDate.now(clock);
//        System.out.println(date + "\n" + dateFromClock);

//        LocalTime time = LocalTime.now();
//        LocalTime timeFromClock = LocalTime.now(clock);
//        System.out.println(time + "\n" + timeFromClock);

//        LocalDateTime time = LocalDateTime.now();
//        System.out.println(time);

//        ZonedDateTime time = ZonedDateTime.now();
//        System.out.println(time);

        LocalDateTime from = LocalDateTime.of(2017, Month.MAY, 12, 14, 0, 0);
        LocalDateTime to = LocalDateTime.now();
        Duration duration = Duration.between(from, to);
        System.out.println("Days: " + duration.toDays());
        System.out.println("hours: " + duration.toString());
    }

}
