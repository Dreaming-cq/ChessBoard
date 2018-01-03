package chessBoard;


//棋盘的坐标
//规定1代表红子，0代表黑子；
//
//
//
//
public class ChessCoordinate 
{
	//棋盘有无子的标识，1代表有子，0代表无子；
	private int boardFlag=-1;
	//表示棋子的种类，0红子1黑子
	private int chessFlag=-1;
	//
	private String chessName=null;
	
	public ChessCoordinate (int aboardFlag,int achessFlag,String achessName)
	{
		this.boardFlag=aboardFlag;
		this.chessFlag=achessFlag;
		this.chessName=achessName;
	}
	public void setBoardState(int aboardFlag,int achessFlag,String achessName)
	{
		this.boardFlag=aboardFlag;
		this.chessFlag=achessFlag;
		this.chessName=achessName;
	}
	
	//返回棋盘的状态
	public int getBoardFlag()
	{
		return boardFlag;
	}
	//返回什么棋子
	public int getchessFlag()
	{
		return chessFlag;
	}
	//返回棋子相关的类
	public String getClassName()
	{
		return chessName;
	}
}
