import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class DemG extends JFrame{
	private static final long serialVersionUID = 1L;
	private Container pane;
	private JButton [][] Mat;
	private Dem act;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem About;
	private JMenuItem quit;
	private JMenuItem NewGame ;
	public DemG() {
		super("Demineur");
		act=new Dem();
		Mat= new JButton[10][10];
		initial();
		pane = getContentPane();
		pane.setLayout(new GridLayout(10,10));
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				add(Mat[i][j]);
			}
		}
		setSize(1000,1000);
		setVisible(true);
		InitMenu();
	}
	private void InitMenu() {
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		NewGame = new JMenuItem("NewGame");
		NewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		About = new JMenuItem("About");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(null, "Demineur Made By:\nFikri Yassine\nEllouke Mohammed\nEl Mallali Soufiane.");
			}
		});
		menu.add(NewGame);
		menu.add(quit);
		menu.add(About);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}	
}