package chessBoard;
import java.awt.*;
public class ChessVehicle 
{
	private Image b_Image;//����ͼƬ
	private Image Image;//����ͼƬ
	private int row;//��
	private int column;//��
	private int flag=-1;//�ж����ӵ������Ǻ�ɫ���Ǻ�ɫ
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
		//����㵽�յ�����ӵ��ж�
		//�������ж�
		
	if(prow==arow)
		{
			if(pcolumn<acolumn)
			{
				//��¼������
				int count=0;
				for( int i=pcolumn+1;i<=acolumn;i++)
				{
					//�ж���������
					if(ccd[arow][i].getBoardFlag()==1)
						{
								//��ͬ��������ֱ�Ӳ���
								if(ccd[prow][i].getchessFlag()==flag)
									{
											break;
										}
					//û��ͬ�������ӵ��ез�����ֱ�ӳԵ����ɵ�
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
			//��¼������
			int count=0;
			for( i=pcolumn-1;i>=acolumn;i--)
			{
				//�ж���������
				if(ccd[prow][i].getBoardFlag()==1)
				{
				//��ͬ��������ֱ�Ӳ���
				if(ccd[prow][i].getchessFlag()==flag)
				{
					break;
				}
				//û��ͬ�������ӵ��ез�����ֱ�ӳԵ����ɵ�
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
		//�����ж�
		if(pcolumn==acolumn)
		{
			if(prow<arow)
			{
				int i;
				int count=0;
				for( i=prow+1;i<=arow;i++)
				{
					//�ж���������
					if(ccd[i][pcolumn].getBoardFlag()==1)
					{
					
					//��ͬ��������ֱ�Ӳ���
					if(ccd[i][pcolumn].getchessFlag()==flag)
					{
						
						break;
					}
					//û��ͬ�������ӵ��ез�����ֱ�ӳԵ����ɵ�
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
					//�ж���������
					if(ccd[i][pcolumn].getBoardFlag()==1)
					{
					//��ͬ��������ֱ�Ӳ���
					if(ccd[i][pcolumn].getchessFlag()==flag)
					{
						break;
					}
					//û��ͬ�������ӵ��ез�����ֱ�ӳԵ����ɵ�
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

