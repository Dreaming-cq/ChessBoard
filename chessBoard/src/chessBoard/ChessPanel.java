package chessBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.util.*;



//棋盘的面板
@SuppressWarnings("serial")
public class ChessPanel extends JComponent implements MouseListener
{
	private Toolkit tool=Toolkit.getDefaultToolkit();
	private Image boardImage;
	//黑色的棋子
	private Image bcImage;
	private Image bmImage;
	private Image bxImage;
	private Image bsImage;
	private Image bjImage;
	private Image bpImage;
	private Image bzImage;
	private Image bkImage=null;
	
	
	//红色的棋子
	private Image rcImage;
	private Image rmImage;
	private Image rxImage;
	private Image rsImage;
	private Image rjImage;
	private Image rpImage;
	private Image rzImage;
	private Image rkImage=null;
	
	//鼠标左右键
	private boolean lBool=false;
	private boolean rBool=false;
	//总按钮
	private boolean total=true;
	private static  int clickNumber=0;
	private String tname=null;
	private String tname1=null;
	//两次点的坐标
	private   Point2D prvPt;
	private  Point2D nowPt;
	private Point2D nowPt_rk=null;
	private Image nrkImage=null;
	//*********************************************
	//发送的坐标
	//*********************************************
	private  Point2D send_prvPt=null;
	private  Point2D send_nowPt=null;
	//***************************************************
	//棋盘的坐标
	private ChessCoordinate[][] ccd=new ChessCoordinate[10][9];
	//*********************************
	 //定义棋子标志
	 //红色棋子
	private String[] blackChess= {"bc","bm","bx","bs","bj","bs1","bx1","bm1","bc1","bp","bp1","bz","bz1","bz2","bz3","bz4"};
	 private String[] redChess= {"rc","rm","rx","rs","rj","rs1","rx1","rm1","rc1","rp","rp1","rz","rz1","rz2","rz3","rz4"};
	//
	 //坐标的转换
	 private AddrTransform transform=new AddrTransform();
	 
	 //**********************************
	 //棋子的种类
	 //************************************
	 //车的类
	 private ChessVehicle rcv1=null,rcv2=null,bcv1=null,bcv2=null;
	 //马
	 private ChessHorse rcm1=null,rcm2=null,bcm1=null,bcm2=null;
	 //象
	 private ChessElephant rcx1=null,rcx2=null,bcx1=null,bcx2=null;
	 //士
	 private ChessSolider rcs1=null,rcs2=null,bcs1=null,bcs2=null;
	 //将
	 private ChessGeneral rcj1=null,bcj1=null;
	 //炮
	 private ChessGun rcp1=null,rcp2=null,bcp1=null,bcp2=null;
	 //兵
	 private ChessForce rcz1=null,rcz2=null,rcz3=null,rcz4=null,rcz5=null,bcz1=null,bcz2=null,bcz3=null,bcz4=null,bcz5=null;
	//
	 private Map<String,ChessVehicle> mc=new HashMap<String,ChessVehicle>();
	 private Map<String,ChessElephant> mx=new HashMap<String,ChessElephant>();
	 private Map<String,ChessHorse> mm=new HashMap<String,ChessHorse>();
	 private Map<String,ChessSolider> ms=new HashMap<String,ChessSolider>();
	 private Map<String,ChessGeneral> mj=new HashMap<String,ChessGeneral>();
	 private Map<String,ChessGun> mp=new HashMap<String,ChessGun>();
	 private Map<String,ChessForce> mz=new HashMap<String,ChessForce>();
	 private Map<String,String>mb=new HashMap<String,String>();
	
