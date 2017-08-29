package io;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhanggq on 2017/8/25.
 */
public class InputStreamTest {
    private static String file = "C:\\Users\\zhanggq\\Desktop\\moon.txt";

    public static void readOne(){
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            int by = 0;
            while ((by = inputStream.read()) != -1){
                System.out.print((char)by);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readByte() {
        try {
            InputStream is = new FileInputStream(file);
            byte[] bytes = new byte[10];
            int len = 0;
            while ((len = is.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, len));
            }
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedInputStream(){
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] bytes = new byte[1];
            int len = 0;
            while ((len = bis.read(bytes)) != -1){
                System.out.print(new String(bytes, 0, len));
            }
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        readOne();
//        readByte();
        bufferedInputStream();
    }
}
