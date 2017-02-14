import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class TicTacToe implements ActionListener
{
	int flag=0;
	JFrame jf;
	JButton one,two;
	JButton b[][]=new JButton[9][3];
	JPanel jp[]=new JPanel[9];
	JPanel jp1=new JPanel();
	JLabel lb;
	Icon ic;
	CardLayout cl;
	TicTacToe()
	{
		ic=new ImageIcon("download.jpg");
		jf=new JFrame();
		int i,j;
		for(i=0;i<b.length;i++)
		{
				b[i][0]=new JButton();
				b[i][1]=new JButton("X");
				b[i][2]=new JButton("O");
				b[i][0].setToolTipText("1P=X   2P=O");
				b[i][1].setToolTipText("1P=X   2P=O");
				b[i][2].setToolTipText("1P=X   2P=O");
		}
		cl=new CardLayout();
		for(i=0;i<jp.length;i++)
		{
			jp[i]=new JPanel();
			jp[i].setLayout(cl);
			jp[i].add(b[i][0]," ");
			jp[i].add(b[i][1],"X");
			jp[i].add(b[i][2],"O");
			jf.add(jp[i]);
		}
		
		for(i=0;i<b.length;i++)
		{
			for(j=0;j<b[0].length;j++)
			{
				b[i][j].addActionListener(this);
				b[i][j].setFont(new Font("UBUNTU",Font.BOLD,35));
			}
		}
		lb=new JLabel("Player 1 Turn");
		lb.setFont(new Font("Arial",Font.BOLD,30));
		for(i=0;i<9;i++)
		jp1.add(jp[i]);
		jp1.setLayout(new GridLayout(3,3));
		jf.add(jp1,BorderLayout.CENTER);
		jp1.setVisible(true);
		jf.add(lb,BorderLayout.SOUTH);
		jf.setSize(400,420);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		int x=(int)(dim.getWidth())/2-(int)(jf.getWidth())/2;
		int y=(int)(dim.getHeight())/2-(int)(jf.getHeight())/2;
		jf.setLocation(x,y);
		jf.setResizable(false);
	}

	public void actionPerformed(ActionEvent ae)
	{
		int i,j,k,number=10;
		int count=0;
		String s[]=new String[9];
		for(i=0;i<9;i++)
		{
			for(j=0;j<3;j++)
			{	
			if(ae.getSource()==b[i][j] && flag==0)
			{cl.next(jp[i]);
			flag=1;
			}
			else if(ae.getSource()==b[i][j] && flag==1)
			{cl.previous(jp[i]);
			flag=0;
			}
			}
		}
		for(i=0;i<9;i++)
		{
		for(j=0;j<3;j++)
		{
		if(b[i][j].isVisible()==true)
		s[i]=b[i][j].getText();
		}
		}
		for(i=0;i<9;i=i+3)
		{
		if(s[i]=="X" && s[i+1]=="X" && s[i+2]=="X")
		{lb.setText("Player 1 Wins");
		flag=2;
		}
		if(s[i]=="O" && s[i+1]=="O" && s[i+2]=="O")
		{lb.setText("Player 2 Wins");
		flag=3;
		}
		}
		for(i=0;i<3;i++)
		{
		if(s[i]=="X" && s[i+3]=="X" && s[i+6]=="X")
		{lb.setText("Player 1 Wins");
		flag=2;
		}
		if(s[i]=="O" && s[i+3]=="O" && s[i+6]=="O")
		{lb.setText("Player 2 Wins");
		flag=3;
		}
		}
		if(s[0]=="X" && s[4]=="X" && s[8]=="X")
		{lb.setText("Player 1 Wins");
		flag=2;
		}
		if(s[2]=="X" && s[4]=="X" && s[6]=="X")
		{lb.setText("Player 1 Wins");
		flag=2;
		}
		if(s[0]=="O" && s[4]=="O" && s[8]=="O")
		{lb.setText("Player 2 Wins");
		flag=3;
		}
		if(s[2]=="O" && s[4]=="O" && s[6]=="O")
		{lb.setText("Player 2 Wins");
		flag=3;
		}
		for(i=0;i<9;i++)
		{
		if(s[i]=="X"||s[i]=="O")
		count++;
		}
		String[] obj={"PLAY","EXIT"};
		
		if(flag==2||(flag==2 && count==9))
		{
			number=JOptionPane.showOptionDialog(null,"wanna play again?","Player 1 WINS",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,ic,obj,obj[0]);
		}
		else if(flag==3||(flag==3 && count==9))
		number=JOptionPane.showOptionDialog(null,"wanna play again?","Player 2 WINS",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,ic,obj,obj[0]);
		else if(count==9)
			{lb.setText("Draw it seems"); 
			number=JOptionPane.showOptionDialog(null,"wanna play again?","Draw it seems",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE,null,obj,obj[0]);
			}
		else if(flag==1)
			lb.setText("Player 2 Turn");
		else if(flag==0)
			lb.setText("Player 1 Turn");
		if(number==0)
		{
			jf.setVisible(false);
			new TicTacToe();
		}
		else if(number==1)
		{
			System.exit(0);
			}
			
			
	}
	public static void main(String...s)
	{
	new TicTacToe();
		
	}
}