	 //
	public ChessPanel()
	{
		init_Game();
		
		//鼠标监听器
		addMouseListener(this);
		
	}
	
	
	//面板的绘制
	public void paintComponent(Graphics g)
	{
		
		g.drawImage(boardImage, 0, 0, 507,567,this);
		if(rcv1!=null)
		{
			g.drawImage(rcv1.getImage(),(int)transform.getPhotoxOrg(rcv1.getColumn()),(int)transform.getPhotoyOrg(rcv1.getRow()),this);
		}

		if(rcv2!=null)
		{
			g.drawImage(rcv2.getImage(),(int)transform.getPhotoxOrg(rcv2.getColumn()),(int)transform.getPhotoyOrg(rcv2.getRow()),this);
		}


		if(bcv1!=null)
		{
			g.drawImage(bcv1.getImage(),(int)transform.getPhotoxOrg(bcv1.getColumn()),(int)transform.getPhotoyOrg(bcv1.getRow()),this);
		}


		if(bcv2!=null)
		{
			g.drawImage(bcv2.getImage(),(int)transform.getPhotoxOrg(bcv2.getColumn()),(int)transform.getPhotoyOrg(bcv2.getRow()),this);
		}
		
		//马
		if(rcm1!=null)
		{
			g.drawImage(rcm1.getImage(),(int)transform.getPhotoxOrg(rcm1.getColumn()),(int)transform.getPhotoyOrg(rcm1.getRow()),this);
		}

		if(rcm2!=null)
		{
			g.drawImage(rcm2.getImage(),(int)transform.getPhotoxOrg(rcm2.getColumn()),(int)transform.getPhotoyOrg(rcm2.getRow()),this);
		}


		if(bcm1!=null)
		{
			g.drawImage(bcm1.getImage(),(int)transform.getPhotoxOrg(bcm1.getColumn()),(int)transform.getPhotoyOrg(bcm1.getRow()),this);
		}


		if(bcm2!=null)
		{
			g.drawImage(bcm2.getImage(),(int)transform.getPhotoxOrg(bcm2.getColumn()),(int)transform.getPhotoyOrg(bcm2.getRow()),this);
		}
		//象
		if(rcx1!=null)
		{
			g.drawImage(rcx1.getImage(),(int)transform.getPhotoxOrg(rcx1.getColumn()),(int)transform.getPhotoyOrg(rcx1.getRow()),this);
		}

		if(rcx2!=null)
		{
			g.drawImage(rcx2.getImage(),(int)transform.getPhotoxOrg(rcx2.getColumn()),(int)transform.getPhotoyOrg(rcx2.getRow()),this);
		}


		if(bcx1!=null)
		{
			g.drawImage(bcx1.getImage(),(int)transform.getPhotoxOrg(bcx1.getColumn()),(int)transform.getPhotoyOrg(bcx1.getRow()),this);
		}


		if(bcx2!=null)
		{
			g.drawImage(bcx2.getImage(),(int)transform.getPhotoxOrg(bcx2.getColumn()),(int)transform.getPhotoyOrg(bcx2.getRow()),this);
		}
		
		//士
		if(rcs1!=null)
		{
			g.drawImage(rcs1.getImage(),(int)transform.getPhotoxOrg(rcs1.getColumn()),(int)transform.getPhotoyOrg(rcs1.getRow()),this);
		}

		if(rcs2!=null)
		{
			g.drawImage(rcs2.getImage(),(int)transform.getPhotoxOrg(rcs2.getColumn()),(int)transform.getPhotoyOrg(rcs2.getRow()),this);
		}


		if(bcs1!=null)
		{
			g.drawImage(bcs1.getImage(),(int)transform.getPhotoxOrg(bcs1.getColumn()),(int)transform.getPhotoyOrg(bcs1.getRow()),this);
		}


		if(bcs2!=null)
		{
			g.drawImage(bcs2.getImage(),(int)transform.getPhotoxOrg(bcs2.getColumn()),(int)transform.getPhotoyOrg(bcs2.getRow()),this);
		}
		//将
		if(rcj1!=null)
		{
			g.drawImage(rcj1.getImage(),(int)transform.getPhotoxOrg(rcj1.getColumn()),(int)transform.getPhotoyOrg(rcj1.getRow()),this);
		}

		if(bcj1!=null)
		{
			g.drawImage(bcj1.getImage(),(int)transform.getPhotoxOrg(bcj1.getColumn()),(int)transform.getPhotoyOrg(bcj1.getRow()),this);
		}

		

		//炮
		if(rcp1!=null)
		{
			g.drawImage(rcp1.getImage(),(int)transform.getPhotoxOrg(rcp1.getColumn()),(int)transform.getPhotoyOrg(rcp1.getRow()),this);
		}

		if(rcp2!=null)
		{
			g.drawImage(rcp2.getImage(),(int)transform.getPhotoxOrg(rcp2.getColumn()),(int)transform.getPhotoyOrg(rcp2.getRow()),this);
		}


		if(bcp1!=null)
		{
			g.drawImage(bcp1.getImage(),(int)transform.getPhotoxOrg(bcp1.getColumn()),(int)transform.getPhotoyOrg(bcp1.getRow()),this);
		}


		if(bcp2!=null)
		{
			g.drawImage(bcp2.getImage(),(int)transform.getPhotoxOrg(bcp2.getColumn()),(int)transform.getPhotoyOrg(bcp2.getRow()),this);
		}
		//卒
		if(rcz1!=null)
		{
			g.drawImage(rcz1.getImage(),(int)transform.getPhotoxOrg(rcz1.getColumn()),(int)transform.getPhotoyOrg(rcz1.getRow()),this);
		}

		if(rcz2!=null)
		{
			g.drawImage(rcz2.getImage(),(int)transform.getPhotoxOrg(rcz2.getColumn()),(int)transform.getPhotoyOrg(rcz2.getRow()),this);
		}
		if(rcz3!=null)
		{
			g.drawImage(rcz3.getImage(),(int)transform.getPhotoxOrg(rcz3.getColumn()),(int)transform.getPhotoyOrg(rcz3.getRow()),this);
		}

		if(rcz4!=null)
		{
			g.drawImage(rcz4.getImage(),(int)transform.getPhotoxOrg(rcz4.getColumn()),(int)transform.getPhotoyOrg(rcz4.getRow()),this);
		}

		if(rcz5!=null)
		{
			g.drawImage(rcz5.getImage(),(int)transform.getPhotoxOrg(rcz5.getColumn()),(int)transform.getPhotoyOrg(rcz5.getRow()),this);
		}



		if(bcz1!=null)
		{
			g.drawImage(bcz1.getImage(),(int)transform.getPhotoxOrg(bcz1.getColumn()),(int)transform.getPhotoyOrg(bcz1.getRow()),this);
		}


		if(bcz2!=null)
		{
			g.drawImage(bcz2.getImage(),(int)transform.getPhotoxOrg(bcz2.getColumn()),(int)transform.getPhotoyOrg(bcz2.getRow()),this);
		}
		
		if(bcz3!=null)
		{
			g.drawImage(bcz3.getImage(),(int)transform.getPhotoxOrg(bcz3.getColumn()),(int)transform.getPhotoyOrg(bcz3.getRow()),this);
		}

		if(bcz4!=null)
		{
			g.drawImage(bcz4.getImage(),(int)transform.getPhotoxOrg(bcz4.getColumn()),(int)transform.getPhotoyOrg(bcz4.getRow()),this);
		}

		if(bcz5!=null)
		{
			g.drawImage(bcz5.getImage(),(int)transform.getPhotoxOrg(bcz5.getColumn()),(int)transform.getPhotoyOrg(bcz5.getRow()),this);
		}
//
		if(bkImage!=null)
		{
			g.drawImage(bkImage,(int)transform.getPhotoxOrg(transform.getColumn((double)prvPt.getX())),(int)transform.getPhotoyOrg(transform.getRow((double)prvPt.getY())),this);
		}
		if(rkImage!=null)
		{
			g.drawImage(rkImage,(int)transform.getPhotoxOrg(transform.getColumn((double)prvPt.getX())),(int)transform.getPhotoyOrg(transform.getRow((double)prvPt.getY())),this);
		}

	
		if(nowPt_rk!=null)
		{
			g.drawImage(nrkImage,(int)transform.getPhotoxOrg(transform.getColumn((double)nowPt_rk.getX())),(int)transform.getPhotoyOrg(transform.getRow((double)nowPt_rk.getY())),this);
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
	
		
	}


	@SuppressWarnings("static-access")
	@Override
	public void mousePressed(MouseEvent e) 
	{
		
		if(e.getButton()==e.BUTTON1&&lBool==true&&rBool==false&&total==true)
		{
			clickNumber++;
			nowPt_rk=null;
		
				if(clickNumber==1)
				{
				prvPt=e.getPoint();
				String name=ccd[transform.getRow((double)prvPt.getY())][transform.getColumn((double)prvPt.getX())].getClassName();
				if(name==null||name.contains(tname)==true)
				{
					clickNumber=0;
				}
				else
				{
					bkImage=tool.getImage(mb.get(tname));
				
				}
				}
				
				if(clickNumber==2)
				{
					String name=ccd[transform.getRow((double)prvPt.getY())][transform.getColumn((double)prvPt.getX())].getClassName();
					nowPt=e.getPoint();
					String nowName_same=ccd[transform.getRow((double)nowPt.getY())][transform.getColumn((double)nowPt.getX())].getClassName();
					if(name.equals(nowName_same)==false)
					{
				
					
					moveChess(prvPt,nowPt);
					String nowName=ccd[transform.getRow((double)nowPt.getY())][transform.getColumn((double)nowPt.getX())].getClassName();
					
					if(name.equals(nowName)==true)
					{
						send_prvPt=prvPt;
						send_nowPt=nowPt;
						clickNumber=0;
						bkImage=null;
						lBool=false;
						rBool=true;
						prvPt=null;
						nowPt=null;
					}
					else
					{
					clickNumber=1;
					
					}
					}
					else
					{
						clickNumber=0;
						bkImage=null;
					}
					
				}
			
			
		}
		//***************************************************************************************************
			/*if(e.getButton()==e.BUTTON3&&lBool==false&&rBool==true&&total==true)
			{
				
				clickNumber++;
				//if(lBool==false&&rBool==true&&total==true)
				//{
					if(clickNumber==1)
					{
					prvPt=e.getPoint();
					String name=ccd[transform.getRow((double)prvPt.getY())][transform.getColumn((double)prvPt.getX())].getClassName();
					if(name==null||name.contains("b")==true)
					{
						clickNumber=0;
					}
					else
					{
						rkImage=tool.getImage("E:"+File.separator+"chess\\Rk.png");
					}
					}
					
					if(clickNumber==2)
					{
						String name=ccd[transform.getRow((double)prvPt.getY())][transform.getColumn((double)prvPt.getX())].getClassName();
						nowPt=e.getPoint();
						moveChess(prvPt,nowPt);
						String nowName=ccd[transform.getRow((double)nowPt.getY())][transform.getColumn((double)nowPt.getX())].getClassName();
					
						if(name.equals(nowName)==true)
						{
							clickNumber=0;
							rkImage=null;
							lBool=true;
							rBool=false;
						}
						else
						{
						clickNumber=1;
						
						}
						
					}*/
					
				//}
		//***********************************************************************************************************
		}
		

	
		
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		repaint();
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		// TODO Auto-generated method stub
	
					
				
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
	
		// TODO Auto-generated method stub
		
	}
	//********************************************************
	//游戏初始化
	//*******************************************************
	public void init_Game()
	{
		
				//****************************************
				//加载图片
				//***************************************
				boardImage=tool.getImage("E:"+File.separator+"chess\\chessboard.png");
				bcImage=tool.getImage("E:"+File.separator+"chess\\Bc.png");
				rcImage=tool.getImage("E:"+File.separator+"chess\\Rc.png");
				bmImage=tool.getImage("E:"+File.separator+"chess\\Bm.png");
				rmImage=tool.getImage("E:"+File.separator+"chess\\Rm.png");
				bxImage=tool.getImage("E:"+File.separator+"chess\\Bx.png");
				rxImage=tool.getImage("E:"+File.separator+"chess\\Rx.png");
				bsImage=tool.getImage("E:"+File.separator+"chess\\Bs.png");
				rsImage=tool.getImage("E:"+File.separator+"chess\\Rs.png");
				bjImage=tool.getImage("E:"+File.separator+"chess\\Bj.png");
				rjImage=tool.getImage("E:"+File.separator+"chess\\Rj.png");
				bpImage=tool.getImage("E:"+File.separator+"chess\\Bp.png");
				rpImage=tool.getImage("E:"+File.separator+"chess\\Rp.png");
				bzImage=tool.getImage("E:"+File.separator+"chess\\Bz.png");
				rzImage=tool.getImage("E:"+File.separator+"chess\\Rz.png");
				
				//*****************************************************
				//棋盘的初始化
				//************************************************
				for(int j=0;j<9;j++)
				{
					if(j==1||j==7)
					{
					ccd[2][1]=new ChessCoordinate(1,1,blackChess[9]);
					ccd[2][7]=new ChessCoordinate(1,1,blackChess[10]);
					ccd[7][1]=new ChessCoordinate(1,0,redChess[9]);
					ccd[7][7]=new ChessCoordinate(1,0,redChess[10]);
					}
					else
					{
						ccd[2][j]=new ChessCoordinate(0,-1,null);
						ccd[7][j]=new ChessCoordinate(0,-1,null);
					}
					
				}
				
				for(int j=0;j<9;j++)
				{
					ccd[0][j]=new ChessCoordinate(1,1,blackChess[j]);
					ccd[9][j]=new ChessCoordinate(1,0,redChess[j]);
					ccd[1][j]=new ChessCoordinate(0,-1,null);
					ccd[8][j]=new ChessCoordinate(0,-1,null);
					ccd[4][j]=new ChessCoordinate(0,-1,null);
					ccd[5][j]=new ChessCoordinate(0,-1,null);
				}
				int n=10;
				int m=10;
				for(int j=0;j<9;j++)
				{
					if(j%2==0)
					{
						
						ccd[3][j]=new ChessCoordinate(1,1,blackChess[++n]);
						ccd[6][j]=new ChessCoordinate(1,0,redChess[++m]);
					}else
					{
						ccd[3][j]=new ChessCoordinate(0,-1,null);
						ccd[6][j]=new ChessCoordinate(0,-1,null);
					}
					
				}
			
				//**********************************************************
				//车
				rcv1=new ChessVehicle(rkImage,rcImage,9,0,0,redChess[0]);
				rcv2=new ChessVehicle(rkImage,rcImage,9,8,0,redChess[8]);
				bcv1=new ChessVehicle(bkImage,bcImage,0,0,1,blackChess[0]);
				bcv2=new ChessVehicle(bkImage,bcImage,0,8,1,blackChess[8]);
				//马
				rcm1=new ChessHorse(rkImage,rmImage,9,1,0,redChess[1]);
				rcm2=new ChessHorse(rkImage,rmImage,9,7,0,redChess[7]);
				bcm1=new ChessHorse(bkImage,bmImage,0,1,1,blackChess[1]);
				bcm2=new ChessHorse(bkImage,bmImage,0,7,1,blackChess[7]);
				//象
				rcx1=new ChessElephant(rkImage,rxImage,9,2,0,redChess[2]);
				rcx2=new  ChessElephant(rkImage,rxImage,9,6,0,redChess[6]);
				bcx1=new ChessElephant(bkImage,bxImage,0,2,1,blackChess[2]);
				bcx2=new  ChessElephant(bkImage,bxImage,0,6,1,blackChess[6]);
				
				//士
				rcs1=new ChessSolider(rkImage,rsImage,9,3,0,redChess[3]);
				rcs2=new ChessSolider(rkImage,rsImage,9,5,0,redChess[5]);
				bcs1=new ChessSolider(bkImage,bsImage,0,3,1,blackChess[3]);
				bcs2=new  ChessSolider(bkImage,bsImage,0,5,1,blackChess[5]);
				
				//将
				rcj1=new ChessGeneral(rkImage,rjImage,9,4,0,redChess[4]);
				bcj1=new ChessGeneral(bkImage,bjImage,0,4,1,blackChess[4]);
				//炮
				rcp1=new ChessGun(rkImage,rpImage,7,1,0,redChess[9]);
				rcp2=new ChessGun(rkImage,rpImage,7,7,0,redChess[10]);
				bcp1=new ChessGun(bkImage,bpImage,2,1,1,blackChess[9]);
				bcp2=new ChessGun(bkImage,bpImage,2,7,1,blackChess[10]);
				//兵
				rcz1=new ChessForce(rkImage,rzImage,6,0,0,redChess[11]);
				rcz2=new ChessForce(rkImage,rzImage,6,2,0,redChess[12]);
				rcz3=new ChessForce(rkImage,rzImage,6,4,0,redChess[13]);
				rcz4=new ChessForce(rkImage,rzImage,6,6,0,redChess[14]);
				rcz5=new ChessForce(rkImage,rzImage,6,8,0,redChess[15]);
				bcz1=new ChessForce(bkImage,bzImage,3,0,1,blackChess[11]);
				bcz2=new ChessForce(bkImage,bzImage,3,2,1,blackChess[12]);
				bcz3=new ChessForce(bkImage,bzImage,3,4,1,blackChess[13]);
				bcz4=new ChessForce(bkImage,bzImage,3,6,1,blackChess[14]);
				bcz5=new ChessForce(bkImage,bzImage,3,8,1,blackChess[15]);
				//System.out.println(transform.getPhotoxOrg(rcv1.getRow()));
				//
				//车
				mc.put(redChess[0],rcv1);
				mc.put( redChess[8],rcv2);
				mc.put( blackChess[0],bcv1);
				mc.put(blackChess[8],bcv2);
				//马
				mm.put(redChess[1], rcm1);
				mm.put(redChess[7], rcm2);
				mm.put(blackChess[1], bcm1);
				mm.put(blackChess[7], bcm2);
				//象
				mx.put(redChess[2], rcx1);
				mx.put(redChess[6], rcx2);
				mx.put(blackChess[2], bcx1);
				mx.put(blackChess[6], bcx2);
				//士
				ms.put(redChess[3], rcs1);
				ms.put(redChess[5], rcs2);
				ms.put(blackChess[3], bcs1);
				ms.put(blackChess[5], bcs2);
				//将
				mj.put(redChess[4], rcj1);
				mj.put(blackChess[4], bcj1);
				//炮
				mp.put(redChess[9], rcp1);
				mp.put(redChess[10], rcp2);
				mp.put(blackChess[9], bcp1);
				mp.put(blackChess[10], bcp2);
				//兵
				mz.put(redChess[11], rcz1);
				mz.put(redChess[12], rcz2);
				mz.put(redChess[13], rcz3);
				mz.put(redChess[14], rcz4);
				mz.put(redChess[15], rcz5);
				mz.put(blackChess[11], bcz1);
				mz.put(blackChess[12], bcz2);
				mz.put(blackChess[13], bcz3);
				mz.put(blackChess[14], bcz4);
				mz.put(blackChess[15], bcz5);
				//背景图片
				mb.put("r","E:"+File.separator+"chess\\Bk.png");
				mb.put("b","E:"+File.separator+"chess\\Rk.png");
				
	}
	//********************************************************
	//棋子的走法
	//*******************************************************
	 public void moveChess(Point2D prvPt,Point2D nowPt)
	 {
			String name=ccd[transform.getRow((double)prvPt.getY())][transform.getColumn((double)prvPt.getX())].getClassName();
			String temp=name.substring(1,2);
			switch(temp)
			{
			case "c":
				mc.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(mc.get(name).getPreName());
			
				break;
			case "m":
				mm.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(mm.get(name).getPreName());
				break;
			case"x":
				mx.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(mx.get(name).getPreName());
			
				break;
			case "s":
				ms.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(ms.get(name).getPreName());
			
				break;
			case "j":
				mj.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(mj.get(name).getPreName());
			
				break;
			case "p":
				mp.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(mp.get(name).getPreName());
			
				break;
			case "z":
				mz.get(name).ChessMove(ccd,transform.getRow((double)prvPt.getY()),transform.getColumn((double)prvPt.getX()),transform.getRow((double)nowPt.getY()),transform.getColumn((double)nowPt.getX()));
				DeleteChess(mz.get(name).getPreName());
				break;
			}
		 
	 }
	//********************************************************
	//棋子被吃后，吃的棋子不会被显示
	//*******************************************************
	 public void DeleteChess(String name)
	 {
		if(name!=null)
		{
		String temp=name.substring(1,2);
	
		switch(temp)
		{
		case "c":
			if(mc.get(name).equals(rcv1))	rcv1=null;
			if(mc.get(name).equals(rcv2))	rcv2=null;
			if(mc.get(name).equals(bcv1))	bcv1=null;
			if(mc.get(name).equals(bcv2))	bcv2=null;
		break;
		case "m":
			if(mm.get(name).equals(rcm1))	rcm1=null;
			if(mm.get(name).equals(rcm2))	rcm2=null;
			if(mm.get(name).equals(bcm1))	bcm1=null;
			if(mm.get(name).equals(bcm2))	bcm2=null;
			break;
		case"x":
			if(mx.get(name).equals(rcx1))	rcx1=null;
			if(mx.get(name).equals(rcx2))	rcx2=null;
			if(mx.get(name).equals(bcx1))	bcx1=null;
			if(mx.get(name).equals(bcx2))	bcx2=null;
			break;
		case "s":
			if(ms.get(name).equals(rcs1))	rcs1=null;
			if(ms.get(name).equals(rcs2))	rcs2=null;
			if(ms.get(name).equals(bcs1))	bcs1=null;
			if(ms.get(name).equals(bcs2))	bcs2=null;
			break;
		case "j":
			if(mj.get(name).equals(rcj1))	rcj1=null;
			if(mj.get(name).equals(bcj1))	bcj1=null;
			
			break;
		case "p":
			if(mp.get(name).equals(rcp1))	rcp1=null;
			if(mp.get(name).equals(rcp2))	rcp2=null;
			if(mp.get(name).equals(bcp1))	bcp1=null;
			if(mp.get(name).equals(bcp2))	bcp2=null;
			break;
		case "z":
			if(mz.get(name).equals(rcz1))	rcz1=null;
			if(mz.get(name).equals(rcz2))	rcz2=null;
			if(mz.get(name).equals(rcz3))	rcz3=null;
			if(mz.get(name).equals(rcz4))	rcz4=null;
			if(mz.get(name).equals(rcz5))	rcz5=null;
			if(mz.get(name).equals(bcz1))	bcz1=null;
			if(mz.get(name).equals(bcz2))	bcz2=null;
			if(mz.get(name).equals(bcz3))	bcz3=null;
			if(mz.get(name).equals(bcz4))	bcz4=null;
			if(mz.get(name).equals(bcz5))	bcz5=null;
		
			break;
		}
		if(name.equals("rj"))
		{
			JOptionPane.showMessageDialog(null, "黑方胜");
			repaint();
			total=false;
		}
		if(name.equals("bj"))
		{
			JOptionPane.showMessageDialog(null, "红方胜");
			repaint();
			total=false;
		}
	
		}
	}
	
