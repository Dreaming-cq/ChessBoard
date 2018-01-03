package chessBoard;

import java.awt.Image;

public class ChessForce
{
	private Image b_Image;//����ͼƬ
	private Image Image;//����ͼƬ
	private int row;//��
	private int column;//��
	private int flag=-1;//�ж����ӵ������Ǻ�ɫ���Ǻ�ɫ
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
		//�ж����������ߵ�û����
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
		//�ж����ӹ���ʱ
		//�жϺ������
		if(arow>4&&prow>=4&&ccd[prow][pcolumn].getchessFlag()==1)
		{
			//����
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
			//���������ƶ�
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
		
		//�жϺ������
		if(arow<5&&prow<=5&&ccd[prow][pcolumn].getchessFlag()==0)
		{
			//����
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
			//���������ƶ�
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
	//
	//�õ��������ӵ�����
	public String getPreName()
	{
		return preName;
	}

}
