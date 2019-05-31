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
	
	private void initial() {
		act.setPlan();
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Mat[i][j]=new JButton();
				Mat[i][j].setText("");
				Mat[i][j]=initB(i,j);
			}
		}
	}
	private void reset() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Mat[i][j].setBackground(new JButton().getBackground());
				Mat[i][j].setText("");
				Mat[i][j].setIcon(null);
				Mat[i][j].setForeground(new JButton().getForeground());
				//Mat[i][j].setFont(new JButton().getFont());
			}
		}
		act.setPlan();
	}
	public JButton initB(int i, int j) {
		JButton tmp;
		tmp=new JButton();
		tmp.setText("");
		tmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(act.checkgameover()==0) {
				Mat[i][j].setBackground(Color.WHITE);
				act.affnei(i, j, 0);
				btntxt();
				if(act.checkgameover()==1) JOptionPane.showMessageDialog(null, "You Win!!!");
				if(act.checkgameover()==-1) JOptionPane.showMessageDialog(null, "You Lost, try again");
				}
			}
		});
		return tmp;
	}
	public void btntxt() {
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Mat[i][j].setFont(new Font("Arial", Font.PLAIN, 80));
				if (act.getm(i, j).getc()==0) {
					Mat[i][j].setBackground(Color.WHITE);
					if(act.getm(i,j).getv()<0) {
						Mat[i][j].setBackground(Color.RED);
						Mat[i][j].setText("*");
					}
					else if(act.getm(i,j).getv()==0) Mat[i][j].setText("");
					else {
						Mat[i][j].setBackground(Color.WHITE);
						Mat[i][j].setText(Integer.toString(act.getm(i,j).getv()));
						if (act.getm(i,j).getv()==1) Mat[i][j].setForeground(Color.BLUE);
						if (act.getm(i,j).getv()==2) Mat[i][j].setForeground(Color.GREEN);
						if (act.getm(i,j).getv()==3) Mat[i][j].setForeground(Color.RED);
						if (act.getm(i,j).getv()==4) Mat[i][j].setForeground(Color.MAGENTA);
						if (act.getm(i,j).getv()==5) Mat[i][j].setForeground(Color.ORANGE);
						if (act.getm(i,j).getv()==6) Mat[i][j].setForeground(Color.CYAN);
						if (act.getm(i,j).getv()==7) Mat[i][j].setForeground(Color.YELLOW);
						if (act.getm(i,j).getv()==8) Mat[i][j].setForeground(Color.DARK_GRAY);
					}
				}
			}
		}
	}
	public Dem getDem() {return act;}
}