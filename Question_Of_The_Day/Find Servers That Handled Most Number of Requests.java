class Solution {
    
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        TreeSet<Integer> availableServers = new TreeSet<>();

        for(int i=0;i<k;i++){
            availableServers.add(i);
        }
        int[] usageCount = new int[k];
        int maxReqs=0;

        for(int i =0;i<arrival.length;i++){
            int cl = arrival[i]+load[i];
            while(!queue.isEmpty() && queue.peek()[0]<=arrival[i]){
               availableServers.add(queue.poll()[1]);
            }
            if(availableServers.isEmpty())
                continue;
            Integer serverIndex = availableServers.ceiling(i%k);
            if(serverIndex==null){
                serverIndex = availableServers.first();
            }

            queue.offer(new int[]{cl,serverIndex});
            availableServers.remove(serverIndex);
            usageCount[serverIndex]++;
            maxReqs=Math.max(usageCount[serverIndex],maxReqs);
        }
        List<Integer> busiestServers = new ArrayList<>();
        int c=0;
        for(int useCount:usageCount){

            if(useCount==maxReqs){
                busiestServers.add(c);
            }
            c++;
        }
        return busiestServers;
    }
}
