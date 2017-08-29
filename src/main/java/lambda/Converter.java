package lambda;

/**
 * Created by zhanggq on 2017/8/2.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
