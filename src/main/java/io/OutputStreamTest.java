package io;

import java.io.*;

/**
 * Created by zhanggq on 2017/8/29.
 */
public class OutputStreamTest {
    private static String file = "C:\\Users\\zhanggq\\Desktop\\moon.txt";
    private static String str = "中国";

    public static void writeByte(){
        try {
            OutputStream os = new FileOutputStream(file, false);
            os.write(str.getBytes());
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInt(){
        try {
            OutputStream os = new FileOutputStream(file);
            os.write(100);
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copy() throws IOException {
        String from = "C:\\Users\\zhanggq\\Desktop\\from.txt";
        String to = "C:\\Users\\zhanggq\\Desktop\\to.txt";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }
        bos.flush();
        bos.close();
        bis.close();
    }

    public static void main(String[] args) throws IOException {
//        writeByte();
//        writeInt();
        copy();
//        InputStreamTest.readByte();
    }
}
