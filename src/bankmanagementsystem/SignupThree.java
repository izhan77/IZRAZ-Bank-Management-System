package bankmanagementsystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Random;


public class SignupThree extends JFrame implements ActionListener {

    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge1;
    Font poppinsLarge2;
    Font poppinsMedium1;
    Font poppinsMedium2;
    Font poppinsSmall;
    Font poppinsSmall21;
    Font poppinsSmall1;
    Font poppinsSmall2;
    Font poppinsSmall22;

    JButton submit, cancel;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    String formNumber;

    SignupThree(String formNumber) {
        this.formNumber = formNumber;
        this.setTitle("Sign Up - Page 3");
        this.setSize(700, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        SignupBgPanel signupBgPanel = new SignupBgPanel("icons/bg2.png");
        signupBgPanel.setLayout(null);

        //addition and scaling of the logo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signuplogo2.png"));
        Image i2 = i1.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(40, 40, 48, 48);
        signupBgPanel.add(label);

        // loading the poppins bold font
        try (InputStream is = ClassLoader.getSystemResourceAsStream("poppins/Poppins-SemiBold.ttf")) {
            if (is != null) {
                poppins = Font.createFont(Font.TRUETYPE_FONT, is);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(poppins);
                poppinsLarge1 = poppins.deriveFont(48f);
                poppinsMedium1 = poppins.deriveFont(36f);
                poppinsSmall = poppins.deriveFont(24f);
                poppinsSmall1 = poppins.deriveFont(15f);
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
                poppinsSmall21 = poppins.deriveFont(13f);
                poppinsSmall22 = poppins.deriveFont(10f);
            } else {
                System.err.println("Font not found");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel accountDetails = new JLabel("Account Details");
        accountDetails.setFont(poppinsSmall);
        accountDetails.setForeground(Color.white);
        accountDetails.setBounds(250,40,700,60);
        signupBgPanel.add(accountDetails);

        JLabel cardNumber = new JLabel("Card Number : ");
        cardNumber.setFont(poppinsSmall);
        cardNumber.setForeground(Color.white);
        cardNumber.setBounds(80, 140, 200, 60);
        signupBgPanel.add(cardNumber);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-7047");
        number.setFont(poppinsSmall);
        number.setForeground(Color.white);
        number.setBounds(290, 140, 300, 60);
        signupBgPanel.add(number);

        JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
        cardDetail.setFont(poppinsSmall21);
        cardDetail.setForeground(Color.white);
        cardDetail.setBounds(80, 170, 300, 60);
        signupBgPanel.add(cardDetail);

        JLabel pinNumber = new JLabel("PIN : ");
        pinNumber.setFont(poppinsSmall);
        pinNumber.setForeground(Color.white);
        pinNumber.setBounds(80, 220, 200, 60);
        signupBgPanel.add(pinNumber);

        JLabel pinDetail = new JLabel("Your 4 Digit PIN Number");
        pinDetail.setFont(poppinsSmall21);
        pinDetail.setForeground(Color.white);
        pinDetail.setBounds(80, 250, 300, 60);
        signupBgPanel.add(pinDetail);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(poppinsSmall);
        pnumber.setForeground(Color.white);
        pnumber.setBounds(290, 220, 300, 60);
        signupBgPanel.add(pnumber);

        JLabel servicesRequired = new JLabel("Services Required");
        servicesRequired.setFont(poppinsSmall);
        servicesRequired.setForeground(Color.white);
        servicesRequired.setBounds(235,320,700,60);
        signupBgPanel.add(servicesRequired);

        CustomCheckboxIcon checkboxIcon = new CustomCheckboxIcon(24);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(poppinsSmall1);
        c1.setFocusable(false);
        c1.setOpaque(false);
        c1.setIcon(checkboxIcon);
        c1.setSelectedIcon(checkboxIcon);
        c1.setForeground(Color.white);
        c1.setBounds(80,390,150,60);
        signupBgPanel.add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(poppinsSmall1);
        c2.setFocusable(false);
        c2.setOpaque(false);
        c2.setIcon(checkboxIcon);
        c2.setSelectedIcon(checkboxIcon);
        c2.setForeground(Color.white);
        c2.setBounds(270,390,200,60);
        signupBgPanel.add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(poppinsSmall1);
        c3.setFocusable(false);
        c3.setOpaque(false);
        c3.setIcon(checkboxIcon);
        c3.setSelectedIcon(checkboxIcon);
        c3.setForeground(Color.white);
        c3.setBounds(480,390,200,60);
        signupBgPanel.add(c3);

        c4 = new JCheckBox("Cheque Book");
        c4.setFont(poppinsSmall1);
        c4.setFocusable(false);
        c4.setOpaque(false);
        c4.setIcon(checkboxIcon);
        c4.setSelectedIcon(checkboxIcon);
        c4.setForeground(Color.white);
        c4.setBounds(80,470,150,60);
        signupBgPanel.add(c4);

        c5 = new JCheckBox("Auto Loans");
        c5.setFont(poppinsSmall1);
        c5.setFocusable(false);
        c5.setOpaque(false);
        c5.setIcon(checkboxIcon);
        c5.setSelectedIcon(checkboxIcon);
        c5.setForeground(Color.white);
        c5.setBounds(270,470,200,60);
        signupBgPanel.add(c5);

        c6 = new JCheckBox("Foreign Currency");
        c6.setFont(poppinsSmall1);
        c6.setFocusable(false);
        c6.setOpaque(false);
        c6.setIcon(checkboxIcon);
        c6.setSelectedIcon(checkboxIcon);
        c6.setForeground(Color.white);
        c6.setBounds(480,470,250,60);
        signupBgPanel.add(c6);

        c7 = new JCheckBox("<html>&nbsp;&nbsp;&nbsp;&nbsp;I hereby declare that the information provided above is true and correct to the best of my knowledge.<br>&nbsp;&nbsp;&nbsp;&nbsp;I agree to abide by the terms and conditions governing the account as set forth by the bank.</html>");
        c7.setFont(poppinsSmall22);
        c7.setFocusable(false);
        c7.setOpaque(false);
        c7.setForeground(Color.white);
        c7.setBounds(70, 540, 600, 60);
        signupBgPanel.add(c7);

        submit = new JButton("SUBMIT");
        submit.setBounds(350, 630, 150, 50);
        submit.setBackground(new Color(34, 130, 211));
        submit.setForeground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        submit.setFont(poppinsSmall1);
        submit.setBorder(border);
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(new Color(245, 217, 13));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                submit.setBackground(new Color(34, 130, 211));
            }
        });
        signupBgPanel.add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(190, 630, 150, 50);
        cancel.setBackground(new Color(34, 130, 211));
        cancel.setForeground(Color.white);
        cancel.setFont(poppinsSmall1);
        cancel.setBorder(border);
        cancel.setFocusable(false);
        cancel.addActionListener(this);
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cancel.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cancel.setBackground(new Color(34, 130, 211));
            }
        });
        signupBgPanel.add(cancel);




        //footer
        JLabel text = new JLabel("IZRAZ");
        text.setFont(poppinsSmall1);
        text.setForeground(Color.white);
        text.setBounds(340, 690, 500, 60);
        signupBgPanel.add(text);

        JLabel text1 = new JLabel("Bank");
        text1.setFont(poppinsSmall1);
        text1.setForeground(Color.white);
        text1.setBounds(340, 710, 500, 60);
        signupBgPanel.add(text1);

        //addition and scaling of the logo image
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image i22 = i11.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel label1 = new JLabel(i33);
        label1.setBounds(300, 710, 40, 40);
        signupBgPanel.add(label1);

        this.setContentPane(signupBgPanel);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==submit){
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM Card";
            }
            else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            else if (c4.isSelected()){
                facility = facility + " Cheque Book";
            }
            else if (c5.isSelected()){
                facility = facility + " Auto Loans";
            }
            else if (c6.isSelected()){
                facility = facility + " Foreign Currency";
            }

            try{
                DatabaseConnection connection = new DatabaseConnection();
                String query1 = "insert into signupthree values('"+formNumber+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                String query2 = "insert into login values('"+formNumber+"', '"+cardNumber+"', '"+pinNumber+"')";
                connection.s.executeUpdate(query1);
                connection.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Card Number : " + cardNumber + "\n Pin : " + pinNumber);
                setVisible(false);
                new Deposit(pinNumber).setVisible(false);
            }
            catch (Exception ae){
                System.out.println(ae);
            }

            setVisible(false);
            new Login().setVisible(true);
        }
        else if (e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
