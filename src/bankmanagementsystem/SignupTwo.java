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


public class SignupTwo extends JFrame implements ActionListener{

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

    JTextField nationalityTextField, occupationTextField, idNumberTextField, issuingAuthorityTextField, dateOfIssueTextField, expiryDateTextField;
    JButton next;
    JRadioButton yes, no;
    JComboBox<String> idTypeComboBox, accountTypeComboBox, purposeOfAccountComboBox, incomeComboBox;
    String formNumber;

    SignupTwo(String formNumber) {
        this.formNumber = formNumber;
        this.setTitle("Sign Up - Page 2");
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

//        Random ran = new Random();
//        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel additionalDetails = new JLabel("Additional Details");
        additionalDetails.setFont(poppinsSmall);
        additionalDetails.setForeground(Color.white);
        additionalDetails.setBounds(250,40,700,60);
        signupBgPanel.add(additionalDetails);

        JLabel nationality = new JLabel("Nationality : ");
        nationality.setFont(poppinsSmall1);
        nationality.setForeground(Color.white);
        nationality.setBounds(110,130,100,60);
        signupBgPanel.add(nationality);

        nationalityTextField = new JTextField();
        nationalityTextField.setBounds(320, 150, 325, 25);
        nationalityTextField.setBackground(new Color(34, 130, 211));
        nationalityTextField.setForeground(Color.white);
        nationalityTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(nationalityTextField);

        JLabel occupation = new JLabel("Occupation : ");
        occupation.setFont(poppinsSmall1);
        occupation.setForeground(Color.white);
        occupation.setBounds(110,170,200,60);
        signupBgPanel.add(occupation);

        occupationTextField = new JTextField();
        occupationTextField.setBounds(320, 190, 325, 25);
        occupationTextField.setBackground(new Color(34, 130, 211));
        occupationTextField.setForeground(Color.white);
        occupationTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(occupationTextField);

        JLabel idType = new JLabel("Type of ID provided : ");
        idType.setFont(poppinsSmall1);
        idType.setForeground(Color.white);
        idType.setBounds(110, 210, 200, 60);
        signupBgPanel.add(idType);

        String[] idTypes = { "","Passport", "Driver’s License", "National ID Card", "Other" };
        idTypeComboBox = new JComboBox<>(idTypes);
        idTypeComboBox.setBounds(320, 230, 325, 25);
        idTypeComboBox.setBackground(new Color(34, 130, 211));
        idTypeComboBox.setForeground(Color.white);
        idTypeComboBox.setFont(new Font("Monospaced", Font.BOLD, 16));
        signupBgPanel.add(idTypeComboBox);

        JLabel idNumber = new JLabel("ID Number : ");
        idNumber.setFont(poppinsSmall1);
        idNumber.setForeground(Color.white);
        idNumber.setBounds(110, 250, 200, 60);
        signupBgPanel.add(idNumber);

        idNumberTextField = new JTextField();
        idNumberTextField.setBounds(320, 270, 325, 25);
        idNumberTextField.setBackground(new Color(34, 130, 211));
        idNumberTextField.setForeground(Color.white);
        idNumberTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(idNumberTextField);

        JLabel issuingAuthority = new JLabel("Issuing Authority : ");
        issuingAuthority.setFont(poppinsSmall1);
        issuingAuthority.setForeground(Color.white);
        issuingAuthority.setBounds(110, 290, 200, 60);
        signupBgPanel.add(issuingAuthority);

        issuingAuthorityTextField = new JTextField();
        issuingAuthorityTextField.setBounds(320, 310, 325, 25);
        issuingAuthorityTextField.setBackground(new Color(34, 130, 211));
        issuingAuthorityTextField.setForeground(Color.white);
        issuingAuthorityTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(issuingAuthorityTextField);

        JLabel dateOfIssue = new JLabel("Date of Issue : ");
        dateOfIssue.setFont(poppinsSmall1);
        dateOfIssue.setForeground(Color.white);
        dateOfIssue.setBounds(110, 330, 200, 60);
        signupBgPanel.add(dateOfIssue);

        dateOfIssueTextField = new JTextField();
        dateOfIssueTextField.setBounds(320, 350, 325, 25);
        dateOfIssueTextField.setBackground(new Color(34, 130, 211));
        dateOfIssueTextField.setForeground(Color.white);
        dateOfIssueTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(dateOfIssueTextField);

        JLabel expiryDate = new JLabel("Expiry Date : ");
        expiryDate.setFont(poppinsSmall1);
        expiryDate.setForeground(Color.white);
        expiryDate.setBounds(110, 370, 200, 60);
        signupBgPanel.add(expiryDate);

        expiryDateTextField = new JTextField();
        expiryDateTextField.setBounds(320, 390, 325, 25);
        expiryDateTextField.setBackground(new Color(34, 130, 211));
        expiryDateTextField.setForeground(Color.white);
        expiryDateTextField.setFont(new Font("Monospaced", Font.BOLD, 20));
        signupBgPanel.add(expiryDateTextField);

        JLabel accountTypeLabel = new JLabel("Type of Account : ");
        accountTypeLabel.setFont(poppinsSmall1);
        accountTypeLabel.setForeground(Color.white);
        accountTypeLabel.setBounds(110, 415, 200, 60);
        signupBgPanel.add(accountTypeLabel);

        String[] accountTypes = {"", "Savings Account", "Checking Account", "Fixed Deposit Account"};
        accountTypeComboBox = new JComboBox<>(accountTypes);
        accountTypeComboBox.setBounds(320, 430, 325, 25);
        accountTypeComboBox.setBackground(new Color(34, 130, 211));
        accountTypeComboBox.setForeground(Color.white);
        accountTypeComboBox.setFont(new Font("Monospaced", Font.BOLD, 16));
        signupBgPanel.add(accountTypeComboBox);

        JLabel purposeOfAccount = new JLabel("Purpose of Account :");
        purposeOfAccount.setFont(poppinsSmall1);
        purposeOfAccount.setForeground(Color.white);
        purposeOfAccount.setBounds(110, 460, 200, 60);
        signupBgPanel.add(purposeOfAccount);

        String[] purposeOfAccountOptions = {"", "Personal Savings", "Salary Deposits", "Business Transactions", "Investments", "Other"};
        purposeOfAccountComboBox = new JComboBox<>(purposeOfAccountOptions);
        purposeOfAccountComboBox.setBounds(320, 475, 325, 25);
        purposeOfAccountComboBox.setBackground(new Color(34, 130, 211));
        purposeOfAccountComboBox.setForeground(Color.white);
        purposeOfAccountComboBox.setFont(new Font("Monospaced", Font.BOLD, 16));
        signupBgPanel.add(purposeOfAccountComboBox);

        JLabel incomeLabel = new JLabel("Income :");
        incomeLabel.setFont(poppinsSmall1);
        incomeLabel.setForeground(Color.white);
        incomeLabel.setBounds(110, 500, 200, 60);
        signupBgPanel.add(incomeLabel);

        String[] incomeOptions = {"", "Less than $10,000", "$10,000 - $30,000", "$30,000 - $50,000", "$50,000 - $100,000", "More than $100,000"};
        incomeComboBox = new JComboBox<>(incomeOptions);
        incomeComboBox.setBounds(320, 520, 325, 25);
        incomeComboBox.setBackground(new Color(34, 130, 211));
        incomeComboBox.setForeground(Color.white);
        incomeComboBox.setFont(new Font("Monospaced", Font.BOLD, 16));
        signupBgPanel.add(incomeComboBox);

        JLabel seniorCitizen = new JLabel("Senior Citizen : ");
        seniorCitizen.setFont(poppinsSmall1);
        seniorCitizen.setForeground(Color.white);
        seniorCitizen.setBounds(110,550,200,60);
        signupBgPanel.add(seniorCitizen);

        yes = new JRadioButton("Yes");
        yes.setBounds(320, 550, 100, 60);
        yes.setOpaque(false);
        yes.setForeground(Color.white);
        yes.setFont(poppinsSmall1);
        yes.setIcon(new CustomRadioButtonIcon(20));
        yes.setFocusable(false);
        signupBgPanel.add(yes);

        no = new JRadioButton("No");
        no.setBounds(460, 565, 100, 30);
        no.setOpaque(false);
        no.setForeground(Color.white);
        no.setFont(poppinsSmall1);
        no.setIcon(new CustomRadioButtonIcon(20));
        no.setFocusable(false);
        signupBgPanel.add(no);

        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yes);
        seniorCitizenGroup.add(no);

