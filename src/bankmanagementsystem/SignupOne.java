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
import java.util.Random;


public class SignupOne extends JFrame implements ActionListener {

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

    long random;
    JTextField nameTextField, fatherNameTextField, emailTextField, phoneTextField, residentialTextField, cityTextField, stateTextField, postalCodeTextField;
    JButton next;
    JRadioButton male, female;
    JDateChooser dateChooser;

    SignupOne() {
        this.setTitle("Sign Up - Page 1");
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

        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formnum = new JLabel("REGISTRATION FORM # : " + random);
        formnum.setFont(poppinsMedium1);
        formnum.setForeground(Color.white);
        formnum.setBounds(110,40,700,60);
        signupBgPanel.add(formnum);

        JLabel personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(poppinsSmall);
        personalDetails.setForeground(Color.white);
        personalDetails.setBounds(250,90,700,60);
        signupBgPanel.add(personalDetails);

        JLabel name = new JLabel("Name : ");
        name.setFont(poppinsSmall1);
        name.setForeground(Color.white);
        name.setBounds(110,160,100,60);
        signupBgPanel.add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(320, 180, 325, 25);
        nameTextField.setBackground(new Color(34, 130, 211));
        nameTextField.setForeground(Color.white);
        nameTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(nameTextField);

        JLabel fathersName = new JLabel("Father's Name : ");
        fathersName.setFont(poppinsSmall1);
        fathersName.setForeground(Color.white);
        fathersName.setBounds(110,200,200,60);
        signupBgPanel.add(fathersName);

        fatherNameTextField = new JTextField();
        fatherNameTextField.setBounds(320, 220, 325, 25);
        fatherNameTextField.setBackground(new Color(34, 130, 211));
        fatherNameTextField.setForeground(Color.white);
        fatherNameTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(fatherNameTextField);

        JLabel dateofBirth = new JLabel("Date of Birth : ");
        dateofBirth.setFont(poppinsSmall1);
        dateofBirth.setForeground(Color.white);
        dateofBirth.setBounds(110,240,200,60);
        signupBgPanel.add(dateofBirth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(320, 260, 325,25);
        dateChooser.getDateEditor().getUiComponent().setBackground(new Color(34, 130, 211));
        dateChooser.getDateEditor().getUiComponent().setForeground(Color.white);
        dateChooser.getDateEditor().getUiComponent().setFont(new Font("Monospaced", Font.BOLD, 20));
        dateChooser.setFocusable(false);
        signupBgPanel.add(dateChooser);

        JLabel emailAddress = new JLabel("Email : ");
        emailAddress.setFont(poppinsSmall1);
        emailAddress.setForeground(Color.white);
        emailAddress.setBounds(110,280,200,60);
        signupBgPanel.add(emailAddress);

        emailTextField = new JTextField();
        emailTextField.setBounds(320, 300, 325, 25);
        emailTextField.setBackground(new Color(34, 130, 211));
        emailTextField.setForeground(Color.white);
        emailTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(emailTextField);

        JLabel phone = new JLabel("Phone Number : ");
        phone.setFont(poppinsSmall1);
        phone.setForeground(Color.white);
        phone.setBounds(110,320,200,60);
        signupBgPanel.add(phone);

        phoneTextField = new JTextField();
        phoneTextField.setBounds(320, 340, 325, 25);
        phoneTextField.setBackground(new Color(34, 130, 211));
        phoneTextField.setForeground(Color.white);
        phoneTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(phoneTextField);

        JLabel residentialAddress = new JLabel("Residential Address : ");
        residentialAddress.setFont(poppinsSmall1);
        residentialAddress.setForeground(Color.white);
        residentialAddress.setBounds(110,360,200,60);
        signupBgPanel.add(residentialAddress);

        residentialTextField = new JTextField();
        residentialTextField.setBounds(320, 380, 325, 25);
        residentialTextField.setBackground(new Color(34, 130, 211));
        residentialTextField.setForeground(Color.white);
        residentialTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(residentialTextField);

        JLabel city = new JLabel("City : ");
        city.setFont(poppinsSmall1);
        city.setForeground(Color.white);
        city.setBounds(110,400,200,60);
        signupBgPanel.add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(320, 420, 325, 25);
        cityTextField.setBackground(new Color(34, 130, 211));
        cityTextField.setForeground(Color.white);
        cityTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(cityTextField);

        JLabel state = new JLabel("State : ");
        state.setFont(poppinsSmall1);
        state.setForeground(Color.white);
        state.setBounds(110,440,200,60);
        signupBgPanel.add(state);

        stateTextField = new JTextField();
        stateTextField.setBounds(320, 460, 325, 25);
        stateTextField.setBackground(new Color(34, 130, 211));
        stateTextField.setForeground(Color.white);
        stateTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(stateTextField);

        JLabel postalCode = new JLabel("Postal Code : ");
        postalCode.setFont(poppinsSmall1);
        postalCode.setForeground(Color.white);
        postalCode.setBounds(110,480,200,60);
        signupBgPanel.add(postalCode);

        postalCodeTextField = new JTextField();
        postalCodeTextField.setBounds(320, 500, 325, 25);
        postalCodeTextField.setBackground(new Color(34, 130, 211));
        postalCodeTextField.setForeground(Color.white);
        postalCodeTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(postalCodeTextField);

        JLabel gender = new JLabel("Gender : ");
        gender.setFont(poppinsSmall1);
        gender.setForeground(Color.white);
        gender.setBounds(110,520,200,60);
        signupBgPanel.add(gender);

        male = new JRadioButton("Male");
        male.setBounds(320, 525, 100, 60);
        male.setOpaque(false);
        male.setForeground(Color.white);
        male.setFont(poppinsSmall1);
        male.setIcon(new CustomRadioButtonIcon(20));
        male.setFocusable(false);
        signupBgPanel.add(male);

        female = new JRadioButton("Female");
        female.setBounds(460, 540, 100, 30);
        female.setOpaque(false);
        female.setForeground(Color.white);
        female.setFont(poppinsSmall1);
        female.setIcon(new CustomRadioButtonIcon(20));
        female.setFocusable(false);
        signupBgPanel.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        next = new JButton("NEXT");
        next.setBounds(280, 600, 150, 50);
        next.setBackground(new Color(34, 130, 211));
        next.setForeground(Color.white);
        Border border = BorderFactory.createLineBorder(Color.WHITE);
        next.setFont(poppinsSmall1);
        next.setBorder(border);
        next.setFocusable(false);
        next.addActionListener(this);
        next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                next.setBackground(new Color(27, 83, 140));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                next.setBackground(new Color(34, 130, 211));
            }
        });
        signupBgPanel.add(next);

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
        String formNumber = "" + random;
        String name = nameTextField.getText();
        String fatherName = fatherNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if (male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String phone = phoneTextField.getText();
        String address = residentialTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String postalCode = postalCodeTextField.getText();

        try{
            if (name.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if (!name.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (fatherName.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Father Name is Required");
            }else if (!fatherName.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (dob.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Date of Birth is Required");
            }
            else if (gender == null){
                JOptionPane.showMessageDialog(null, "Please select Gender");
            }
            else if (email.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Email is Required");
            }else if (!email.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (phone.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Phone Number is Required");
            }else if (!phone.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Phone Number must contain only digits");
            }
            else if (address.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Residential Address is Required");
            }else if (!address.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (city.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "City is Required");
            }else if (!city.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (state.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "State is Required");
            }else if (!state.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (postalCode.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Postal Code is Required");
            }else if (!postalCode.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else{
                DatabaseConnection c = new DatabaseConnection();
                String query = "insert into signup values('"+formNumber+"', '"+name+"', '"+fatherName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+address+"', '"+city+"', '"+state+"', '"+postalCode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formNumber).setVisible(true);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
