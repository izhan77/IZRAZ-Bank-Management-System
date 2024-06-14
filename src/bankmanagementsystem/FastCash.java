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

public class FastCash extends JFrame implements ActionListener {
    JButton r1, r2, r3, r4, r5, r6, back;
    String pinNumber;
    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;
        this.setTitle("Fast Cash");
        this.setSize(700, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        TransactionsBgPanel transactionsBgPanel = new TransactionsBgPanel("icons/atm.jpg");
        transactionsBgPanel.setLayout(null);

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

        JLabel text3 = new JLabel("Select WithDrawl Amount");
        text3.setFont(poppinsSmall2);
        text3.setForeground(Color.white);
        text3.setBounds(165,90,500,60);
        transactionsBgPanel.add(text3);

        r1 = new JButton("RS 100");
        r1.setBounds(75,160,130,30);
        r1.setFont(poppinsSmall2);
        r1.setBackground(new Color(34, 130, 211));
        r1.setForeground(Color.white);
        r1.setBorder(border);
        r1.setFocusable(false);
        r1.addActionListener(this);
        r1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                r1.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                r1.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(r1);

        r2 = new JButton("RS 500");
        r2.setBounds(75,200,130,30);
        r2.setFont(poppinsSmall2);
        r2.setBackground(new Color(34, 130, 211));
        r2.setForeground(Color.white);
        r2.setBorder(border);
        r2.setFocusable(false);
        r2.addActionListener(this);
        r2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                r2.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                r2.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(r2);

        r3 = new JButton("RS 1000");
        r3.setBounds(75,240,130,30);
        r3.setFont(poppinsSmall2);
        r3.setBackground(new Color(34, 130, 211));
        r3.setForeground(Color.white);
        r3.setBorder(border);
        r3.setFocusable(false);
        r3.addActionListener(this);
        r3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                r3.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                r3.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(r3);

        r4 = new JButton("RS 2000");
        r4.setBounds(287,160,130,30);
        r4.setFont(poppinsSmall2);
        r4.setBackground(new Color(34, 130, 211));
        r4.setForeground(Color.white);
        r4.setBorder(border);
        r4.setFocusable(false);
        r4.addActionListener(this);
        r4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                r4.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                r4.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(r4);

        r5 = new JButton("RS 5000");
        r5.setBounds(287,200,130,30);
        r5.setFont(poppinsSmall2);
        r5.setBackground(new Color(34, 130, 211));
        r5.setForeground(Color.white);
        r5.setBorder(border);
        r5.setFocusable(false);
        r5.addActionListener(this);
        r5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                r5.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                r5.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(r5);

        r6 = new JButton("RS 10000");
        r6.setBounds(287,240,130,30);
        r6.setFont(poppinsSmall2);
        r6.setBackground(new Color(34, 130, 211));
        r6.setForeground(Color.white);
        r6.setBorder(border);
        r6.setFocusable(false);
        r6.addActionListener(this);
        r6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                r6.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                r6.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(r6);

        back = new JButton("BACK");
        back.setBounds(180,300,130,30);
        back.setFont(poppinsSmall2);
        back.setBackground(new Color(34, 211, 205));
        back.setForeground(Color.white);
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
        if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);//Rs 500
            DatabaseConnection connection = new DatabaseConnection();
            try{
                ResultSet rs = connection.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                connection.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }


}