package OnlineDP;

public class EditedDistance {
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
		// TODO Auto-generated method stub
		String str="agbg";
		String str1="acgb";
		startalgo();
		System.out.println(EditedDistanceI(str,str1));
		System.out.println("Time taken by normal recursion " + endalgo()+ " ms");
		startalgo();
	}
	public static int EditedDistance(String str,String str2 ) {
		if(str.length()==0) {
			return str2.length();
		}
		if(str2.length()==0) {
			return str.length();
		}
		String ros=str.substring(1);
		String ros1=str2.substring(1);
		
		int ans=0;
		
		if(str.charAt(0)==str2.charAt(0)) {
			ans=EditedDistance(ros, ros1);
		}
		else {
			int f1=1+EditedDistance(ros, ros1);
			int f2=1+EditedDistance(str, ros1);
			int f3=1+EditedDistance(str2, ros);
			ans=Math.min(f1,Math.min(f2, f3));
		}
		return ans;
	}
	public static int EditedDistanceI(String str,String str2 ) {
	int l=str.length();
	int l2=str2.length();
	int[][] strg=new int[str.length()+1][str2.length()+1];
			
		strg[str.length()][l2]=0;
		
		for(int i=str.length();i>=0;i--) {
			for(int j=str2.length();j>=0;j--) {
				if(i==str.length()) {
					strg[i][j]=str2.length()-j;
					continue;
				}
				if(j==str2.length()) {
					strg[i][j]=str.length()-i;
					continue;
				}
				if(str.charAt(i)==str2.charAt(j)) {
					strg[i][j]=strg[i+1][j+1];
				}
				else {
					strg[i][j]=1+Math.min(strg[i+1][j+1], Math.min(strg[i+1][j], strg[i][j+1]));
				}
				
			}
		
		}
		return strg[0][0];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
