class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] tasksFreq = new int[26];
        int maxFreq = 0, maxFreqIdx = 0;
        for (int i = 0; i < tasks.length; i++) {
            ++tasksFreq[tasks[i] - 'A'];
        }

        for (int i = 0; i < 26; i++) {
            if (tasksFreq[i] > maxFreq) {
                maxFreq = tasksFreq[i];
                maxFreqIdx = i;
            }
        }

        tasksFreq[maxFreqIdx] = 0;
        int idleSlots = n * (maxFreq - 1);
        for (int i = 0; i < 26; i++) {
            idleSlots = idleSlots - Math.min(tasksFreq[i], maxFreq - 1);
        }

        if (idleSlots > 0) return tasks.length + idleSlots;
        else return tasks.length;
    }
}