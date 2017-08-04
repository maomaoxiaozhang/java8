package lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by zhanggq on 2017/8/1.
 */
public class TestMethodReference {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);

        button1.addActionListener(e -> System.out.println("lambda"));
        button2.addActionListener(TestMethodReference::doSomething);
    }

    public static void doSomething(ActionEvent event){
        System.out.println("methodReference");
    }
}
