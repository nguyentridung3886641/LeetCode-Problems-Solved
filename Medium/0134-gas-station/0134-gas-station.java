class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int stations = gas.length;

        int totalDiff = 0, startIndex = 0, currentTank = 0;
        for (int i = 0; i < stations; i++) {
            if (currentTank < 0) {
                startIndex = i;
                currentTank = 0;
            }

            totalDiff += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
        }
        if (totalDiff < 0) return -1;
        
        return startIndex;
    }
}