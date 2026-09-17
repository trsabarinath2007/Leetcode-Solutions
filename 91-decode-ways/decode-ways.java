/**class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

           
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));

            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}**/
class Solution{
    public int decode(int i,String s,int[]dp){
        if(i==s.length())
        return 1;
        if(s.charAt(i)=='0')
        return 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        int one=decode(i+1,s,dp);
        int two=0;
        if(i+1<s.length()){
            int num=Integer.parseInt(s.substring(i,i+2));
            if(num>=10 &&num<=26){
                two=decode(i+2,s,dp);
            }
        }
        dp[i]=one+two;
        return dp[i];
    }
    public int numDecodings(String s){
        int[]dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(0,s,dp);
    }
}