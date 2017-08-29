package seriablizable;

import java.io.Serializable;

/**
 * Created by zhanggq on 2017/8/16.
 */
public class Data implements Serializable {
    private static final long serialVersionUID = 7247714666080613254L;
    public int n;
    public Data(int n){
        this.n = n;
    }

    public String toString(){
        return Integer.toString(n);
    }
}
