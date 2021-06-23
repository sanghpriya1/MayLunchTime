import java.util.Scanner;

public class TomNJerry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int a = 0; 
			int b = 0; 
			for(int i = 0; i < K; i++) {
				a += sc.nextInt();
				b += sc.nextInt();
			}
			b += sc.nextInt();
			System.out.println(Math.max(a, b));
		}
		sc.close();
		
	}

}