	//********************************
	//设置一些按键的状态
	//********************************
	public void setState(boolean lButton,boolean total,boolean rButton,String type,String type1)
	{
		this.lBool=lButton;
		
		this.total=total;
		this.rBool=rButton;
		this.tname=type;
		this.tname1=type1;
	}
//*********************
	//更新面板
	//**********************
	public void UpdatePanel()
	{
		repaint();
	}
	//********************************
	//接受的棋子
	//***********************************
	public void UpdateChess(Point2D pt1,Point2D pt2)
	{
		if(lBool==false&&rBool==true&&total==true)
		{
			
			
					prvPt=pt1;
					nowPt=pt2;
					//走完棋子后的标志
					nrkImage=tool.getImage(mb.get(tname1));
					nowPt_rk=nowPt;
				
					String name=ccd[transform.getRow((double)prvPt.getY())][transform.getColumn((double)prvPt.getX())].getClassName();
					moveChess(prvPt,nowPt);
					String nowName=ccd[transform.getRow((double)nowPt.getY())][transform.getColumn((double)nowPt.getX())].getClassName();
					if(name.equals(nowName)==true)
					{
						clickNumber=0;
						rkImage=null;
						lBool=true;
						rBool=false;
						prvPt=null;
						nowPt=null;
						send_prvPt=null;
						send_nowPt=null;
					}
					
				}
	
	}
	//
	public boolean getTotal()
	{
		return total;
	}
	//********************
	//得到发送的坐标
	//******************
	public Point2D[]  getSendPt()
	{
		Point2D[] pt= {send_prvPt,send_nowPt};
		return pt;
	}
	
	
}
