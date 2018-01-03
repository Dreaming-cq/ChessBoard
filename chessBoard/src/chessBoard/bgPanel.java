package chessBoard;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class bgPanel extends JComponent
{

	private int xOrg;
	private int yOrg;
	private int width;
	private int height;
	private Image image;
	private String imagePath;
	private Toolkit tool;
//给变量赋值
	public void setPath(String aPath,int axOrg,int ayOrg,int awidth,int aheight)
	{
		this.xOrg=axOrg;
		this.yOrg=ayOrg;
		this.width=awidth;
		this.height=aheight;
		this.imagePath=aPath;
		tool=Toolkit.getDefaultToolkit();
		image=tool.getImage(imagePath);
	}
	//
	public void paintComponent(Graphics g)
	{
		
		g.drawImage(image, xOrg, yOrg,width,height,this);
		
	}

}
