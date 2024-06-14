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
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener {
    String pinNumber;
    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsMedium2;
    Font poppinsLarge2;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;
    Font poppinsSmall21;

    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        this.setTitle("Mini Statement");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setBounds(570,219,400,600);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        BalanceInquiryBgPanel balanceInquiryBgPanel = new BalanceInquiryBgPanel("icons/white.png");
        balanceInquiryBgPanel.setLayout(null);

        Border border = BorderFactory.createLineBorder(Color.WHITE);

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

        // loading the poppins light font
        try (InputStream is = ClassLoader.getSystemResourceAsStream("poppins/Poppins-Regular.ttf")) {
            if (is != null) {
                poppins = Font.createFont(Font.TRUETYPE_FONT, is);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(poppins);
                poppinsLarge2 = poppins.deriveFont(48f);
                poppinsMedium2 = poppins.deriveFont(36f);
                poppinsSmall2 = poppins.deriveFont(24f);
                poppinsSmall21 = poppins.deriveFont(15f);
            } else {
                System.err.println("Font not found");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        //header
        JLabel text = new JLabel("IZRAZ");
        text.setFont(poppinsSmall1);
        text.setForeground(Color.BLACK);
        text.setBounds(195, 6, 500, 60);
        balanceInquiryBgPanel.add(text);

        JLabel text1 = new JLabel("Bank");
        text1.setFont(poppinsSmall1);
        text1.setForeground(Color.BLACK);
        text1.setBounds(195, 24, 500, 60);
        balanceInquiryBgPanel.add(text1);

        //addition and scaling of the logo image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/logob&w.png"));
        Image i22 = i11.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel label1 = new JLabel(i33);
        label1.setBounds(150, 21, 50, 50);
        balanceInquiryBgPanel.add(label1);

        JLabel text5 = new JLabel("-----------------------------------------------------------");
        text5.setFont(poppinsSmall1);
        text5.setForeground(Color.BLACK);
        text5.setBounds(1, 40, 500, 60);
        balanceInquiryBgPanel.add(text5);

        JLabel card = new JLabel("Card Number : ");
        card.setBounds(60, 100, 300,30);
        card.setFont(poppinsSmall1.deriveFont(12f));
        card.setForeground(Color.black);
        balanceInquiryBgPanel.add(card);

        JLabel cardNumber = new JLabel();
        cardNumber.setBounds(160, 100, 300,30);
        cardNumber.setFont(poppinsSmall1.deriveFont(12f));
        cardNumber.setForeground(Color.black);
        balanceInquiryBgPanel.add(cardNumber);

        JLabel h1 = new JLabel("Transaction History");
        h1.setBounds(120, 150, 300,30);
        h1.setFont(poppinsSmall1.deriveFont(15f));
        h1.setForeground(Color.black);
        balanceInquiryBgPanel.add(h1);

        JLabel mini = new JLabel();
        mini.setBounds(10, 115, 500,200);
        mini.setFont(new Font("Monospaced", Font.PLAIN, 12));
        mini.setForeground(Color.black);
        balanceInquiryBgPanel.add(mini);

        try{
            DatabaseConnection connection = new DatabaseConnection();
            ResultSet rs = connection.s.executeQuery("select * from login where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                cardNumber.setText(rs.getString("cardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardNumber").substring(12));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        JLabel b = new JLabel();
        b.setBounds(160, 383, 150,100);
        b.setFont(new Font("Monospaced", Font.PLAIN, 12));
        b.setForeground(Color.black);
        balanceInquiryBgPanel.add(b);

        try{
            DatabaseConnection connection = new DatabaseConnection();
            int bal = 0;
            ResultSet rs = connection.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
                if (rs.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            b.setText("" + bal);
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text7 = new JLabel("-----------------------------------------------------------");
        text7.setFont(poppinsSmall1);
        text7.setForeground(Color.BLACK);
        text7.setBounds(1, 380, 500, 60);
        balanceInquiryBgPanel.add(text7);

        JLabel balance = new JLabel("Total Balance : ");
        balance.setBounds(60, 420, 300,30);
        balance.setFont(poppinsSmall1.deriveFont(12f));
        balance.setForeground(Color.black);
        balanceInquiryBgPanel.add(balance);

        JLabel text6 = new JLabel("-----------------------------------------------------------");
        text6.setFont(poppinsSmall1);
        text6.setForeground(Color.BLACK);
        text6.setBounds(1, 430, 500, 60);
        balanceInquiryBgPanel.add(text6);

        //footer
        JLabel text2 = new JLabel("IZRAZ Bank");
        text2.setFont(poppinsSmall1.deriveFont(11f));
        text2.setForeground(Color.BLACK);
        text2.setBounds(155, 450, 500, 60);
        balanceInquiryBgPanel.add(text2);

        JLabel text3 = new JLabel("-----------------------------------------------------------");
        text3.setFont(poppinsSmall1);
        text3.setForeground(Color.BLACK);
        text3.setBounds(1, 470, 500, 60);
        balanceInquiryBgPanel.add(text3);

        JLabel text4 = new JLabel("<html>All transactions are subject to final<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;proof and verification.</html>");
        text4.setFont(poppinsSmall21.deriveFont(10f));
        text4.setForeground(Color.BLACK);
        text4.setBounds(105, 500, 500, 60);
        balanceInquiryBgPanel.add(text4);



        this.setContentPane(balanceInquiryBgPanel);
//        this.setUndecorated(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }


}