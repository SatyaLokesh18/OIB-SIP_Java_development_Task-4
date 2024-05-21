import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

class login extends JFrame implements ActionListener {
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;

    login() {
        userLabel = new JLabel();
        userLabel.setText("    Username :");
        textField1 = new JTextField(15);
        passLabel = new JLabel();
        passLabel.setText("    Password :");
        textField2 = new JPasswordField(8);
        b1 = new JButton("   SUBMIT   ");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        newPanel.add(b1);
        add(newPanel, BorderLayout.CENTER);
        b1.addActionListener(this);
        setTitle("Login Form ");
    }

    public void actionPerformed(ActionEvent ae) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();
        if (!passValue.equals(""))
            new OnlineTestBegin(userValue);
        else {
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }
}

class OnlineTestBegin extends JFrame implements ActionListener {
    JLabel l;
    JLabel l1;
    JRadioButton jb[] = new JRadioButton[6];
    JButton b1, b2, log;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    Timer timer = new Timer();

    OnlineTestBegin(String s) {
        super(s);
        l = new JLabel();
        l1 = new JLabel();
        add(l);
        add(l1);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Save and Next");
        b2 = new JButton("Save for later");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        l1.setBounds(20, 20, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(95, 240, 140, 30);
        b2.setBounds(270, 240, 150, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 600;

            public void run() {
                l1.setText("Time left: " + i);
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Out");
                }
            }
        }, 0, 1000);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Save for later")) {
            JButton bk = new JButton("Review" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Review" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }
        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Score =" + count);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Who holds the record for the highest individual score in a Test match?");
            jb[0].setText("Brian Lara");
            jb[1].setText("Sachin Tendulkar");
            jb[2].setText("Ricky Ponting");
            jb[3].setText("Don Bradman");
        }
        if (current == 1) {
            l.setText("Que2: Who won the ICC Cricket World Cup in 2019?");
            jb[0].setText("Australia");
            jb[1].setText("India");
            jb[2].setText("England");
            jb[3].setText("New Zealand");
        }
        if (current == 2) {
            l.setText("Que3: Which cricketer is known as 'The Wall'?");
            jb[0].setText("Rahul Dravid");
            jb[1].setText("Virat Kohli");
            jb[2].setText("Steve Waugh");
            jb[3].setText("Jacques Kallis");
        }
        if (current == 3) {
            l.setText("Que4: Who has taken the most wickets in Test cricket?");
            jb[0].setText("Shane Warne");
            jb[1].setText("Muttiah Muralitharan");
            jb[2].setText("James Anderson");
            jb[3].setText("Anil Kumble");
        }
        if (current == 4) {
            l.setText("Que5: Which cricketer is known as the 'God of Cricket'?");
            jb[0].setText("Virat Kohli");
            jb[1].setText("Sachin Tendulkar");
            jb[2].setText("Brian Lara");
            jb[3].setText("AB de Villiers");
        }
        if (current == 5) {
            l.setText("Que6: What is the maximum number of overs in a T20 cricket match?");
            jb[0].setText("10");
            jb[1].setText("20");
            jb[2].setText("50");
            jb[3].setText("60");
        }
        if (current == 6) {
            l.setText("Que7: Who was the first cricketer to score 10,000 runs in Test cricket?");
            jb[0].setText("Sunil Gavaskar");
            jb[1].setText("Allan Border");
            jb[2].setText("Sachin Tendulkar");
            jb[3].setText("Brian Lara");
        }
        if (current == 7) {
            l.setText("Que8: Which team has won the most ICC Cricket World Cup titles?");
            jb[0].setText("West Indies");
            jb[1].setText("India");
            jb[2].setText("Australia");
            jb[3].setText("England");
        }
        if (current == 8) {
            l.setText("Que9: Who is the highest run-scorer in One Day Internationals (ODIs)?");
            jb[0].setText("Virat Kohli");
            jb[1].setText("Ricky Ponting");
            jb[2].setText("Sachin Tendulkar");
            jb[3].setText("Kumar Sangakkara");
        }
        if (current == 9) {
            l.setText("Que10: Who is the only cricketer to have taken two hat-tricks in the same Test match?");
            jb[0].setText("Brett Lee");
            jb[1].setText("Shane Warne");
            jb[2].setText("Wasim Akram");
            jb[3].setText("Jimmy Matthews");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[0].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[0].isSelected());
        if (current == 3)
            return (jb[1].isSelected());
        if (current == 4)
            return (jb[1].isSelected());
        if (current == 5)
            return (jb[1].isSelected());
        if (current == 6)
            return (jb[0].isSelected());
        if (current == 7)
            return (jb[2].isSelected());
        if (current == 8)
            return (jb[2].isSelected());
        if (current == 9)
            return (jb[3].isSelected());
        return false;
    }
}

class OnlineExam {
    public static void main(String args[]) {
        try {
            login form = new login();
            form.setSize(400, 150);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
