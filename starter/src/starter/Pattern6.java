package starter;

import java.util.Scanner;

public class Pattern6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int n=sc.nextInt();
		int a=n*2-1;
		int sp=0,kp=a-1;
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<i;j++)
			{
				System.out.print(" ");
			}
			System.out.print(i); 
			for(int k=(a-sp);k>=1;k--)
			{
				System.out.print(" ");
			}
			sp=sp+2;
			if(i<n)
			System.out.print(i);
			System.out.println();
			
		}
		for(int x=n-1;x>=1;x--) {
			for(int z=1;z<x;z++) {
				System.out.print(" ");
		}
			System.out.print(x);
			for(int l=a-kp;l>=1;l--) {
				System.out.print(" ");
			}
			kp-=2;
			if(x<n) {
				System.out.print(x);
			}
			System.out.println();
		
	}

}
}