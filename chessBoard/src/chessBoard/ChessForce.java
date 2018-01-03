package chessBoard;

import java.awt.Image;

public class ChessForce
{
	private Image b_Image;//背景图片
	private Image Image;//棋子图片
	private int row;//行
	private int column;//列
	private int flag=-1;//判断棋子的种类是红色还是黑色
	private String typeName=null;
	private String preName=null;
	public ChessForce (Image bImage,Image Image,int row,int column,int flag,String typeName)
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
		//判断棋子向上走但没过河
		if(pcolumn==acolumn)
		{
			if(arow==4&&prow==3)
			{
				if(ccd[arow][pcolumn].getBoardFlag()==1)
				{
					if(ccd[arow][pcolumn].getchessFlag()==flag)
					{
						
					}
					else
					{
						preName=ccd[arow][acolumn].getClassName();
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						ccd[arow][acolumn].setBoardState(1,flag,typeName);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					}
				}
				else
				{
					ccd[arow][acolumn].setBoardState(1, flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
					setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					
				}
			}
			
			if(arow==5&&prow==6)
			{
				if(ccd[arow][pcolumn].getBoardFlag()==1)
				{
					if(ccd[arow][pcolumn].getchessFlag()==flag)
					{
						
					}
					else
					{
						preName=ccd[arow][acolumn].getClassName();
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						ccd[arow][acolumn].setBoardState(1,flag,typeName);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					}
				}
				else
				{
					ccd[arow][acolumn].setBoardState(1, flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
					setAddress(b_Image,Image,arow,acolumn,flag,typeName);
				}
			}
		
		}
		//判断棋子过河时
		//判断黑棋过河
		if(arow>4&&prow>=4&&ccd[prow][pcolumn].getchessFlag()==1)
		{
			//向上
			if(pcolumn==acolumn)
			{
				if(arow-prow==1&&arow>prow)
				{
					if(ccd[arow][pcolumn].getBoardFlag()==1)
					{
						if(ccd[arow][pcolumn].getchessFlag()==flag)
						{
							
						}
						else
						{
							preName=ccd[arow][acolumn].getClassName();
							ccd[prow][pcolumn].setBoardState(0, -1, null);
							ccd[arow][acolumn].setBoardState(1,flag,typeName);
							setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						}
					}
					else
					{
						ccd[arow][acolumn].setBoardState(1, flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					}
				}
			}
			//向左向右移动
			if(prow==arow)
			{
				if(Math.abs(acolumn-pcolumn)==1)
				{
					if(ccd[arow][acolumn].getBoardFlag()==1)
					{
						if(ccd[arow][acolumn].getchessFlag()==flag)
						{
							
						}
						else
						{
							preName=ccd[arow][acolumn].getClassName();
							ccd[prow][pcolumn].setBoardState(0, -1, null);
							ccd[arow][acolumn].setBoardState(1,flag,typeName);
							setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						}
					}
					else
					{
						ccd[arow][acolumn].setBoardState(1, flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					}
				}
			}
		}
		
		//判断红棋过河
		if(arow<5&&prow<=5&&ccd[prow][pcolumn].getchessFlag()==0)
		{
			//向上
			if(pcolumn==acolumn)
			{
				if(prow-arow==1&&arow< prow)
				{
					if(ccd[arow][pcolumn].getBoardFlag()==1)
					{
						if(ccd[arow][pcolumn].getchessFlag()==flag)
						{
							
						}
						else
						{
							preName=ccd[arow][acolumn].getClassName();
							ccd[prow][pcolumn].setBoardState(0, -1, null);
							ccd[arow][acolumn].setBoardState(1,flag,typeName);
							setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						}
					}
					else
					{
						ccd[arow][acolumn].setBoardState(1, flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					}
				}
			}
			//向左向右移动
			if(prow==arow)
			{
				if(Math.abs(acolumn-pcolumn)==1)
				{
					if(ccd[arow][acolumn].getBoardFlag()==1)
					{
						if(ccd[arow][acolumn].getchessFlag()==flag)
						{
							
						}
						else
						{
							preName=ccd[arow][acolumn].getClassName();
							ccd[prow][pcolumn].setBoardState(0, -1, null);
							ccd[arow][acolumn].setBoardState(1,flag,typeName);
							setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						}
					}
					else
					{
						ccd[arow][acolumn].setBoardState(1, flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
					}
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
	//
	//得到被吃棋子的名称
	public String getPreName()
	{
		return preName;
	}

}
