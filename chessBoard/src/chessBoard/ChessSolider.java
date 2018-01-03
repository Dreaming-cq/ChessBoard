package chessBoard;

import java.awt.Image;

public class ChessSolider 
{
	private Image b_Image;//����ͼƬ
	private Image Image;//����ͼƬ
	private int row;//��
	private int column;//��
	private int flag=-1;//�ж����ӵ������Ǻ�ɫ���Ǻ�ɫ
	private String typeName=null;
	private String preName=null;
	public ChessSolider (Image bImage,Image Image,int row,int column,int flag,String typeName)
	{
		this.b_Image=bImage;
		this.Image=Image;
		this.row=row;
		this.column=column;
		this.flag=flag;
		this.typeName=typeName;
	}
	
	//
	public void ChessMove(ChessCoordinate[][]ccd,int prow,int pcolumn,int arow,int acolumn)
	{
		//��ɫ����
		
		if(Math.abs(arow-prow)==1&&Math.abs(acolumn-pcolumn)==1&&arow<=2&&acolumn<=5&&acolumn>=3)
		{
			if(ccd[arow][acolumn].getBoardFlag()==1)
			{
				if(ccd[arow][acolumn].getchessFlag()==flag)
				{
					
				}
				else
				{
					preName=ccd[arow][acolumn].getClassName();
					ccd[arow][acolumn].setBoardState(1, flag,typeName);
					setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
				}
			}
			else
			{
				
				ccd[arow][acolumn].setBoardState(1, flag,typeName);
				setAddress(b_Image,Image,arow,acolumn,flag,typeName);
				ccd[prow][pcolumn].setBoardState(0, -1, null);
			}
		}
	
		//����
		if(Math.abs(arow-prow)==1&&Math.abs(acolumn-pcolumn)==1&&arow>=7&&acolumn<=5&&acolumn>=3)
		{
			if(ccd[arow][acolumn].getBoardFlag()==1)
			{
				if(ccd[arow][acolumn].getchessFlag()==flag)
				{
					
				}
				else
				{
					preName=ccd[arow][acolumn].getClassName();
					ccd[arow][acolumn].setBoardState(1, flag,typeName);
					setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
				}
			}
			else
			{
				
				ccd[arow][acolumn].setBoardState(1, flag,typeName);
				setAddress(b_Image,Image,arow,acolumn,flag,typeName);
				ccd[prow][pcolumn].setBoardState(0, -1, null);
			}
		}
	
		
		
	}
	
	public void setAddress(Image bImage,Image Image,int row,int column,int flag,String typeName)
	{
		this.b_Image=bImage;
		this.Image=Image;
		this.row=row;
		this.column=column;
		this.flag=flag;
		this.typeName=typeName;
	}
	//�õ��к���
	 public int getRow()
	 {
		 return row;
	 }
	 public int getColumn()
	 {	
	return column;
	 }
	//�õ�������ͼƬ ����
		public Image getBKImage()
		{
			return b_Image;
		}
		//�õ�����ͼƬ
		public Image getImage()
		{
			return Image;
		}
		
		//�õ��������ӵ�����
	public String getPreName()
	{
		return preName;
	}
				

}
