package chessBoard;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.*;

@SuppressWarnings("serial")
public class ChessBoard extends JFrame
{
	private ChessPanel chessPanel;
	 //中国象棋的标签
	 private JLabel label1;
	 private JLabel label2;
	 //主界面的象棋，下棋的顺序，返回上一部
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JButton rButton;
	private JPanel funPanel;
	
	 //创建房间,连接用户，单机战斗，使用帮助
	 private JButton create_Button;
	 private JButton connect_Button;
	 private JButton alone_Button;
	 private JButton help_Button;
	 //连接用户界面（客户端）
	 private JPanel connect_User;
	 private bgPanel mainPanel;
	 ////ip输入框
	 //端口输入框
	 //连接按钮
	private JTextField user;
	private JTextField port;
	private JButton ok_Button;
	private JButton return_Button;
	//标志
	private int type=-1;
	private int server=0;
	private int client=1;
	//定时器
	private Timer timer;
	//帮助对话框
	private HelpDialog helpDlg;
	//***************************
	//线程
	//****************************88
	private ClientThread cThread;
	private  MainThread mThread;
	
	public ChessBoard()
	{
		
		helpDlg=new HelpDialog(this);
		chessPanel=new ChessPanel();
		chessPanel.setBounds(0,0,507,589);
		setSize(507,589);
		setLocation(700,200);
		setTitle("中国象棋");
		setResizable(false);
		setLayout(null);
		//*****************************************
		//主界面面板
		//****************************************
		String photoPath="E:"+File.separator+"chess\\back.jpg";
		mainPanel=new bgPanel();
		mainPanel.setPath(photoPath,0,0,507,589);
		label1=new JLabel("中国",JLabel.CENTER);
		 label1.setFont(new Font("SansSerif",Font.BOLD,50));
		 label1.setForeground(Color.BLACK);
		 label2=new JLabel("象棋",JLabel.CENTER);
		 label2.setFont(new Font("SansSerif",Font.BOLD,50));
		 label2.setForeground(Color.RED);
		 //******************************
		 create_Button=new JButton("创建房间");
		 create_Button.setFont(new Font("SansSerif",Font.BOLD,25));
		 create_Button.setBackground(new Color(237,237,237));
		 create_Button.setForeground(Color.BLUE);
		 create_Button.setBorderPainted(false);
		 create_Button.setOpaque(false);
		 //**************************************
		 connect_Button=new JButton("连接用户");
		 connect_Button.setFont(new Font("SansSerif",Font.BOLD,25));
		 connect_Button.setBackground(new Color(237,237,237));
		 connect_Button.setForeground(Color.BLUE);
		 connect_Button.setBorderPainted(false);
		 connect_Button.setOpaque(false);
		 //*****************************************
		 alone_Button=new JButton("单机战斗");
		 alone_Button.setFont(new Font("SansSerif",Font.BOLD,25));
		 alone_Button.setBackground(new Color(237,237,237));
		 alone_Button.setForeground(Color.BLUE);
		 alone_Button.setBorderPainted(false);
		 alone_Button.setOpaque(false);
		 //*******************************************
		 help_Button=new JButton("帮助");
		 help_Button.setFont(new Font("SansSerif",Font.BOLD,25));
		 help_Button.setBackground(new Color(237,237,237));
		 help_Button.setForeground(Color.RED);
		 help_Button.setBorderPainted(false);
		 help_Button.setOpaque(false);
		 
		 //*********************************************
		 //mainPanel.setLayout(null);
		label1.setBounds(0,0,150,150);
		label2.setBounds(350,0,150,150);
		create_Button.setBounds(150,200,200,50);
		connect_Button.setBounds(150,250,200,50);
		alone_Button.setBounds(150,300,200,50);
		 help_Button.setBounds(400,370,100,50);
		 mainPanel.add(label1);
		 mainPanel.add(label2);
		 mainPanel.add(create_Button);
		 mainPanel.add(connect_Button);
		 mainPanel.add(alone_Button);
		 mainPanel.add(help_Button);
		 mainPanel.setBounds(0,0,507,589);
		 add(mainPanel);
		//*********************************
		//连接用户的界面，ip，port
		//*********************************
		 connect_User=new JPanel();
		 connect_User.setLayout(null);
		 JLabel label11=new JLabel("IP:",JLabel.CENTER);
		user=new JTextField();
		JLabel label22=new JLabel("port:",JLabel.CENTER);
		 port=new JTextField();
		 port.setText("8000");
		ok_Button=new JButton("连接");
		return_Button=new JButton("返回上一步");
		label11.setBounds(0,250,50,30);
		user.setBounds(50, 250, 200, 30);
		label22.setBounds(250,250,50,30);
		port.setBounds(300, 250, 100, 30);
		ok_Button.setBounds(420,250,80,30);
		return_Button.setBounds(200,500,100,30);
		connect_User.add(label11);
		connect_User.add(user);
		connect_User.add(label22);
		connect_User.add(port);
		connect_User.add(ok_Button);
		connect_User.add(return_Button);
		connect_User.setBounds(0,0,507,589);
		//*********************************
		//象棋的界面
		//**********************************
		funPanel=new JPanel();
		funPanel.setLayout(null);
		funPanel.setBorder(BorderFactory.createMatteBorder(8,8,15,10,Color.GREEN));
		funPanel.setBounds(500,0,120,580);
		funPanel.setBackground(new Color(156,115,58));
		label3=new JLabel("象",JLabel.CENTER);
		label3.setFont(new Font("楷体",Font.BOLD,50));
		label4=new JLabel("棋",JLabel.CENTER);
		label4.setFont(new Font("楷体",Font.BOLD,50));
		label5=new JLabel("红：我",JLabel.CENTER);
		label5.setFont(new Font("楷体",Font.BOLD,20));
		label5.setForeground(Color.RED);
		label6=new JLabel("黑：我",JLabel.CENTER);
		label6.setFont(new Font("楷体",Font.BOLD,20));
		rButton=new JButton("返回主菜单");
		rButton.setBackground(new Color(156,115,58));
		rButton.setForeground(Color.red);
		rButton.setBorderPainted(false);
		label3.setBounds(0,20,110,50);
		funPanel.add(label3);
		label4.setBounds(0,100,110,50);
		funPanel.add(label4);
		label5.setBounds(0,220,110,50);
		label6.setBounds(0,220,110,50);
		rButton.setBounds(10,500,100,25);
		funPanel.add(rButton);
		//***********************
		//定时器,面板更新
		//*************************
		timer=new Timer(1000,new ActionListener()
				{
			public void actionPerformed(ActionEvent event)
			{
				chessPanel.UpdatePanel();
			}
				});
		timer.start();
//*********************************
//事件处理
//
//*********************************
		//创建房间按钮
		 create_Button.addActionListener(new ActionListener()
				 {
			 public void actionPerformed(ActionEvent event)
			 {
				 String ip=null;
				remove(mainPanel);
				add(connect_User);
				revalidate();
				repaint();
				type=server;
				//获取本机的IP；
				try {
					 ip=InetAddress.getLocalHost().getHostAddress();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				user.setText(ip);
				user.setEditable(false);
			
			 }
				 });
		 //连接用户按钮
		 connect_Button.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 remove(mainPanel);
					add(connect_User);
					revalidate();
					repaint();
					type=client;
					
			 }
		 });
		 //单机战斗按钮
		 alone_Button.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent event)
			 {
				 
			 }
		 });
		 //帮助按钮
		 help_Button.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 helpDlg.setVisible(true);
			 }
		 });
		 //连接按钮
		 ok_Button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent event)
			{
				if(type==client)
					try {
					//是否输入是正确的iP
					String ip=null;
					ip=user.getText().trim();
					String regex="^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
								+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
								+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
								+"(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
						if(ip.matches(regex))
						{	setSize(620,589);
							remove(connect_User);
						
							add(chessPanel);
							
							add(funPanel);
							revalidate();
							chessPanel.setState(true, true,false,"b","r");
							Socket socket=new Socket(ip,Integer.parseInt( port.getText().trim()));
							cThread =new ClientThread(socket,chessPanel);
							cThread.start();
							funPanel.add(label5);
							repaint();
						}
						else
						{
							JOptionPane.showMessageDialog(null, "ip不合法");
						}
						
			} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(type==server)
				{	
					setSize(620,589);
					remove(connect_User);
					add(chessPanel);
					add(funPanel);
					revalidate();
					try {
						JOptionPane.showMessageDialog(null,"请等候用户连接");
						chessPanel.setState(false, true,true,"r","b");
						mThread=new MainThread(Integer.parseInt( port.getText().trim()),chessPanel);
						mThread.start();
						funPanel.add(label6);
						repaint();
						} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			});
		 return_Button.addActionListener(new ActionListener()
				 {
			 public void actionPerformed(ActionEvent e)
			 {
				 remove(connect_User);
				 add(mainPanel);
				 revalidate();
				 repaint();
				 type=-1;
			 }
				 });
		 //
		 rButton.addActionListener(new ActionListener()
				 {
			 public void actionPerformed(ActionEvent e)
			 {	
				 setSize(507,589);
				 remove(chessPanel);
				remove(funPanel);
				 add(mainPanel);
				user.setText("");
				user.setEditable(true);
				 type=-1;
				 chessPanel.init_Game();
				 revalidate();
			
			 }
				 });
		
		 //***********************************
		 //
		 //**************************************
		addWindowListener(new WindowListener()
				{

					@Override
					public void windowOpened(WindowEvent e) {
						
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent e) {
						// TODO Auto-generated method stub
						
						
						timer.stop();
						System.exit(0);
						
					}

					@Override
					public void windowIconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowActivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeactivated(WindowEvent e) {
						// TODO Auto-generated method stub
						
					}
			
				});
		
		

	} 

	 
	public static void main(String[] args)
	{ 
		
		ChessBoard c=new ChessBoard();
		c.setVisible(true);
	
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}






