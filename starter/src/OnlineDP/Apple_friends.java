package OnlineDP;
import java.util.*;
public class Apple_friends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
		arr[i]=sc.nextInt();
		}
		System.out.println(priceApple(arr, arr.length-1));
		
	}
	public static int priceApple(int arr[],int index) {
		if(index==0) {
			return -1;
		}
		int ans=0;
		if(arr[index]==5) {
			ans=index;
		}
		priceApple(arr, index-1);
		
		return ans+1;
	}
}
