package chessBoard;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class HelpDialog extends JDialog
{
	public HelpDialog(JFrame ower)
	{
		super(ower,"帮助",true);
		StringBuilder builder=new StringBuilder();
		builder.append("   这是一款象棋游戏。");
		builder.append("\n");
		builder.append("    使用说明:");
		builder.append("\n");
		builder.append("   想创建房间在等待用户连接，你也可以连接已有的房间，还可以人机大战。");
		JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setText(builder.toString());
		area.setEditable(false);
		//area.setOpaque(false);
		//area.setWrapStyleWord(true);
		//改变文本域的字体
				area.setFont(new Font("SansSerif",Font.BOLD,18));
		JButton okButton=new JButton("确定");
		okButton.addActionListener(new ActionListener()
				{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
			}
				});
		
		setSize(600,400);
		setResizable(false);
		setLayout(null);
		setLocation(500,200);
		area.setBounds(0,100,600,150);
		okButton.setBounds(250,330,100,30);
		add(area);
		add(okButton);
	
	}
}
