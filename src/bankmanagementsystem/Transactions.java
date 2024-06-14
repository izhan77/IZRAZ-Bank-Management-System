package bankmanagementsystem;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

public class Transactions extends JFrame implements ActionListener {
    JButton deposit, withdraw, balanceInquiry, miniStatement, exit, fastCash, pinChange;
    String pinNumber;
    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        this.setTitle("ATM");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        TransactionsBgPanel transactionsBgPanel = new TransactionsBgPanel("icons/atm.jpg");
        transactionsBgPanel.setLayout(null);

        //addition and scaling of the logo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150, 100, 80, 80);
        transactionsBgPanel.add(label);

        // loading the poppins font
        try (InputStream is = ClassLoader.getSystemResourceAsStream("poppins/Poppins-SemiBold.ttf")) {
            if (is != null) {
                poppins = Font.createFont(Font.TRUETYPE_FONT, is);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(poppins);
                poppinsLarge = poppins.deriveFont(70f);
                poppinsMedium = poppins.deriveFont(36f);
                poppinsSmall = poppins.deriveFont(20f);
                poppinsSmall1 = poppins.deriveFont(15f);
                poppinsSmall2 = poppins.deriveFont(12f);
            } else {
                System.err.println("Font not found");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel text = new JLabel("IZRAZ");
        text.setFont(poppinsMedium);
        text.setForeground(Color.white);
        text.setBounds(230, 95, 500, 60);
        transactionsBgPanel.add(text);

        JLabel text1 = new JLabel("Bank");
        text1.setFont(poppinsMedium);
        text1.setForeground(Color.white);
        text1.setBounds(230, 130, 500, 60);
        transactionsBgPanel.add(text1);
        Border border = BorderFactory.createLineBorder(Color.WHITE);

        JLabel text2 = new JLabel("Your trusted banking partner");
        text2.setFont(poppinsSmall1);
        text2.setForeground(Color.white);
        text2.setBounds(130, 160, 500, 60);
        transactionsBgPanel.add(text2);

        JLabel text3 = new JLabel("Please Select your Transaction");
        text3.setFont(poppinsSmall2);
        text3.setForeground(Color.white);
        text3.setBounds(150,200,500,60);
        transactionsBgPanel.add(text3);

        deposit = new JButton("Deposit");
        deposit.setBounds(75,250,130,30);
        deposit.setFont(poppinsSmall2);
        deposit.setBackground(new Color(34, 130, 211));
        deposit.setForeground(Color.white);
        deposit.setBorder(border);
        deposit.setFocusable(false);
        deposit.addActionListener(this);
        deposit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deposit.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deposit.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(75,290,130,30);
        withdraw.setFont(poppinsSmall2);
        withdraw.setBackground(new Color(34, 130, 211));
        withdraw.setForeground(Color.white);
        withdraw.setBorder(border);
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);
        withdraw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                withdraw.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                withdraw.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(withdraw);

        balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setBounds(75,330,130,30);
        balanceInquiry.setFont(poppinsSmall2);
        balanceInquiry.setBackground(new Color(34, 130, 211));
        balanceInquiry.setForeground(Color.white);
        balanceInquiry.setBorder(border);
        balanceInquiry.setFocusable(false);
        balanceInquiry.addActionListener(this);
        balanceInquiry.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                balanceInquiry.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                balanceInquiry.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(balanceInquiry);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(288,250,130,30);
        miniStatement.setFont(poppinsSmall2);
        miniStatement.setBackground(new Color(34, 130, 211));
        miniStatement.setForeground(Color.white);
        miniStatement.setBorder(border);
        miniStatement.setFocusable(false);
        miniStatement.addActionListener(this);
        miniStatement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                miniStatement.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                miniStatement.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(miniStatement);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(288,290,130,30);
        pinChange.setFont(poppinsSmall2);
        pinChange.setBackground(new Color(34, 130, 211));
        pinChange.setForeground(Color.white);
        pinChange.setBorder(border);
        pinChange.setFocusable(false);
        pinChange.addActionListener(this);
        pinChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pinChange.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pinChange.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(pinChange);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(288,330,130,30);
        fastCash.setFont(poppinsSmall2);
        fastCash.setBackground(new Color(34, 130, 211));
        fastCash.setForeground(Color.white);
        fastCash.setBorder(border);
        fastCash.setFocusable(false);
        fastCash.addActionListener(this);
        fastCash.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                fastCash.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fastCash.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(fastCash);

        exit = new JButton("EXIT");
        exit.setBounds(210,378,70,20);
        exit.setFont(poppinsSmall2);
        exit.setBackground(new Color(34, 211, 205));
        exit.setForeground(Color.white);
        exit.setBorder(null);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(new Color(11, 136, 133));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(new Color(34, 211, 205));
            }
        });
        transactionsBgPanel.add(exit);



        this.setContentPane(transactionsBgPanel);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit){
            System.exit(0);
        }
        else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if (ae.getSource()== withdraw){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == pinChange){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == balanceInquiry){
            setVisible(false);
            new BalanceInquiry(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == miniStatement){
            new MiniStatement(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Transactions("");
    }


}
