package org.sp.app0710.graphic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

/*
 * 자바의 모든 GUI 컴포넌트는 사실 스스로를 그려낸다.
 * 
 * 			 현실				자바
 * 주체:	 화가				컴포넌트
 * 대상:	 캔버스				컴포넌트
 * 행위:	 붓					paint() 메서드
 * 스타일: 팔레트				paint(Graphics g) paint()메서드의 매개변수 Graphics (현실에서의 팔레트보다 훨씬 다양한 기능을 지원한다)
 * 
 *컴포넌트 스스로 그려내는 행위를 개발자가 가져와 직접 하기 -> 메서드를 오버라이드 하면 개발자가 직접 정의하는 것.
 *java 컴포넌트 중 그림을 그리기 적당한 컴포넌트가 있다면 컨테이너 류. JPane, JFrame.. 하지만 일반 컴포넌트 중 Canvas 도 그림 그리기 적당하다.
 */

//모든 컴포넌트가 보유한 paint() 메서드를 뺏어서 개발자가 주도하여 그림을 그려본다.
//-> repaitnt() 메서드를 오버라이드 하자
public class CustomButton extends JButton{

	public CustomButton(String title) {
		super(title);
		this.setPreferredSize(new Dimension(200, 200));
	}
	
	public void paint(Graphics g) {
		//System.out.println("오버라이드하기");
		//paint 메서드는 Graphics 객체를 사용하기 위한 코드 영역일 뿐, 사실 대부분의 그림은 Graphics 객체가 담당한다.
		
		//그래픽스 객체의 페이늩 통의 색상을 변경
		g.setColor(Color.ORANGE);
		
		//채워진 사각형을 그린다
		g.fillRect(0, 0, 200, 200);
		
		
	}
}
