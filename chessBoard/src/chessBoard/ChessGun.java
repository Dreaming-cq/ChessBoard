package chessBoard;

import java.awt.Image;

public class ChessGun 
{
	private Image b_Image;//背景图片
	private Image Image;//棋子图片
	private int row;//行
	private int column;//列
	private int flag=-1;//判断棋子的种类是红色还是黑色
	private String typeName=null;
	private String preName=null;
	public ChessGun (Image bImage,Image Image,int row,int column,int flag,String typeName)
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
	
		//横着判断
		if(arow==prow)
		{
			if(acolumn>pcolumn)
			{
				//判断两点之间有几个棋子
				int count=0;
				for(int i=pcolumn+1;i<acolumn;i++)
				{
					if(ccd[arow][i].getBoardFlag()==1)
					{
						count++;
					}
				}
					if(count==1)
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
							
						}
					}
					if(count==0)
					{
						if(ccd[arow][acolumn].getBoardFlag()==1)
						{
							if(ccd[arow][acolumn].getchessFlag()==flag)
							{
								
							}
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
			if(acolumn<pcolumn)
			{
				//判断两点之间有几个棋子
				int count=0;
				for(int i=pcolumn-1;i>acolumn;i--)
				{
					if(ccd[arow][i].getBoardFlag()==1)
					{
						count++;
					}
				}
					if(count==1)
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
							
						}
					}
					if(count==0)
					{
						if(ccd[arow][acolumn].getBoardFlag()==1)
						{
							if(ccd[arow][acolumn].getchessFlag()==flag)
							{
								
							}
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
		}
		//竖着判断
		if(acolumn==pcolumn)
		{
			if(arow>prow)
			{
				//判断两点之间有几个棋子
				int count=0;
				for(int i=prow+1;i<arow;i++)
				{
					if(ccd[i][acolumn].getBoardFlag()==1)
					{
						count++;
					}
				}
					if(count==1)
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
							
						}
					}
					if(count==0)
					{
						if(ccd[arow][acolumn].getBoardFlag()==1)
						{
							if(ccd[arow][acolumn].getchessFlag()==flag)
							{
							
							}
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
			if(arow<prow)
			{
				//判断两点之间有几个棋子
				int count=0;
				for(int i=prow-1;i>arow;i--)
				{
					if(ccd[i][acolumn].getBoardFlag()==1)
					{
						count++;
					}
				}
					if(count==1)
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
							
						}
					}
					if(count==0)
					{
						if(ccd[arow][acolumn].getBoardFlag()==1)
						{
							if(ccd[arow][acolumn].getchessFlag()==flag)
							{
								
							}
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

