package org.sp.app0710.graphic2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	int x=0;
	int y=0;
	int index;
	
	Toolkit kit=Toolkit.getDefaultToolkit(); //static 클래스이므로 .찍고 접근
	Image[] image = new Image[10]; //추상클래스 중 java가 이미 자동으로 생성해준 인스턴스를 활용하는 게 효율적인 방법.
	
	public MyPanel() {
		for(int i=0; i<image.length; i++) {
			image[i]=kit.getImage("D:\\morning\\javase_workspace\\app0710\\res\\hero\\Attack__00"+i+".png");	
		}
	}
	
	public void tick() {
		x+=5;
		y+=5;
	}
	
	public void paint(Graphics g) {
		System.out.println("paint() 호출");
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 700, 650); //700x700 사각형 채움
		
		g.setColor(Color.GREEN);
		g.fillOval(x, y, 40, 40);
		
		//이미지 그리기
		//이미지 인스턴스를 얻어오는 방법은 여러 가지가 있다.
		//1) Toolkit을 이용하는 방법 (해당 OS에 의존적인 경로로 이미지를 얻는 방법)
		g.drawImage(image[index], 20, 30, 100, 150, this);			
		
	}
	
}
