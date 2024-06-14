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

public class PinChange extends JFrame implements ActionListener {
    JButton back, change;
    JPasswordField pinTextField, repinTextField;
    String pinNumber;
    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    PinChange(String pinNumber) {
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

        JLabel text3 = new JLabel("Change your PIN");
        text3.setFont(poppinsSmall);
        text3.setForeground(Color.white);
        text3.setBounds(163,90,500,60);
        transactionsBgPanel.add(text3);

        JLabel pin = new JLabel("New PIN : ");
        pin.setFont(poppinsSmall2);
        pin.setForeground(Color.white);
        pin.setBounds(220,150,500,60);
        transactionsBgPanel.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(110, 190, 270, 20);
        pinTextField.setBackground(new Color(34, 130, 211));
        pinTextField.setForeground(Color.white);
        pinTextField.setEditable(true);
        pinTextField.setFont(new Font("Monospaced", Font.BOLD, 17));
        transactionsBgPanel.add(pinTextField);

        JLabel repin = new JLabel("Confirm New PIN : ");
        repin.setFont(poppinsSmall2);
        repin.setForeground(Color.white);
        repin.setBounds(195,210,500,60);
        transactionsBgPanel.add(repin);

        repinTextField = new JPasswordField();
        repinTextField.setBounds(110, 250, 270, 20);
        repinTextField.setBackground(new Color(34, 130, 211));
        repinTextField.setForeground(Color.white);
        repinTextField.setFont(new Font("Monospaced", Font.BOLD, 17));
        transactionsBgPanel.add(repinTextField);

        change = new JButton("CHANGE");
        change.setBounds(287,335,130,30);
        change.setFont(poppinsSmall2);
        change.setBackground(new Color(34, 130, 211));
        change.setForeground(Color.white);
        change.setBorder(border);
        change.setFocusable(false);
        change.addActionListener(this);
        change.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                change.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                change.setBackground(new Color(34, 130, 211));
            }
        });
        transactionsBgPanel.add(change);

        back = new JButton("BACK");
        back.setBounds(75,335,130,30);
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
        if (ae.getSource() == change){
            try{
                String newpin=  pinTextField.getText();
                String repin = repinTextField.getText();

                if (!newpin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match!");
                    return;
                }

                if (newpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }
                if (repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }

                DatabaseConnection connection = new DatabaseConnection();
                String query1 = "update bank set pinNumber = '"+repin+"' where pinNumber = '"+pinNumber+"'";
                String query2 = "update login set pinNumber = '"+repin+"' where pinNumber = '"+pinNumber+"'";
                String query3 = "update signupthree set pinNumber = '"+repin+"' where pinNumber = '"+pinNumber+"'";

                connection.s.executeUpdate(query1);
                connection.s.executeUpdate(query2);
                connection.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new Transactions(repin).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }


}
