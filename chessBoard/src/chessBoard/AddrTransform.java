package chessBoard;

public class AddrTransform 
{
		private double xOrg=-1;
		private double yOrg=-1;
		private int row=-1;
		private int column=-1;
		//******************************
		//根据鼠标点的位置判断点所在的行和列
		//棋盘第一个点距原点距离为19像素
		//***************************
		//判断点所在的行
		public int  getRow(double ayOrg)
		{
		
			row=(int)(ayOrg-19)/58;
			//求余
			double remainder=(double)(ayOrg-19)%58.0;
			if(remainder>29.0)
				{
				row++;
				return row;
				}
			return row;
		}
		//判断点所在的列
		public int getColumn(double axOrg)
		{
			column=(int)(axOrg-19)/58;
			//求余
			double remainder=(double)(axOrg-19)%58.0;
			if(remainder>29.0)
				{
				column++;
				return column;
				}
			
			return column;
		}
		//*****************************
		//根据行和列判断象棋棋子的图片锁帖的位置
		//图片的尺寸38X38;
		//
		//*****************************
		//得到图片的x;
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
