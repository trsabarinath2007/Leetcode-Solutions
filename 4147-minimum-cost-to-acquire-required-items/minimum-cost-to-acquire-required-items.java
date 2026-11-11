class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1;
        long c2 = cost2;
        long cb = costBoth;
        long n1 = need1;
        long n2 = need2;
        
        long totalCost = 0;
        
        // Step 1: Use type 3 items to cover both requirements as much as possible, 
        // considering if buying type 3 is cheaper than buying type 1 and type 2 separately.
        long common = Math.min(n1, n2);
        if (cb < c1 + c2) {
            totalCost += common * cb;
            n1 -= common;
            n2 -= common;
        } else {
            // If type 3 is more expensive than type 1 + type 2 combined, 
            // we can cover the common part using type 1 and type 2 individually.
            totalCost += common * (c1 + c2);
            n1 -= common;
            n2 -= common;
        }
        
        // Step 2: For the remaining need1, use the cheaper option between type 1 and type 3
        if (n1 > 0) {
            totalCost += n1 * Math.min(c1, cb);
        }
        
        // Step 3: For the remaining need2, use the cheaper option between type 2 and type 3
        if (n2 > 0) {
            totalCost += n2 * Math.min(c2, cb);
        }
        
        return totalCost;
    }
}