package lambda;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by zhanggq on 2017/8/2.
 */
public class PrimeNumber {
    public static void main(String[] args){
        System.out.println("请输入范围：");
        Scanner scanner = new Scanner(System.in);
        int scope = scanner.nextInt();
        List<Integer> arrays = new LinkedList<>();
        for (int i = 0; i <= scope; i++){
            arrays.add(i);
        }
//        arrays.forEach(a->System.out.println(a));
        List<Integer> result = arrays.stream()
                .filter(i->Primes.isPrime(i))
                .collect(Collectors.toList());
        result.forEach(r->System.out.println(r));
    }
}

class Primes{
    public static boolean isPrime(int i){
        if (i <=1) return false;
        for (int j = 2; j*j <=i; j++){
            if (i%j==0)
                return false;
        }
        return true;
    }
}
