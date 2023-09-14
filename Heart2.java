import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Heart2 extends JPanel {
    private int x = 0;
    private int y = 0;
     private int deltaY = 2;
    public Heart2() {
        Timer timer = new Timer(10, e -> {
            updatePosition();
            repaint(); });
        timer.start();}
    private void updatePosition() {
        y += deltaY;
        if (y <= 0 || y >= getHeight() - 150) {
            deltaY *= -1;} } 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       setBackground(Color.black);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.pink);

        AffineTransform transform = new AffineTransform();
        transform.translate(x, y);
        g2d.transform(transform);
        int[] xPoints = {220,73, 380};
        int[] yPoints = {400, 250, 250};
        g2d.fillArc(60, 100, 200, 200, -180, 500);
        g2d.fillArc(190, 100, 200, 200, -200, -500);
        
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.black);
        Font font = new Font("Arial", Font.BOLD, 48);
        g2d.setFont(font);
        g2d.drawString("JAVA", 160, 250);

        g2d.dispose();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Heart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 900);
        frame.setLocationRelativeTo(null);
        frame.add(new Heart2());
        frame.setVisible(true);
    }
}