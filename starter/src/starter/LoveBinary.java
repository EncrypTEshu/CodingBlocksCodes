package starter;
import java.util.*;
public class LoveBinary{
	static void bin(int n){
		int num=n,counter=0;
		double dec=0.0;
		while(num>0){
			counter++;
			num=num/10;
		}
		for(double i=0.0;i<=counter;i++){
			int p=n%10;
			if(p==1)
			{
				dec=dec+(Math.pow(2.0,i));
			}
			n=n/10;
		}
		System.out.println((int)dec);
	}
    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		int binar=0;
		while(n>0){
			 binar=sc.nextInt();
			bin(binar);
			n--;
		}
    }
}