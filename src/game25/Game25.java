package game25;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Game25 extends JFrame{
	JButton[] btn=new JButton[25];
	JTextField tf=new JTextField(10);
	JButton reset=new JButton("reset");
	JPanel pnl=new JPanel(new GridLayout(5,5));
	JPanel pnlButtom=new JPanel();
	int playNumber=1;
	Long startTime,endTime;

	public Game25() {
		setTitle("1~25 Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,430);
		Container c=getContentPane();
		ButtonListener listener=new ButtonListener();
		for(int i=0;i<btn.length;i++) {
			btn[i]=new JButton(""+(i+1));
			btn[i].setFont(new Font("Arial",Font.BOLD,24));
			btn[i].addActionListener(listener);
			pnl.add(btn[i]);
		}
		c.add(pnl,BorderLayout.CENTER);
		c.add(pnlButtom,BorderLayout.SOUTH);
		reset.addActionListener(listener);
		pnlButtom.add(tf);
		pnlButtom.add(reset);
		initGame();
		setVisible(true);
	}

	void initGame(){
		for(int i=0;i<btn.length;i++) {
			btn[i].setEnabled(true);
		}
		startTime=System.currentTimeMillis();
		tf.setText(0.0+" Sec");
		surffleButtons();
		playNumber=1;
	}
	
	void surffleButtons() {
		for(int i=0;i<100;i++) {
			int s=(int)(Math.random()*25);
			int d=(int)(Math.random()*25);
			String temp=btn[s].getText();
			btn[s].setText(btn[d].getText());
			btn[d].setText(temp);
		}
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton b=(JButton)e.getSource();
			if(b==reset) {
				initGame();
			}
			else if(Integer.parseInt(e.getActionCommand().toString())==playNumber) {
				b.setEnabled(false);
				playNumber++;
				endTime=System.currentTimeMillis();
				tf.setText(((endTime-startTime)/100)/10d+" Sec");
			}
		}
	}

	public static void main(String[] args) {
		new Game25();
	}
}
