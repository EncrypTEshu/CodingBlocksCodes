package starter;

import java.util.Scanner;

public class Candy {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0){
			int n=sc.nextInt();
		int i=2;
		while(n>0){
			
			if(prime(i)==true){
				n--;
			}
			i=i+1;

		}
		System.out.println(i-1);
		t--;
		}
	}
	public static boolean prime(int n){
		
		for(int i=2;i*i<=n;i++){
			if(n%i==0){
				return false;
			}
		}
	
		return true;
	}
	

}
