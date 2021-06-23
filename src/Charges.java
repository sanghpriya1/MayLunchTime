import java.util.Scanner;

public class Charges {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0) {
			int N = sc.nextInt();
			int k = sc.nextInt();
			String S = sc.next();
			
			int[] p = new int[N];
			for(int i= 0; i < N; i++) {
				p[i] = S.charAt(i)-'0';
			}
			int weight = 0;
			for(int i = 0; i < N-1; i++ ) {
				if(p[i] == p[i+1]) weight += 2;
				else weight += 1;
			}
			while(k-- > 0) {
				
				
				int Q = sc.nextInt();
				if(Q == 1) {
					if(p[0] == p[1]) {
						weight -=1;
						int x = p[0];
						if(x == 0)
						p[0] = 1;
						else if(x == 1)
						p[0] = 0;
					}
					else {
						weight += 1;
						int x = p[0];
						if(x == 0)
						p[0] = 1;
						else if(x == 1)
						p[0] = 0;
					}
				}
				else if((Q == N)) {
					if(p[N-1] == p[N-2]) {
						weight -=1;
						int x = p[N-1];
						if(x == 0)
						p[N-1] = 1;
						else if(x == 1)
							p[Q-1] = 0;
					}
					else {
						weight += 1;
						int x = p[N-1];
						if(x == 0)
						p[N-1] = 1;
						else if(x == 1)
							p[Q-1] = 0;
					}
				}
				else {
					if((p[Q-1] == p[Q-2]) 
							&& (p[Q-1] == p[Q]) ) {
						weight -= 2;
						int x = p[Q-1];
						if(x == 0)
					p[Q-1] = 1;
						else if(x == 1)
							p[Q-1] = 0;
					}
					else if((p[Q-1] != p[Q-2]) 
							&& (p[Q-1] != p[Q]) ) {
						weight += 2;
						int x = p[Q-1];
						if(x == 0)
					p[Q-1] = 1;
						else if(x == 1)
							p[Q-1] = 0;
					}
					
				}
				System.out.println(weight);
			}
			
		}
		sc.close();
	}

}
