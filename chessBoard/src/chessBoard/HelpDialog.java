package chessBoard;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class HelpDialog extends JDialog
{
	public HelpDialog(JFrame ower)
	{
		super(ower,"����",true);
		StringBuilder builder=new StringBuilder();
		builder.append("   ����һ��������Ϸ��");
		builder.append("\n");
		builder.append("    ʹ��˵��:");
		builder.append("\n");
		builder.append("   �봴�������ڵȴ��û����ӣ���Ҳ�����������еķ��䣬�������˻���ս��");
		JTextArea area=new JTextArea();
		area.setLineWrap(true);
		area.setText(builder.toString());
		area.setEditable(false);
		//area.setOpaque(false);
		//area.setWrapStyleWord(true);
		//�ı��ı��������
				area.setFont(new Font("SansSerif",Font.BOLD,18));
		JButton okButton=new JButton("ȷ��");
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
