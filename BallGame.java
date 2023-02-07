import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BallGame extends JFrame // 繼承父類Jframe
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
}

