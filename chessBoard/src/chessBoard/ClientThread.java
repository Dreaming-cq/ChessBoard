package chessBoard;
import java.awt.geom.Point2D;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;
public class ClientThread extends Thread
{
	private Socket clientSocket=null;
	private InputStream in=null;
	private OutputStream out=null;
	private DataInputStream din=null;
	private DataOutputStream dout=null;
	private ChessPanel chessPanel;
	private volatile boolean isSend=true;
	
	public ClientThread(Socket socket,ChessPanel cPanel) throws IOException
	{
		this.chessPanel=cPanel;
		this.clientSocket=socket;
		if(clientSocket!=null)
		{
			JOptionPane.showMessageDialog(null,"用户已连接，你是红棋，红棋先");
		}
	}
	//接受消息
	public Point2D[] ReceiveMessage() throws IOException
	{
			in=clientSocket.getInputStream();
			din=new DataInputStream(in);
			byte[] inbuf=new byte[1024];
			din.read(inbuf);
			String coordinate=new String(inbuf);
			String[] cs=coordinate.trim().split(",");
			Point2D pt=new Point2D.Double(Double.parseDouble(cs[0]),Double.parseDouble(cs[1]));
			Point2D nt=new Point2D.Double(Double.parseDouble(cs[2]),Double.parseDouble(cs[3]));
			Point2D[] npt= {pt,nt};
			return npt;
		
			
		}
	//发送消息
	public void SendMessage(Point2D prvPt,Point2D nowPt) throws IOException
		{
			out=clientSocket.getOutputStream();
			dout=new DataOutputStream(out);
			String prvx=String.valueOf((int)prvPt.getX());
			String prvy=String.valueOf((int)prvPt.getY());
			String nowx=String.valueOf((int)nowPt.getX());
			String nowy=String.valueOf((int)nowPt.getY());
			String coordinate=prvx+","+prvy+","+nowx+","+nowy;
			byte[] outbuf=coordinate.getBytes();
			dout.write(outbuf);
	}
	//关闭连接
			public void CloseConnect() throws IOException
			{
				if(in!=null)
				{
				in.close();
				}
				if(out!=null)
				{
				out.close();
				}
				if(din!=null)
				{
				din.close();
				}
				if(dout!=null)
				{
				dout.close();
				}
				if(clientSocket!=null)
				{
				clientSocket.close();
				}
			
				
			}
	//
	public void run()
	{
		while(chessPanel.getTotal()==true)
		{
			while(isSend==true)
			{	
				if(chessPanel.getSendPt()[0]!=null&&chessPanel.getSendPt()[1]!=null)
				try {
					Point2D[] pt=chessPanel.getSendPt();
					SendMessage(pt[0],pt[1]);
					isSend=false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			while(isSend==false)
			{
				try {
					Point2D[] pt=ReceiveMessage();
					chessPanel.UpdateChess(pt[0], pt[1]);
					isSend=true;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		if(chessPanel.getTotal()==false)
		{
			try {
				CloseConnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
