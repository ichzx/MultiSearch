package com.multisearch.read.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SearchView {
    static String url,url2,url3,url4,url5;
    static JTextField searchText;
    public static void PlaceComponents(JPanel panel){
        panel.setLayout(null);
        JLabel label = new JLabel("MultiSearch");
        label.setFont(new java.awt.Font("Dialog",1,50));
        label.setForeground(Color.BLACK);
        label.setBounds(260,100,300,200);
        panel.add(label);
        searchText = new JTextField(200);
        searchText.setBounds(167,290,466,50);
        panel.add(searchText);
        searchText.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER){
                    sameUrl();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(355,350,90,30);
        panel.add(searchButton);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                sameUrl();
            }
        });
    }

    public static void sameUrl(){
        String text = searchText.getText();
        String newText = text.replace(' ','+');
        url = "https://search.yahoo.com/search?p="+newText;
        url2 = "https://www.baidu.com/s?wd="+newText;
        url3 = "https://www.google.com/#newwindow=1&q="+newText;
        url4 = "https://cn.bing.com/search?q="+newText;
        url5 = "https://www.sogou.com/web?query="+newText;
        new BrowserUrl().browserUrl(url);
        new BrowserUrl().browserUrl(url2);
        new BrowserUrl().browserUrl(url3);
        new BrowserUrl().browserUrl(url4);
        new BrowserUrl().browserUrl(url5);
    }

    public static void main(String[] args){
        //JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("MultiSearch");
        frame.setSize(800,600);     //窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);      //窗口居中

        JPanel panel = new JPanel();
        frame.add(panel);

        PlaceComponents(panel);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
