package chessBoard;


//���̵�����
//�涨1������ӣ�0������ӣ�
//
//
//
//
public class ChessCoordinate 
{
	//���������ӵı�ʶ��1�������ӣ�0�������ӣ�
	private int boardFlag=-1;
	//��ʾ���ӵ����࣬0����1����
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
	
	//�������̵�״̬
	public int getBoardFlag()
	{
		return boardFlag;
	}
	//����ʲô����
	public int getchessFlag()
	{
		return chessFlag;
	}
	//����������ص���
	public String getClassName()
	{
		return chessName;
	}
}
