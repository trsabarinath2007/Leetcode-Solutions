class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,n,m,dp);
    }
    public static int solve(String word1,String word2,int i,int j,int[][]dp){
        if(i==0){
            return j;
        }
        if(j==0){
            return i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(word1.charAt(i-1)==word2.charAt(j-1)){
            dp[i][j]=solve(word1,word2,i-1,j-1,dp);
        }else{
            int delete=solve(word1,word2,i-1,j,dp);
            int insert=solve(word1,word2,i,j-1,dp);
            int replace=solve(word1,word2,i-1,j-1,dp);
            dp[i][j]=1+Math.min(delete,Math.min(insert,replace));
        }
        return dp[i][j];
    }
}