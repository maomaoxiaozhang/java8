package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zhanggq on 2017/8/1.
 */
public class Contact {
    private String name;
    private long number;
    private Random random;

    public Contact() {
        random = new Random();
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public long getNumber() {
        return number;
    }

    public Contact setNumber(long number) {
        this.number = number;
        return this;
    }

    public boolean call() {
        return random.nextBoolean();
    }

    public static void main(String[] args){
        List<Contact> contacts = new ArrayList<>();
        long count = contacts.stream()
                .map(s -> new Contact().setName(s.getName()))
                .filter(c -> c.call())
                .count();
        System.out.println(count);
    }
}
