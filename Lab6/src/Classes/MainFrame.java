package Classes;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    ConfigurationPanel configurationPanel;
    ControlPanel controlPanel;
    Canvas canvas;


    public MainFrame() {
        super("Shape Drawer");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new Canvas(this);
        controlPanel = new ControlPanel(this);
        configurationPanel = new ConfigurationPanel(this);

        add(canvas, CENTER);
        add(configurationPanel, NORTH);
        add(controlPanel, SOUTH);

        pack();
    }

}
