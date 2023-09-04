package array_string;

public class Medium_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGain = 0;
        int startPoint = 0;
        int curr = 0;

        for (int i = 0; i < gas.length; i += 1) {
            totalGain += gas[i] - cost[i];
            curr += gas[i] - cost[i];

            if (curr < 0) {
                startPoint = i + 1;
                curr = 0;
            }
        }

        if (totalGain >= 0) {
            return startPoint;
        }

        return -1;
    }
}
