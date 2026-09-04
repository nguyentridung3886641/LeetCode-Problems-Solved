import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int pre = p[1];
            int course = p[0];

            adj.get(pre).add(course);
            ++inDegree[course];
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res[completed++] = course;

            for (int nextCourse : adj.get(course)) {
                --inDegree[nextCourse];
                
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return (completed == numCourses) ? res : new int[]{};
    }
}