package org.sp.app0710.graphic;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	CustomButton bt;
	
	public MyFrame() {
		bt = new CustomButton("나버튼");
		setLayout(new FlowLayout());
		
		add(bt);
		
		setSize(300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
}
