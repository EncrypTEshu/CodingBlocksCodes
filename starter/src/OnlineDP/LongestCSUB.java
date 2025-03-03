package OnlineDP;

public class LongestCSUB {

	public static long start;
	public static long end;

	public static void startalgo() {
		start = System.currentTimeMillis();
	}

	public static long endalgo() {
		end = System.currentTimeMillis();
		return end - start;
	}

	public static void main(String[] args) {
		String str="cbbgdsafjadfkljasdfksdf";
		String str1="agbgksdfldfldskfdsjfafdkal";
		startalgo();
		System.out.println(LcsIS(str,str1));
		System.out.println("Time taken by normal recursion " + endalgo()+ " ms");
		startalgo();
		System.out.println(Lcs(str,str1));
		System.out.println("Time taken by normal recursion " + endalgo()+ " ms");
	

	}
	public static long Lcs(String str,String str2) {
	   if(str.length()==0|| str2.length()==0) {
		   return 0;
	   }
		char ch=str.charAt(0);
		char ch2=str2.charAt(0);
		String ros=str.substring(1);
		String ros1=str2.substring(1);
		long count=0;
		if(ch==ch2) {
			count=1+Lcs(ros, ros1);
		}
		else {
			long f1=Lcs(str, ros1);
			long f2=Lcs(ros, str2);
			count=Math.max(f1, f2);
		}
		return count;
}
	public static int LcsIS(String str,String str2) {
		int arr[][]=new int[str.length()+1][str2.length()+1];
		
		//seeding
		for(int j=0;j<str2.length();j++) {
			 arr[str.length()-1][j]=0;
		}
		for(int j=0;j<str.length();j++) {
			 arr[j][str2.length()]=0;
		}
		for(int i=str.length()-1;i>=0;i--) {
			for(int j=str.length()-1;j>=0;j--) {
				if(str.charAt(i)==str2.charAt(j)) {
					arr[i][j]=1+arr[i+1][j+1];
				}
				else {
					arr[i][j]=Math.max(arr[i+1][j], arr[i][j+1]);
				}
			}
			}
		return arr[0][0];
		}
	

}