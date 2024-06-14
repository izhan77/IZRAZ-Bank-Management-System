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
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {
    JButton withdraw, back;
    JTextField withdrawlAmount;
    String pinNumber;
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    Withdrawl(String pinNumber) {
        this.pinNumber = pinNumber;
        this.setTitle("Withdraw");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        TransactionsBgPanel transactionsBgPanel = new TransactionsBgPanel("icons/atm.jpg");
        transactionsBgPanel.setLayout(null);

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

        JLabel text3 = new JLabel("Enter the amount you want to Withdraw");
        text3.setFont(poppinsSmall2);
        text3.setForeground(Color.white);
        text3.setBounds(130, 100, 500, 60);
        transactionsBgPanel.add(text3);

        withdrawlAmount = new JTextField();
        withdrawlAmount.setBounds(83, 150, 325, 25);
        withdrawlAmount.setBackground(new Color(34, 130, 211));
        withdrawlAmount.setForeground(Color.white);
        withdrawlAmount.setFont(new Font("Monospaced", Font.BOLD, 17));
        transactionsBgPanel.add(withdrawlAmount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(170, 220, 130, 30);
        withdraw.setFont(poppinsSmall2);
        withdraw.setBackground(new Color(34, 130, 211));
        withdraw.setForeground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.WHITE);
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

        back = new JButton("Back");
        back.setBounds(170, 270, 130, 30);
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
        if (ae.getSource() == withdraw) {
            String amountStr = withdrawlAmount.getText();
            Date date = new Date();
            if (amountStr.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
            }else if (!amountStr.matches("\\d+")|| Integer.parseInt(amountStr) <= 0) {
                JOptionPane.showMessageDialog(null, "Amount should be greater than zero");
            }
            else {
                int amount = Integer.parseInt(amountStr);//
                int currentBalance = getCurrentBalance();

                if (currentBalance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                } else {
                    try {
                        DatabaseConnection connection = new DatabaseConnection();
                        String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                        connection.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "RS " + amount + " Withdrawn Successfully");
                        setVisible(false);
                        new Transactions(pinNumber).setVisible(true);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    private int getCurrentBalance() {
        int balance = 0;
        try {
            DatabaseConnection connection = new DatabaseConnection();
            String query = "select * from bank where pinNumber = '" + pinNumber + "'";
            ResultSet rs = connection.s.executeQuery(query);
            while (rs.next()) {
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if (type.equals("Deposit")) {
                    balance += amount;
                } else if (type.equals("Withdraw")) {
                    balance -= amount;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return balance;
    }

    public static void main(String[] args) {
        new Withdrawl("");
    }
}
