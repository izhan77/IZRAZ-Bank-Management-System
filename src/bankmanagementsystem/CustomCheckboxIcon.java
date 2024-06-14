package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;

class CustomCheckboxIcon implements Icon {

    private final int size;

    public CustomCheckboxIcon(int size) {
        this.size = size;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        AbstractButton button = (AbstractButton) c;
        ButtonModel model = button.getModel();
        Graphics2D g2 = (Graphics2D) g.create();

        g2.setColor(button.isEnabled() ? button.getForeground() : Color.GRAY);
        g2.setStroke(new BasicStroke(2));
        g2.drawRect(x, y, size, size);

        if (model.isSelected()) {
            g2.setColor(button.isEnabled() ? button.getForeground() : Color.GRAY);
            g2.fillRect(x + 3, y + 3, size - 6, size - 6);

            g2.setColor(Color.WHITE);
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(x + 5, y + (size / 2), x + (size / 3), y + size - 5);
            g2.drawLine(x + (size / 3), y + size - 5, x + size - 5, y + 5);
        }

        g2.dispose();
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }
}
