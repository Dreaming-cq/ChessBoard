package chessBoard;

import java.io.IOException;
import java.net.ServerSocket;
//****************************************
//���socket.accept��ɵ��������⣬��ֹ���߳�������ɳ���������
//
//******************************************
public class MainThread extends Thread
{
	private int port;
	private ServerSocket serverSocket=null;
	private ServerThread sThread;
	private ChessPanel chessPanel;
	public MainThread(int nport,ChessPanel chessPanel) throws IOException
	{
		this.port=nport;
		serverSocket=new ServerSocket(port);
		this.chessPanel=chessPanel;
		
	}
	public void run()
	{
		try {
			sThread=new ServerThread(serverSocket,chessPanel);
			sThread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
