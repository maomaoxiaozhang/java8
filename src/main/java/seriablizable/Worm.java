package seriablizable;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by zhanggq on 2017/8/16.
 */
public class Worm implements Serializable {
    public static final long serialVersionUID = 5468335797443850679L;
    private Data[] d = {
            new Data(0),
            new Data(1),
            new Data(2)
    };
    private static Random random = new Random(47);
    private Worm next;
    private char c;

    public Worm(int i, char c){
        System.out.println("Worm constructor " + i);
        this.c = c;
        if (--i > 0){
            next = new Worm(i, (char)(c+1));
        }
    }

    public Worm(){
        System.out.println("default constructor!");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder(":");
        sb.append(c);
        sb.append("(");
        for (Data data : d){
            sb.append(data);
        }
        sb.append(")");
        if (next != null){
            sb.append(next);
        }
        return sb.toString();
    }
}
