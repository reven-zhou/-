package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import demo1.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("软件体系结构实验二");
        frame.setSize(1500, 1000);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(addPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static JButton addButton(int x,int y,GridBagConstraints btn,String name){
        JButton button = new JButton(name);
        button.setFont(new Font(null, Font.BOLD, 20));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);
        btn.gridy = x;//行
        btn.gridx = y;//列
//        btn.weightx = 0;
//        btn.weighty = 0;
        return button;
    }

    public  static JScrollPane addArea(int x,int y,int weight,int height,GridBagConstraints textArea,JTextArea desc){
        JScrollPane Text = new JScrollPane(desc);
        Text.setFont(new Font(null, Font.PLAIN, 100));
        textArea.gridy = x;
        textArea.gridx = y;
        textArea.weightx = weight;
        textArea.weighty = height;
        textArea.fill = GridBagConstraints.BOTH;
        return Text;
    }

    private static JComponent addPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints btn1 = new GridBagConstraints();
        GridBagConstraints btn2 = new GridBagConstraints();
        GridBagConstraints btn3 = new GridBagConstraints();
        GridBagConstraints btn4 = new GridBagConstraints();

        JButton button1 = addButton(0,0,btn1,"主程序子程序");
        JButton button2 = addButton(0,1,btn2,"面向对象");
        JButton button3 = addButton(0,2,btn3,"事件系统");
        JButton button4 = addButton(0,3,btn4,"管道过滤");

        panel.add(button1,btn1);
        panel.add(button2,btn2);
        panel.add(button3,btn3);
        panel.add(button4,btn4);

        ImageIcon img = new ImageIcon("src\\otherfile\\demo1.png");
        JLabel label = new JLabel(img);
        GridBagConstraints imgArea = new GridBagConstraints();
        imgArea.gridy = 2;
        imgArea.gridx = 0;
        imgArea.weightx = 1;
        imgArea.weighty = 1;
        imgArea.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, imgArea);

        JTextArea desc = new JTextArea("软件体系结构说明:\r\n");
        GridBagConstraints textArea1 = new GridBagConstraints();
        JScrollPane scrollPane1 = addArea(1,0,1,1,textArea1,desc);
        panel.add(scrollPane1, textArea1);

        JTextArea result = new JTextArea("运行结果");
        GridBagConstraints textArea2 = new GridBagConstraints();
        JScrollPane scrollPane2 = addArea(1,1,1,2,textArea2,result);
        panel.add(scrollPane2, textArea2);


        JTextArea code = new JTextArea("核心代码:\n");
        GridBagConstraints textArea3 = new GridBagConstraints();
        JScrollPane scrollPane3 = addArea(2,1,4,1,textArea3,code);
        panel.add(scrollPane3, textArea3);


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    result.setText("主程序-子程序演示运行结果：");
                    desc.setText("体系结构说明:\r\n" + "组件–主程序、子程序\n" +
                            "\n" +
                            "连接件–调用-返回机制\n" +
                            "\n" +
                            "拓扑结构–层次化结构\n" +
                            "\n" +
                            "主程序-子过程风格的优点与缺点\n" +
                            "\n" +
                            "§优点:\n" +
                            "\n" +
                            "–有效地将一个较复杂的程序系统设计任务分解成许多易于控制和处理的子任务，便于开发和维护–已被证明是成功的设计方法，可以被用于较大程序\n" +
                            "\n" +
                            "缺点:\n" +
                            "\n" +
                            "–规模：程序超过10万行，表现不好；程序太大，开发太慢，测试越来越困难\n" +
                            "\n" +
                            "–可重用性差、数据安全性差，难以开发大型软件和图形界面的应用软件\n" +
                            "\n" +
                            "–把数据和处理数据的过程分离为相互独立的实体，当数据结构改变时，所有相关的处理过程都要进行相应的修改\n" +
                            "\n" +
                            "–图形用户界面的应用程序，很难用过程来描述和实现，开发和维护也都很困难。\n" +
                            "\n" +
                            "\n");
                    code.setText("核心代码:\r\n"
                            + "public static void main(String[] args) {\r\n"
                            + "        demo1 kwic = new demo1();\r\n"
                            + "        kwic.input(\"E:\\软件体系结构实验\\实验二\\main\\src\\otherfile\\input.txt\");\r\n"
                            + "        kwic.shift();\r\n"
                            + "        kwic.alphabetizer();\r\n"
                            + "        kwic.output(\"E:\\软件体系结构实验\\实验二\\main\\src\\otherfile\\output.txt\");\r\n"
                            + "    }");
                    label.setIcon(new ImageIcon("src\\otherfile\\demo2.png"));
                    clearFile();
                    demo1.main(null);
                    String result_content = getFileText();
                    result.append(result_content);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //运行
                    result.setText("面向对象演示运行结果：");//表示清空
                    desc.setText("体系结构说明:\r\n"+"组件是：类和对象\n" +
                            "\n" +
                            "连接件：对象之间通过功能与函数调用实现交互。\n" +
                            "\n" +
                            "OO风格优点\n" +
                            "\n" +
                            "§复用和维护：利用封装和聚合提高生产力\n" +
                            "\n" +
                            "–因为对象对其它对象隐藏它的表示，所以可以改变一个对象的表示，而不影响其它的对象。\n" +
                            "\n" +
                            "–某一组件的算法与数据结构的修改不会影响其他组件\n" +
                            "\n" +
                            "–组件之间依赖性降低，提高了复用度\n" +
                            "\n" +
                            "§反映现实世界\n" +
                            "\n" +
                            "§容易分解一个系统\n" +
                            "\n" +
                            "–设计者可将一些数据存取操作的问题分解成一些交互的代理程序的集合\n" +
                            "\n" +
                            "OO风格缺点\n" +
                            "\n" +
                            "§管理大量的对象：怎样确立大量对象的结构\n" +
                            "\n" +
                            "§继承引起复杂度，关键系统中慎用\n" +
                            "\n" +
                            "§必须知道对象的身份\n" +
                            "\n" +
                            "–为了使一个对象和另一个对象通过过程调用等进行交互，必须知道对象的标识。只要一个对象的标识改变了，就必须修改所有其他明确显式调用它的对象，并消除由此带来的一些副作用(例如，如果A使用了对象B，C也使用了对象B，那么，C对B的使用所造成的对A的影响可能是料想不到的)\n");
                    code.setText("核心代码:\r\n"
                            + "public static void main(String[] args) {\r\n"
                            + "        Input input = new Input();\r\n"
                            + "        input.input(\"src\\publicc\\input.txt\");\r\n"
                            + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                            + "        shift.shift();\r\n"
                            + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                            + "        alphabetizer.sort();\r\n"
                            + "        Output output = new Output(alphabetizer.getKwicList());\r\n"
                            + "        output.output(\"src\\publicc\\output.txt\");\r\n"
                            + "    }");
                    label.setIcon(new ImageIcon("src\\otherfile\\demo2.png"));
                    clearFile();
                    demo2.Main.main(null);
                    String result_content = getFileText();
                    result.append(result_content);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //运行
                    result.setText("事件系统-观察者模式演示运行结果：");
                    desc.setText("体系结构说明:\r\n"+"事件：能够激活对象功能的动作，当发生动作后会给所涉及对象发送一条消息，对象便可执行相应的功能。\n" +
                            "\n" +
                            "事件系统主要分为隐式调用和显示调用两种\n" +
                            "\n" +
                            "隐式调用：1.事件的触发者不知道那些构件会被影响，相互独立\n" +
                            "\n" +
                            "2.不能假设构件的处理顺序，甚至不知道哪些构件或过程会被调用\n" +
                            "\n" +
                            "3.在整个系统中，各个构件之间无联系，各自独立，通过对事件的发布和注册实现关联\n"
                            + "这个主题对象在状态变化时，\n会通知所有的观察者对象，\n使他们能够自动更新自己。\n它可以实现表示层和数据逻辑层的分离。");
                    code.setText("核心代码:\r\n"
                            + "public static void main(String[] args) {\r\n"
                            + "        //创建主题\r\n"
                            + "        KWICSubject kwicSubject = new KWICSubject();\r\n"
                            + "        //创建观察者\r\n"
                            + "        Input input = new Input(\"src\\otherfile\\input.txt\");\r\n"
                            + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                            + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                            + "        Output output = new Output(alphabetizer.getKwicList(), \"E:\\软件体系结构实验\\实验二\\main\\src\\publicc\\output.txt\");\r\n"
                            + "\r\n"
                            + "        // 将观察者加入主题\r\n"
                            + "        kwicSubject.addObserver(input);\r\n"
                            + "        kwicSubject.addObserver(shift);\r\n"
                            + "        kwicSubject.addObserver(alphabetizer);\r\n"
                            + "        kwicSubject.addObserver(output);\r\n"
                            + "        // 逐步调用各个观察者\r\n"
                            + "        kwicSubject.startKWIC();\r\n"
                            + "    }");
                    label.setIcon(new ImageIcon("src\\otherfile\\demo3.png"));
                    clearFile();
                    demo3.Main.main(null);
                    String result_content = getFileText();
                    result.append(result_content);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    //运行
                    result.setText("管道-过滤演示运行结果：");
                    desc.setText("体系结构说明:\r\n"+"过滤器视为组件。\n" +
                            "管道视为连接件。\n" +
                            "管道将一个过滤器的输出传给另一个过滤器的输入。\n" +
                            "\n" +
                            "优点：\n" +
                            "1.高效的并行效率（灵活使用active（主动） 过滤器）\n" +
                            "2.过滤器可以重组/重用/可替换\n" +
                            "3.不需要中间保存\n" +
                            "\n" +
                            "缺点：\n" +
                            "1.数据传输和转化开销大\n" +
                            "2.错误处理复杂"
                            + "适用于很容易地被分解成一组离散的、独立的步骤的软件。");
                    code.setText("核心代码:\r\n"
                            + "public static void main(String[] args) throws IOException {\r\n"
                            + "        File inFile = new File(\"src\\publicc\\input.txt\");\r\n"
                            + "        File outFile = new File(\"src\\publicc\\output.txt\");\r\n"
                            + "        Pipe pipe1 = new Pipe();\r\n"
                            + "        Pipe pipe2 = new Pipe();\r\n"
                            + "        Pipe pipe3 = new Pipe();\r\n"
                            + "        Input input = new Input(inFile, pipe1);\r\n"
                            + "        Shift shift = new Shift(pipe1, pipe2);\r\n"
                            + "        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\r\n"
                            + "        Output output = new Output(outFile,pipe3);\r\n"
                            + "        input.transform();\r\n"
                            + "        shift.transform();\r\n"
                            + "        alphabetizer.transform();\r\n"
                            + "        output.transform();\r\n"
                            + "    }");
                    label.setIcon(new ImageIcon("src\\otherfile\\demo4.png"));
                    clearFile();
                    demo4.Main.main(null);
                    String result_content = getFileText();
                    result.append(result_content);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        return panel;
    }


    public static void clearFile() {
        File file = new File("E:\\软件体系结构实验\\实验二\\main\\src\\otherfile\\output.txt");
        FileWriter filewriter;
        try {
            filewriter = new FileWriter(file);
            filewriter.write("");
            filewriter.flush();
            filewriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getFileText() {
        File file = new File("E:\\软件体系结构实验\\实验二\\main\\src\\otherfile\\output.txt");
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader bufferedreader = new BufferedReader(new FileReader(file));
            String res = null;
            while ((res = bufferedreader.readLine()) != null) {
                result.append(System.lineSeparator() + res);
            }
            bufferedreader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }


}