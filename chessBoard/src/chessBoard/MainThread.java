package chessBoard;

import java.io.IOException;
import java.net.ServerSocket;
//****************************************
//解决socket.accept造成的阻塞问题，防止主线程阻塞造成程序不能运行
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
