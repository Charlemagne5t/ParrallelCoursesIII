import java.util.*;

public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adjasencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjasencyList.add(new ArrayList<>());
        }
        int[] inDegree = new int[adjasencyList.size()];
        for (int[] relation : relations) {
            adjasencyList.get(relation[0] - 1).add(relation[1] - 1);
            inDegree[relation[1] - 1]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] maxTime = new int[n];

        for (int i = 0; i < n; i++) {
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            int current = queue.poll();
            for (int next : adjasencyList.get(current)) {
                maxTime[next] = Math.max(maxTime[next], maxTime[current] + time[current]);
                inDegree[next]--;
                if(inDegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        int result = -1;
        for (int i = 0; i < n; i++) {
            if(adjasencyList.get(i).isEmpty()){
                result = Math.max(result, maxTime[i] + time[i]);
            }
        }
        return result;
    }
}
