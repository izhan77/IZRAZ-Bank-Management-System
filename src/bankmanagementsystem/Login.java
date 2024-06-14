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

public class Login extends JFrame implements ActionListener {

    JButton login, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;

    //used custom fonts from Google Fonts to add Poppins as default font throughout the program
    Font poppins;
    Font poppinsLarge;
    Font poppinsMedium;
    Font poppinsSmall;
    Font poppinsSmall1;
    Font poppinsSmall2;

    Login() {
        this.setTitle("Login Page");
        this.setSize(800, 680);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(204, 43, 210));

        LoginBgPanel loginBgPanel = new LoginBgPanel("icons/bg2.png");
        loginBgPanel.setLayout(null);

        //addition and scaling of the logo image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo2.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(230, 80, 150, 150);
        loginBgPanel.add(label);

        // loading the poppins font
        try (InputStream is = ClassLoader.getSystemResourceAsStream("poppins/Poppins-SemiBold.ttf")) {
            if (is != null) {
                poppins = Font.createFont(Font.TRUETYPE_FONT, is);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(poppins);//registering poppins font
                poppinsLarge = poppins.deriveFont(70f);
                poppinsMedium = poppins.deriveFont(36f);
                poppinsSmall = poppins.deriveFont(20f);
                poppinsSmall1 = poppins.deriveFont(15f);
                poppinsSmall2 = poppins.deriveFont(12f);
            } else {
                System.err.println("Font not found");
            }
        } catch (IOException | FontFormatException e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("IZRAZ");
        if (poppinsLarge != null) {
            text.setFont(poppinsLarge);
        }
        else {
            text.setFont(new Font("Serif", Font.BOLD, 50)); // Fallback font
        }
        text.setForeground(Color.white);
        text.setBounds(380, 96, 500, 60);
        loginBgPanel.add(text);

        JLabel text1 = new JLabel("Bank");
        if (poppinsLarge != null) {
            text1.setFont(poppinsLarge);
        }
        else {
            text1.setFont(new Font("Serif", Font.BOLD, 48)); // Fallback font
        }
        text1.setForeground(Color.white);
        text1.setBounds(380, 160, 500, 60);
        loginBgPanel.add(text1);

        JLabel text2 = new JLabel("Your trusted banking partner");
        if (poppinsSmall != null) {
            text2.setFont(poppinsSmall);
        }
        else {
            text2.setFont(new Font("Serif", Font.BOLD, 48)); // Fallback font
        }
        text2.setForeground(Color.white);
        text2.setBounds(255, 220, 500, 60);
        loginBgPanel.add(text2);

        JLabel cardnum = new JLabel("Card Number :");
        if (poppinsMedium != null) {
            cardnum.setFont(poppinsSmall);
        } else {
            cardnum.setFont(new Font("Serif", Font.BOLD, 36)); // Fallback font
        }
        cardnum.setForeground(Color.white);
        cardnum.setBounds(200, 300, 200, 50);
        loginBgPanel.add(cardnum);

        cardTextField = new JTextField();
        cardTextField.setBounds(370, 310, 200, 30);
        cardTextField.setBackground(new Color(34, 130, 211));
        cardTextField.setForeground(Color.white);
        cardTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        loginBgPanel.add(cardTextField);

        JLabel pin = new JLabel("PIN :");
        if (poppinsSmall != null) {
            pin.setFont(poppinsSmall);
        } else {
            pin.setFont(new Font("Serif", Font.BOLD, 24)); // Fallback font
        }
        pin.setForeground(Color.white);
        pin.setBounds(200, 350, 200, 50);
        loginBgPanel.add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(370, 360, 200, 30);
        pinTextField.setBackground(new Color(34, 130, 211));
        pinTextField.setForeground(Color.white);
        pinTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        loginBgPanel.add(pinTextField);

        login = new JButton("LOG IN");
        login.setBounds(415, 410, 100, 50);
        login.setBackground(new Color(34, 130, 211));
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        login.setForeground(Color.white);
        login.setBorder(border);
        login.setFont(poppinsSmall1);
        login.setFocusable(false);
        login.addActionListener(this);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                login.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                login.setBackground(new Color(34, 130, 211));
            }
        });
        loginBgPanel.add(login);

        JLabel label2 = new JLabel("New Member? Sign up to Create your Account!");
        label2.setBounds(255,520,600,15);
        label2.setFont(poppinsSmall2);
        label2.setForeground(Color.white);
        loginBgPanel.add(label2);

        signup = new JButton("SIGN UP");
        signup.setBounds(350, 560, 100, 50);
        signup.setBackground(new Color(34, 130, 211));
        signup.setForeground(Color.white);
        signup.setBorder(border);
        signup.setFont(poppinsSmall1);
        signup.setFocusable(false);
        signup.addActionListener(this);
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signup.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signup.setBackground(new Color(34, 130, 211));
            }
        });
        loginBgPanel.add(signup);


        this.setContentPane(loginBgPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login){
            DatabaseConnection connection = new DatabaseConnection();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNumber+"' and pinNumber = '"+pinNumber+"'";
            try{
                ResultSet rs = connection.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN !");
                }
            }
            catch (Exception ae){
                System.out.println(ae);
            }
        }
        else if (e.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }


}
