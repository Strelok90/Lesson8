package ru.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MyWindow extends JFrame  {

    public MyWindow() {
        setTitle("Lesson8");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        init();
    }

    public void init() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu file = new JMenu("File");
        menuBar.add(file);
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        exit.addActionListener(event -> System.exit(0));
        JTextField textField = new JTextField("Нажми мышкой или Enter ");
        JButton[] jbs = new JButton[5];
        textField.addActionListener(e -> {
            System.out.println("Вы нажали Enter ");
            System.out.println();
        });

        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("№" + i);
        }

        setLayout(new BorderLayout());
        add(jbs[0], BorderLayout.WEST);
        add(jbs[1], BorderLayout.CENTER);
        add(jbs[2], BorderLayout.EAST);
        add(textField, BorderLayout.NORTH);
        add(jbs[4], BorderLayout.SOUTH);

        jbs[0].addActionListener(this::ProcessClick);
        jbs[1].addActionListener(this::ProcessClick);
        jbs[2].addActionListener(this::ProcessClick);
        jbs[3].addActionListener(this::ProcessClick);
        jbs[4].addActionListener(this::ProcessClick);

        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.print("Клик по полю с текстом");
                System.out.println();
            }
        });
    }

    public void ProcessClick(ActionEvent e) {
        System.out.println("Привет! Нажми другую кнопку");
    }

    public static void main(String[] args) {
        new MyWindow().setVisible(true);
    }
}