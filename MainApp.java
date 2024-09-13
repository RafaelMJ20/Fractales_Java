import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class MainApp extends JPanel {
    double sin60 = Math.sin(Math.PI / 3.0);  // Para los ángulos del triángulo equilátero
    int nivel_de_recursividad = 6;  // Nivel de detalle

    public MainApp() {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Definir las coordenadas del triángulo equilátero
        double xp1 = 300, yp1 = 50;
        double xp2 = 50, yp2 = 500;
        double xp3 = 550, yp3 = 500;

        // Dibujar el copo en cada lado del triángulo
        paintRecursivo(g, nivel_de_recursividad, xp1, yp1, xp2, yp2);
        paintRecursivo(g, nivel_de_recursividad, xp2, yp2, xp3, yp3);
        paintRecursivo(g, nivel_de_recursividad, xp3, yp3, xp1, yp1);
    }

    private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22) {
        double dx = (xp22 - xp12) / 3.0;
        double dy = (yp22 - yp12) / 3.0;
        double xx = xp12 + 3 * dx / 2.0 - dy * sin60;
        double yy = yp12 + 3 * dy / 2.0 + dx * sin60;
        if (i <= 0) {
            g.drawLine((int) xp12, (int) yp12, (int) xp22, (int) yp22);
        } else {
            paintRecursivo(g, i - 1, xp12, yp12, xp12 + dx, yp12 + dy);
            paintRecursivo(g, i - 1, xp12 + dx, yp12 + dy, xx, yy);
            paintRecursivo(g, i - 1, xx, yy, xp22 - dx, yp22 - dy);
            paintRecursivo(g, i - 1, xp22 - dx, yp22 - dy, xp22, yp22);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        MainApp panel = new MainApp();
        frame.add(panel);
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
