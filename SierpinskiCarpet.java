import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class SierpinskiCarpet extends JPanel {
    int nivel_de_recursividad = 4;  // Profundidad de la recursión

    public SierpinskiCarpet() {}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar el tapete inicial (cuadrado completo)
        int size = Math.min(getWidth(), getHeight());  // Asegura que el cuadrado inicial encaje en la ventana
        drawCarpet(g, nivel_de_recursividad, 0, 0, size);
    }

    private void drawCarpet(Graphics g, int level, int x, int y, int size) {
        if (level == 0) {
            // Si no queda más nivel de recursividad, dibujar el cuadrado
            g.fillRect(x, y, size, size);
        } else {
            int newSize = size / 3;
            // Dibujar los 8 subcuadrados (omitir el cuadrado central)
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // Omitir el cuadrado central
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    // Recursión en los subcuadrados
                    drawCarpet(g, level - 1, x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SierpinskiCarpet panel = new SierpinskiCarpet();
        frame.add(panel);
        frame.setSize(600, 600);  // Tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
