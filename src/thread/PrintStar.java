package thread;

public class PrintStar {
	public static void main(String[] args) {
		//하나의 프로세스 내에서 독립적으로 실행될 수 있는 세부실행단위를 가리켜 thread 쓰레드라 부른다.
		
		MyThread mt1=new MyThread(); //별도의 실행부 생성
		mt1.start(); //run() 을 간접 호출
		
		MyThread2 mt2=new MyThread2(); //별도의 실행부 생성
		mt2.start(); //run() 을 간접 호출
		
		System.out.println("메인 메서드에 의한 코드");
	}
}
