import java.util.*;

class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // Min-heap to store busy servers: stores int[] {endTime, serverId}
        PriorityQueue<int[]> busyServers = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // TreeSet to store currently available server IDs in sorted order
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }
        
        int[] requestCount = new int[k];
        int maxRequests = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            int currTime = arrival[i];
            int duration = load[i];
            
            // Free up servers whose tasks have finished by the current arrival time
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= currTime) {
                availableServers.add(busyServers.poll()[1]);
            }
            
            // If no servers are available, drop this request
            if (availableServers.isEmpty()) {
                continue;
            }
            
            // Find the preferred server index: (i % k)
            int preferred = i % k;
            
            // Use TreeSet ceiling to find the first available server >= preferred
            Integer assignedServer = availableServers.ceiling(preferred);
            
            // If none found >= preferred, wrap around and take the lowest available server ID >= 0
            if (assignedServer == null) {
                assignedServer = availableServers.first();
            }
            
            // Assign the request to this server
            availableServers.remove(assignedServer);
            busyServers.offer(new int[] { currTime + duration, assignedServer });
            
            requestCount[assignedServer]++;
            maxRequests = Math.max(maxRequests, requestCount[assignedServer]);
        }
        
        // Collect all servers that handled the maximum number of requests
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (requestCount[i] == maxRequests) {
                result.add(i);
            }
        }
        
        return result;
    }
}