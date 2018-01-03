package chessBoard;

import java.awt.Image;

public class ChessHorse 
{
	private Image b_Image;//背景图片
	private Image Image;//棋子图片
	private int row;//行
	private int column;//列
	private int flag=-1;//判断棋子的种类是红色还是黑色
	private String typeName=null;
	private String preName=null;
	public ChessHorse (Image bImage,Image Image,int row,int column,int flag,String typeName)
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
		if(Math.abs(arow-prow)==2&&Math.abs(acolumn-pcolumn)==1)
		{
			int rtemp=(arow-prow)/2;
			int ctemp=(acolumn-pcolumn)/2;
			if(ccd[arow][acolumn].getBoardFlag()==1)
			{
				if(ccd[prow+rtemp][pcolumn+ctemp].getBoardFlag()==1)
				{
					
				}
				else
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
			}
			else
			{
				if(ccd[prow+rtemp][pcolumn+ctemp].getBoardFlag()==0)
				{
					ccd[arow][acolumn].setBoardState(1, flag,typeName);
					setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
				}
			}
		}
		//
		if(Math.abs(arow-prow)==1&&Math.abs(acolumn-pcolumn)==2)
		{
			int rtemp=(arow-prow)/2;
			int ctemp=(acolumn-pcolumn)/2;
			if(ccd[arow][acolumn].getBoardFlag()==1)
			{
				if(ccd[prow+rtemp][pcolumn+ctemp].getBoardFlag()==1)
				{
					
				}
				else
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
			}
			else
			{
				if(ccd[prow+rtemp][pcolumn+ctemp].getBoardFlag()==0)
				{
					ccd[arow][acolumn].setBoardState(1, flag,typeName);
					setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
				}
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
	//得到行和列
	 public int getRow()
	 {
		 return row;
	 }
	 public int getColumn()
	 {	
	return column;
	 }
	//得到背景的图片 对象
		public Image getBKImage()
		{
			return b_Image;
		}
		//得到棋子图片
		public Image getImage()
		{
			return Image;
		}
	
		//得到被吃棋子的名称
	public String getPreName()
	{
		return preName;
	}
			

}

