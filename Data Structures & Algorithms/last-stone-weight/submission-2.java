class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

        for(int stone: stones){
            maxHeap.offer(stone);
        }

        while(maxHeap.size() >= 2){
            int heaviest = maxHeap.poll();
            int heavier = maxHeap.poll();

            if(heaviest - heavier >= 1){
                maxHeap.offer(heaviest - heavier);
            }
        }

        return maxHeap.size() == 1 ? maxHeap.peek() : 0;
    }
}
