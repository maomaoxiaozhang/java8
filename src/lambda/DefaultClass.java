package lambda;

/**
 * Created by zhanggq on 2017/8/1.
 */
interface A{
    default void foo(){
        System.out.println("A");
    }
}

interface B extends A{
    default void foo(){
        System.out.println("B");
    }
}

public class DefaultClass implements B{
//    @Override
//    public void foo(){
//        A.super.foo();
//    }

    public void foo(){
        System.out.println("c");
    }

    public static void main(String[] args){
        new DefaultClass().foo();
    }
}
