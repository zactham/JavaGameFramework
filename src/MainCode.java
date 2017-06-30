import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainCode extends JPanel implements KeyListener
{

	private int score = 0;
	int counter = 1;

	boolean end;

	boolean scored = false;

	int round = 0;

	private boolean soundPlaying = true;

	public boolean correct = false;


	public MyTimer timer;


	public JFrame restart;
	public JFrame gameOver;
	public JFrame start;



	// Constructor
	public MainCode()
	{
		setFocusable(true);
		// Register for mouse events on the panel
		addKeyListener(this);

		counter = 1;
		scored = false;

		round = 0;

		soundPlaying = true;

		correct = false;

		boolean end;
	}



	public void init() throws InterruptedException
	{
		// launch game
		JFrame frame = new JFrame("Sample Frame");

		frame.add(this);

		frame.setTitle("Game Title");


		JOptionPane.showMessageDialog(start, "Game Instructions");


		//Sets the speed of the game for each mode
		if (TitleScreen.easy == true)
		{

		}

		if (TitleScreen.med == true)
		{

		}

		if (TitleScreen.hard == true)
		{

		}

		try

		{
			playMusicMain();
		}

		catch (Exception err)
		{
			//System.out.println("2. " + err);
		}

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		round = 0;
		centerWindow();
		frame.setSize(400, 400);
		setColors();

		// runs the mainLoop
		ActionListener timerAction = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				MainLoop();

			}

		};

		// Frame rate, updates the frame every 15ms --- 60fps
		Timer timer = new Timer(15, timerAction);
		timer.setRepeats(true);
		timer.start();


	}

	public void MainLoop() // throws InterruptedException
	{

	}

	public class AL implements ActionListener
	{
		public final void actionPerformed(ActionEvent e)
		{

			if (soundPlaying)
			{
				Sound.audioClip.stop();
				soundPlaying = false;
			}
			else
			{
				Sound.audioClip.start();
				soundPlaying = true;
			}
		}
	}

	public void playInGameMusic() throws InterruptedException

	{
		Sound.play("IngameMusic.wav");

	}

	public void playMusicMain() throws InterruptedException

	{
		playInGameMusic();
	}

	public void playSoundEffect() throws InterruptedException

	{
		//Sound.play("SMACK Sound Effect.wav");
	}





	// Centers the window
	public void centerWindow()
	{
		// gets top level window
		Window window;
		Container c = getParent();
		while (c.getParent() != null)
			c = c.getParent();

		// center window
		if (c instanceof Window)// if it is the top window...
		{
			// centers it
			window = (Window) c;
			window.pack();
			window.setLocationRelativeTo(null);
		}
	}

	public void setColors()
	{

	}



	public void gameEnding()
	{
		//When the game ends
		if (end)
		{
			if (soundPlaying)
			{
				Sound.audioClip.stop();
				soundPlaying = false;
			}
			else
			{
				Sound.audioClip.start();
				soundPlaying = true;
			}

			//Game Over Message
			JOptionPane.showMessageDialog(gameOver,
					"Click the X and then hit F11 to RESTART or Click the X in the top right to QUIT\n Your Percentage:\t " + score + "%");
		}
	}


	public void displayScore(Graphics page)
	{
		//Displays the Score
		page.setColor(Color.black);
		page.setFont(new Font("Comic Sans MS", Font.PLAIN, 50));
		page.drawString("SCORE: ", 75, 350);
		page.drawString(Integer.toString(score), 275, 350);
	}

	@Override
	protected void paintComponent(Graphics page)
	{
		displayScore(page);
	}

	public int getScore()
	{
		return score;
	}




	public void keyPressed(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
		int c = arg0.getKeyCode();

		//Pressing the keys
		if (c == KeyEvent.VK_NUMPAD1)
		{

		}

		if (c == KeyEvent.VK_NUMPAD2) 
		{

		}

		if (c == KeyEvent.VK_NUMPAD3)
		{

		}

		//When S is pressed the music stops
		if (c == KeyEvent.VK_S) {
			if (soundPlaying)
			{
				Sound.audioClip.stop();
				soundPlaying = false;
			}
			else
			{
				Sound.audioClip.start();
				soundPlaying = true;
			}
		}
	}



	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void update(Graphics g) 
	{
		paint(g);
	}
}

