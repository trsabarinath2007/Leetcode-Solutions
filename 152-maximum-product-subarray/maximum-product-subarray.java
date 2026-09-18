/**class Solution {
    public int maxProduct(int[] nums) {
       int max=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
        int sum=1;
        for(int j=i;j<nums.length;j++){
            sum=sum*nums[j];
            max=Math.max(max,sum);
        }
       }
       return max; 
    }
}**/
class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int[]max=new int[n];
        int[]min=new int[n];
        max[0]=nums[0];
        min[0]=nums[0];
        int ans=nums[0];
        for(int i=1;i<n;i++){
            int num=nums[i];
            int a=num;
            int b=num*max[i-1];
            int c=num*min[i-1];
            max[i]=Math.max(a,Math.max(b,c));
            min[i]=Math.min(a,Math.min(b,c));
           ans=Math.max(ans,max[i]);

        }
        return ans;
    }

    }