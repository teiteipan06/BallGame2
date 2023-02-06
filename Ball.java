import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;

public class Ball extends JPanel 
{
    private static final int ballsize = 60;
    int x = 0; // 小球的預設位置
    int y = 0;
    int incx = 1; // 這是小球要移動的單位
    int incy = 1;
    private Window window;

    public Ball(Window w) { // 建構子
        this.window = w;
    }

    void moveBall() // 這個方法就是不斷更新小球的位置
    {
        if (x + incx > window.getWidth() - ballsize) // 如果小球移動後的位置超出視窗範圍的話,移動方向就是-1; 再扣掉球的大小
            incx = -1;
        if (x + incx < 0) // 同理
            incx = 1;
        if (y + incy > window.getHeight() - ballsize)
            incy = -1;
        if (y + incy < 0)
            incy = 1;

        x += incx;
        y += incy;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.darkGray); //設定顏色
        g.fillOval(x, y, ballsize, ballsize); //(x軸, y軸, 球的寬度, 球的高度)
    }
}