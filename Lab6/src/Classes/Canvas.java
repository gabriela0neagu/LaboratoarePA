package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import static java.lang.Math.floorDiv;
import static java.lang.Math.random;

public class Canvas extends JPanel {
    MainFrame frame;

    BufferedImage image;
    Graphics2D graphics;

    public Canvas(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    public void createOffscreenImage() {
        image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    private void init() {
        setPreferredSize(new Dimension(800, 600));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void drawShape(int x, int y) {
        Color color;
        Random random = new Random();
        int radius = random.nextInt(200);
        int sides = (int) frame.configurationPanel.sidesField.getValue();
        if ("Black".equals((String) frame.configurationPanel.colorCombo.getSelectedItem())) {
            color = new Color(0f, 0f, 0f, 0.2f);
            graphics.setColor(color);
        } else {
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            color = new Color(r, g, b, 0.2f);
            graphics.setColor(color);
        }
        var polygon = new RegularPolygon(x, y, radius, sides);
        graphics.fill(polygon);

        Stroke basicStroke = new BasicStroke(((Integer) frame.configurationPanel.strokeField.getValue()) / 1.0f);
        graphics.setStroke(basicStroke);
        graphics.setColor(new Color(color.getRGB(), false));
        graphics.drawPolygon(polygon);
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}



