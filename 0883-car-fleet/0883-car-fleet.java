class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Step 1: Pair up position and speed
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i]; // time = distance / speed
        }

        // Step 2: Sort by position descending (farthest from target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // Step 3: Count fleets using stack-style approach
        int fleets = 0;
        double prevTime = 0.0;

        for (int i = 0; i < n; i++) {
            double currTime = cars[i][1];
            if (currTime > prevTime) {
                fleets++;
                prevTime = currTime;
            }
            // else: car joins fleet ahead of it
        }

        return fleets;
    }
}
