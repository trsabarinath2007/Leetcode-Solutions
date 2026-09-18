class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        Set<String>set=new HashSet<>(wordDict);
        List<String>[]dp=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=new ArrayList<>();
        }
        dp[0].add("");
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String word=s.substring(j,i);
                if(set.contains(word)){
                    for(String prev:dp[j]){
                        if(prev.equals("")){
                            dp[i].add(word);
                        }else{
                            dp[i].add(prev+" "+word);
                        }
                    }
                }
            }
        }
        return dp[n];
    }
}