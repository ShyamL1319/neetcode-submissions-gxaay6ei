class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use a Max-Heap (compare p2 distance to p1 distance)
        // We avoid Math.sqrt() because x^2 + y^2 is sufficient for comparison
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> 
            Integer.compare((p2[0] * p2[0] + p2[1] * p2[1]), 
                            (p1[0] * p1[0] + p1[1] * p1[1]))
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            // If we exceed K, remove the furthest point (the "max" in our Max-Heap)
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Prepare the result array
        int[][] res = new int[k][2];
        while (k > 0) {
            res[--k] = maxHeap.poll();
        }

        return res;
    }
}