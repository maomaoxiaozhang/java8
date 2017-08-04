package lambda;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by zhanggq on 2017/8/1.
 */
public class ContactList extends ArrayList<String> {
    @Override
    public void forEach(Consumer<? super String>action){
        super.forEach(action);
    }

    public static void main(String[] args){
        ContactList contactList = new ContactList();
        contactList.add("Foo");
        contactList.add("Bar");
        contactList.add("Nico");

        System.out.println("consumer is coming ");
        contactList.forEach(new ContactAction());
        System.out.println("\nlambda is coming");
        contactList.forEach(s -> System.out.println(s + " is your contact."));
    }

    static class ContactAction implements Consumer<String>{

        @Override
        public void accept(String s) {
            System.out.println(s + " is your contact.");
        }
    }
}
