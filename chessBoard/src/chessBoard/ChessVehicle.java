package chessBoard;
import java.awt.*;
public class ChessVehicle 
{
	private Image b_Image;//背景图片
	private Image Image;//棋子图片
	private int row;//行
	private int column;//列
	private int flag=-1;//判断棋子的种类是红色还是黑色
	private String typeName=null;
	private String preName=null;
	
	public ChessVehicle(Image bImage,Image Image,int row,int column,int flag,String typeName)
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
		//从起点到终点的棋子的判断
		//横着着判断
		
	if(prow==arow)
		{
			if(pcolumn<acolumn)
			{
				//记录次数的
				int count=0;
				for( int i=pcolumn+1;i<=acolumn;i++)
				{
					//判断有无棋子
					if(ccd[arow][i].getBoardFlag()==1)
						{
								//有同类型棋子直接不走
								if(ccd[prow][i].getchessFlag()==flag)
									{
											break;
										}
					//没有同类型棋子但有敌方棋子直接吃掉并干掉
										else
										{
												preName=ccd[prow][i].getClassName();
												ccd[prow][i].setBoardState(1, flag,typeName);
												ccd[prow][pcolumn].setBoardState(0, -1, null);
												setAddress(b_Image,Image,prow,i,flag,typeName);
												break;
										}
						}
					else
					{
						count++;
					}
					if(count==acolumn-pcolumn)
					{

						ccd[arow][acolumn].setBoardState(1, flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						count=0;
					}
					
					
					
					}
				

			}
		else
		{
			int i;
			//记录次数的
			int count=0;
			for( i=pcolumn-1;i>=acolumn;i--)
			{
				//判断有无棋子
				if(ccd[prow][i].getBoardFlag()==1)
				{
				//有同类型棋子直接不走
				if(ccd[prow][i].getchessFlag()==flag)
				{
					break;
				}
				//没有同类型棋子但有敌方棋子直接吃掉并干掉
				else
				{
					preName=ccd[prow][i].getClassName();
					ccd[prow][i].setBoardState(1, flag,typeName);
					setAddress(b_Image,Image,prow,i,flag,typeName);
					ccd[prow][pcolumn].setBoardState(0, -1, null);
					break;
					}
				}
				else
				{
					count++;
				}
				
				}
			if(count==pcolumn-acolumn)
			{
				ccd[arow][acolumn].setBoardState(1, flag,typeName);
				ccd[prow][pcolumn].setBoardState(0, -1, null);
				setAddress(b_Image,Image,arow,acolumn,flag,typeName);
				count=0;
			}
		}
		}
		//竖着判断
		if(pcolumn==acolumn)
		{
			if(prow<arow)
			{
				int i;
				int count=0;
				for( i=prow+1;i<=arow;i++)
				{
					//判断有无棋子
					if(ccd[i][pcolumn].getBoardFlag()==1)
					{
					
					//有同类型棋子直接不走
					if(ccd[i][pcolumn].getchessFlag()==flag)
					{
						
						break;
					}
					//没有同类型棋子但有敌方棋子直接吃掉并干掉
					else
					{
						preName=ccd[i][pcolumn].getClassName();
						ccd[i][pcolumn].setBoardState(1, flag,typeName);
						setAddress(b_Image,Image,i,pcolumn,flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						break;
						}
					}
					else
					{
						count++;
					}
					if(count==arow-prow)
					{
						ccd[arow][pcolumn].setBoardState(1, flag,typeName);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						count=0;
					}
					
				}
			}
			else
			{
				int i;
				int count=0;
				for( i=prow-1;i>=arow;i--)
				{
					//判断有无棋子
					if(ccd[i][pcolumn].getBoardFlag()==1)
					{
					//有同类型棋子直接不走
					if(ccd[i][pcolumn].getchessFlag()==flag)
					{
						break;
					}
					//没有同类型棋子但有敌方棋子直接吃掉并干掉
					else
					{
						preName=ccd[i][pcolumn].getClassName();
						ccd[i][pcolumn].setBoardState(1, flag,typeName);
						setAddress(b_Image,Image,i,pcolumn,flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
						}
					}
					else
					{
						count++;
					}
					if(count==prow-arow)
					{
						ccd[arow][acolumn].setBoardState(1, flag,typeName);
						setAddress(b_Image,Image,arow,acolumn,flag,typeName);
						ccd[prow][pcolumn].setBoardState(0, -1, null);
					}
					
						
				}
			}
		}
	
	}
	

	///
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

