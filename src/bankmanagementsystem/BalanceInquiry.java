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

public class BalanceInquiry extends JFrame implements ActionListener {
    JButton back;
    String pinNumber;
    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    BalanceInquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        this.setTitle("Balance Inquiry");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        BalanceInquiryBgPanel balanceInquiryBgPanel = new BalanceInquiryBgPanel("icons/atm.jpg");
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

        back = new JButton("BACK");
        back.setBounds(176,333,130,30);
        back.setFont(poppinsSmall2);
        back.setBackground(new Color(34, 211, 205));
        back.setForeground(Color.white);
        back.setBorder(border);
        back.setFocusable(false);
        back.addActionListener(this);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                back.setBackground(new Color(11, 136, 133));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                back.setBackground(new Color(34, 211, 205));
            }
        });
        balanceInquiryBgPanel.add(back);

        DatabaseConnection connection = new DatabaseConnection();
        int balance = 0;
        try {
            ResultSet rs = connection.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text3 = new JLabel("<html>Your Current Account Balance is<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RS " + balance + "</html>");
        text3.setFont(poppinsSmall);
        text3.setForeground(Color.white);
        text3.setBounds(80,160,500,60);
        balanceInquiryBgPanel.add(text3);

        this.setContentPane(balanceInquiryBgPanel);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceInquiry("");
    }


}