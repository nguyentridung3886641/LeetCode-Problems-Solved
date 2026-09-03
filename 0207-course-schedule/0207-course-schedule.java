import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2 || prerequisites.length == 0) 
            return true;

        int[] inDegree = new int[numCourses];
        int processedCount = 0;
        
        for (int[] i : prerequisites) {
            ++inDegree[i[0]];
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curCourse = queue.poll();

            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == curCourse) {
                    --inDegree[prerequisites[i][0]];
                    if (inDegree[prerequisites[i][0]] == 0) {
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
            ++processedCount;
        }
        return (processedCount < numCourses) ? false : true;
    }
}