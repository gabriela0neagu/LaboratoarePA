package Classes;

import javax.swing.*;
import java.awt.*;

public class ConfigurationPanel extends JPanel {
    MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField, strokeField;
    JComboBox colorCombo;
    private String[] colorList = {"Black", "Random"};

    ConfigurationPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(3);

        JLabel colorsLabel = new JLabel("Color:");
        colorCombo = new JComboBox(colorList);


        JLabel strokeLabel = new JLabel("Stroke:");
        strokeField = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
        strokeField.setValue(5);

        add(sidesLabel);
        add(sidesField);
        add(colorsLabel);
        add(colorCombo);
        add(strokeLabel);
        add(strokeField);
    }
}
