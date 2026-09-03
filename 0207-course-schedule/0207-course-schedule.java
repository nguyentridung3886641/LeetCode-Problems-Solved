import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2 || prerequisites.length == 0) 
            return true;

        int[] inDegree = new int[numCourses];
        int completed = 0;
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int pre = p[1];

            adj.get(pre).add(course);
            ++inDegree[course];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            ++completed;

            for (int nextCourse : adj.get(cur)) {
                --inDegree[nextCourse];
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return (completed == numCourses) ? true : false;
    }
}