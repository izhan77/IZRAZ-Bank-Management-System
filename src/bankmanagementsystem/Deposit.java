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
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JButton deposit, back;
    JTextField depositAmount;
    String pinNumber;
    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    Deposit(String pinNumber) {
        this.pinNumber = pinNumber;
        this.setTitle("Deposit");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        TransactionsBgPanel transactionsBgPanel = new TransactionsBgPanel("icons/atm.jpg");
        transactionsBgPanel.setLayout(null);

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

        JLabel text3 = new JLabel("Enter the amount you want to Deposit");
        text3.setFont(poppinsSmall2);
        text3.setForeground(Color.white);
        text3.setBounds(130,100,500,60);
        transactionsBgPanel.add(text3);

        depositAmount = new JTextField();
        depositAmount.setBounds(83, 150, 325, 25);
        depositAmount.setBackground(new Color(34, 130, 211));
        depositAmount.setForeground(Color.white);
        depositAmount.setFont(new Font("Monospaced", Font.BOLD, 17));
        transactionsBgPanel.add(depositAmount);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,220,130,30);
        deposit.setFont(poppinsSmall2);
        deposit.setBackground(new Color(34, 130, 211));
        deposit.setForeground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.WHITE);
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

        back = new JButton("Back");
        back.setBounds(170,270,130,30);
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
        transactionsBgPanel.add(back);





        this.setContentPane(transactionsBgPanel);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit){
            String amount = depositAmount.getText();
            Date date = new Date();
            if (amount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to deposit");
            }else if (!amount.matches("\\d+")|| Integer.parseInt(amount) <= 0) {
                JOptionPane.showMessageDialog(null, "Amount should be greater than zero");
            }
            else{
                try{
                    DatabaseConnection connection = new DatabaseConnection();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+amount+"')";
                    connection.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS " + amount + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }


}
