package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class BalanceInquiryBgPanel extends JPanel {
    private Image backgroundImage;

    public BalanceInquiryBgPanel(String fileName) {
        try {
            backgroundImage = new ImageIcon(ClassLoader.getSystemResource(fileName)).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
