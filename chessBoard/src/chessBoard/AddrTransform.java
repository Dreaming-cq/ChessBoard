package chessBoard;

public class AddrTransform 
{
		private double xOrg=-1;
		private double yOrg=-1;
		private int row=-1;
		private int column=-1;
		//******************************
		//���������λ���жϵ����ڵ��к���
		//���̵�һ�����ԭ�����Ϊ19����
		//***************************
		//�жϵ����ڵ���
		public int  getRow(double ayOrg)
		{
		
			row=(int)(ayOrg-19)/58;
			//����
			double remainder=(double)(ayOrg-19)%58.0;
			if(remainder>29.0)
				{
				row++;
				return row;
				}
			return row;
		}
		//�жϵ����ڵ���
		public int getColumn(double axOrg)
		{
			column=(int)(axOrg-19)/58;
			//����
			double remainder=(double)(axOrg-19)%58.0;
			if(remainder>29.0)
				{
				column++;
				return column;
				}
			
			return column;
		}
		//*****************************
		//�����к����ж��������ӵ�ͼƬ������λ��
		//ͼƬ�ĳߴ�38X38;
		//
		//*****************************
		//�õ�ͼƬ��x;
		public double getPhotoxOrg(int acolumn)
		{
			xOrg=acolumn*58.0;
			
			return xOrg;
		}
		
		public double getPhotoyOrg(int arow)
		{
			yOrg=arow*58.0;
			return yOrg;
		}
		
		
		
}
