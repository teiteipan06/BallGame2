import javax.swing.JPanel;
import java.awt.Graphics2D;

public class Racquet extends JPanel
{
    int x = 0;
    private static final int y = 570; // 新增三個球拍屬性的final變數,因為已經確定下來了不會再改
    private static final int WIDTH = 120;
    private static final int HEIGHT = 30;

    private Window window;

    public Racquet(Window w) { // 建構子
        this.window = w;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}