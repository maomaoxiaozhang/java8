package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by zhanggq on 2017/8/1.
 */
public class LambdaStudying {
    public static void runThreadUseLambda(){
        new Thread(() -> System.out.println("Lambda")).start();
    }

    public static void runThreadUseInnerClass(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Innerclass");
            }
        }).start();
    }

    public static void runThreadUseMethodReference(){
        LambdaStudying instance = new LambdaStudying();
        new Thread(instance::doSomething).start();
    }

    public void doSomething(){
        System.out.println("methodReference");
    }

    public static void main(String[] args){
//        LambdaStudying.runThreadUseLambda();
//        LambdaStudying.runThreadUseInnerClass();
//        LambdaStudying.runThreadUseMethodReference();

//        List features = Arrays.asList("Lambdas", "Default method", "Stream API", "Date and Time API");
//        features.forEach(System.out::println);

//        List languages = Arrays.asList("Java", "Scala", "Haskell", "Lisp");
//        System.out.println("J:");
//        filter(languages, str -> str.equals("Java"));

//        Object o = (Runnable)()->{};
//        System.out.println(o.toString());

//        List<String> s = Arrays.asList("1", "2", "3", "4", "4");
//        List<Integer> i = s.stream()
//                .map(e -> new Integer(e))
//                .filter(e -> e%2==0)
//                .distinct()
//                .collect(Collectors.toList());
//        i.forEach(System.out::println);

        List<String> l = new ArrayList<>();
        l.add("aa");
        l.add("bb");
        l.add("cc");
        long t0 = System.nanoTime();
//        System.out.println("iterator");
        for (Iterator iterator = l.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        long t1 = System.nanoTime();
//        System.out.println("\nfor i");
        for (int i = 0; i < l.size(); i++){
            System.out.println(l.get(i));
        }
        long t2 = System.nanoTime();
//        System.out.println("\nfor in");
        for (String string : l){
            System.out.println(string);
        }
        long t3 = System.nanoTime();
//        System.out.println("\nforEach lambda");
        l.forEach(s -> System.out.println(s));
        long t4 = System.nanoTime();
//        System.out.println("\nforEach methodReference");
        l.forEach(System.out::println);
        long t5 = System.nanoTime();

        System.out.println("iterator: " + (t1-t0) + "\nfor i: " + (t2-t1) + "\nfor in: " + (t3-t2) +
        "\nforEach lambda: " + (t4-t3) + "\nforEach methodReference: " + (t5-t4));


    }

    public static void filter(List names, Predicate predicate){
        names.stream().filter((name) -> predicate.test(name))
                .forEach(System.out::println);
    }
}

