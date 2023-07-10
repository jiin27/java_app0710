package org.sp.app0710.graphic2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	JButton bt;
	JButton bt2;
	
	//MyPanel p;
	JPanel p;
	int x=0;
	int y=0;
	int index;

	Toolkit kit=Toolkit.getDefaultToolkit(); //static 클래스이므로 .찍고 접근
	Image[] image = new Image[10]; //추상클래스 중 java가 이미 자동으로 생성해준 인스턴스를 활용하는 게 효율적인 방법.
	
	public MainFrame() {
		bt = new JButton("이동");
		bt2 = new JButton("이미지프레임");
		
		for(int i=0; i<image.length; i++) {
			image[i]=kit.getImage("D:\\morning\\javase_workspace\\app0710\\res\\hero\\Attack__00"+i+".png");	
		}

		p = new JPanel() {
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
		};

		setLayout(new FlowLayout());
		
		p.setPreferredSize(new Dimension(700, 650));

		add(bt);
		add(bt2);
		add(p);
		
		setSize(700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//버튼과 리스너 연결
		bt.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	public void tick() {
		x+=5;
		y+=5;
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == bt) {
			//버튼을 누르면, 패널이 보유한 x, y 변수 값을 변경하자
			tick();
			
			//버튼만 눌러서는 화면에 그래픽적인 변화가 없으므로 즉 다시 그려질 필요가 없었으므로
			//paint() 메서드가 호출되지 않는다.
			//따라서 버튼만 눌러서 그림을 다시 그리는 효과를 내려면, 시스템에게 paint()메서드를 호출하도록 요청해야 하는데,
			//이때 사용되는 메서드가 바로 repaint() 메서드이다.
			//repaint() --> update() : 기존 그림 싹 지우기 --> paint() 호출됨. 즉, 그림을 지워서 자동적으로 간접적으로 paint()를 호출하는 것.
			p.repaint();	
		}else if(obj == bt2) {
			index++;
			p.repaint();
			if(index>=image.length-1) {
				index=0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