        next = new JButton("NEXT");
        next.setBounds(280, 620, 150, 50);
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
        String nationality = nationalityTextField.getText();
        String occupation = occupationTextField.getText();
        String idType = (String) idTypeComboBox.getSelectedItem();
        String idNumber = idNumberTextField.getText();
        String issuingAuthority = issuingAuthorityTextField.getText();
        String dateofIssue = dateOfIssueTextField.getText();
        String expiryDate = expiryDateTextField.getText();
        String accountType = (String) accountTypeComboBox.getSelectedItem();
        String purposeofAccount = (String) purposeOfAccountComboBox.getSelectedItem();
        String income = (String) incomeComboBox.getSelectedItem();
        String seniorCitizen = null;
        if (yes.isSelected()){
            seniorCitizen = "Yes";
        }
        else if(no.isSelected()){
            seniorCitizen = "No";
        }

        try{
            if (nationality.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Nationality is Required");
            }else if (!nationality.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (occupation.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            }else if (!occupation.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (idType.equals("")){
                JOptionPane.showMessageDialog(null, "ID Type is Required");
            }
            else if (idNumber.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "ID Number is Required");
            }else if (!idNumber.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (issuingAuthority.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Issuing Authority is Required");
            }else if (!issuingAuthority.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (dateofIssue.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Date of Issue is Required");
            }else if (!dateofIssue.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (expiryDate.trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Expiry Date is Required");
            }else if (!expiryDate.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(null, "Name must contain only alphabetic characters");
            }
            else if (accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select Account Type");
            }
            else if (purposeofAccount.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select Purpose of Account");
            }
            else if (income.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select Income");
            }
            else if (seniorCitizen == null){
                JOptionPane.showMessageDialog(null, "Senior Citizen is Required");
            }
            else{
                DatabaseConnection c = new DatabaseConnection();
                String query = "insert into signuptwo values('"+formNumber+"', '"+nationality+"', '"+occupation+"', '"+idType+"', '"+idNumber+"', '"+issuingAuthority+"', '"+dateofIssue+"', '"+expiryDate+"', '"+accountType+"', '"+purposeofAccount+"', '"+income+"', '"+seniorCitizen+"')";
                c.s.executeUpdate(query);

                //Signup3 object
                setVisible(false);
                new SignupThree(formNumber).setVisible(true);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
