import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.event.KeyEvent;


public class BallGame extends JFrame // 繼承父類Jframe
public class BallGame extends JFrame implements KeyListener
{
	static int score;
	
	public BallGame() { // 建構子
		this.setTitle("不讓球掉下來!!"); // 視窗的標題
		this.setSize(600, 600); // 視窗的寬和高
		this.setVisible(true); // 顯示視窗
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 視窗的關閉按鈕、使用System exit方法退出應用程式
		this.setLocationRelativeTo(null); //讓視窗置中
	}

  Ball ball = new Ball(this); // 這裡建立一個ball物件,this作為引數讓Ball類可以獲取Window的成員資訊

	public void paint(Graphics g) { // 覆蓋從JFrame或者JPanel類別繼承的方法，這個方法會被系統自動呼叫。

		super.paint(g);  //呼叫從父類JFrame繼承的paint方法，這樣才不會留存之前的螢幕內容

		Graphics2D g2d = (Graphics2D) g; // 進行物件轉型,因為Graphic2D的方法比較好也比較豐富,它也繼承Graphics這個類別

		// 在視窗上設計分數
		g2d.setColor(Color.GRAY); //畫筆顏色
		g2d.setFont(new Font("Verdana", Font.BOLD, 50)); //字型
		g2d.drawString(String.valueOf(score), 20, 120);

    ball.paint(g2d); // 呼叫ball類中的paint方法
	}

	public static void main(String[] args)
	{
		BallGame ballgame = new BallGame(); // 建立window物件
	}

  private void move() // 這裡是move方法用來呼叫Ball類中的moveBall
  {
    ball.moveBall();
  }

	Racquet racquet = new Racquet(this);  // 這裡建立一個racquet物件,this作為引數讓Racquet類可以獲取Window的成員資訊
	racquet.paint(g2d);

	this.addKeyListener(this); // 增加鍵盤監聽器

	// KeyEvent 當以下三種方法的任何一種方法發生時，KeyListener鍵盤監聽器就會啟動KeyEvent

public void keyPressed(KeyEvent e) { // 按下鍵盤的動作
	racquet.KeyPressed(e);
}

public void keyReleased(KeyEvent e) { // 放開鍵盤的動作
	racquet.KeyReleased(e);
}

public void keyTyped(KeyEvent e) { // 按下鍵盤與放開鍵盤之間的動作
	// 就算不會使用到這個方法，還是要定義
}

int xa = 0; // 移動單位

public void KeyPressed(KeyEvent e) {  // 鍵盤按下時，移動
        if (e.getKeyCode() == KeyEvent.VK_LEFT) // 往左移動
            xa = -2;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) // 往右移動
            xa = 2;
}

public void KeyReleased(KeyEvent e) { // 鍵盤放開時，不移動
        xa = 0;
}

public void moveRacquet() {
    if (x + xa < window.getWidth() - 120 && x + xa > 0) // 移動座標 小於右邊邊界 且 大於左邊邊界
        x += xa;
}

private void move() 
{
    ball.moveBall();
    racquet.moveRacquet();
}

}

