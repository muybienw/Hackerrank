import java.util.*;

/**
 * Created by MuyBien on 11/8/15.
 */
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int v = sc.nextInt();
            int e = sc.nextInt();
            int[][] edges = new int[e][2];
            for(int j=0; j<e; j++){
                edges[j][0] = sc.nextInt();
                edges[j][1] = sc.nextInt();
            }
            int s = sc.nextInt();

            int[] result = dfs(v, edges, s);
            print(result);
        }
    }

    private static int[] dfs(int v, int[][] edges, int s){

        int[] dist = new int[v+1];
        for(int i=0; i<=v; i++) dist[i] = -1;
        boolean[] visited = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<Integer>();

        dist[s] = 0;
        queue.offer(s);
        visited[s] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i=0; i<edges.length; i++){
                if(edges[i][0] == node){
                    int neighbor = edges[i][1];
                    if(visited[neighbor]==true) continue;
                    queue.offer(neighbor);
                    dist[neighbor] = dist[node] + 6;
                    visited[neighbor] = true;
                }
                else if(edges[i][1] == node){
                    int neighbor = edges[i][0];
                    if(visited[neighbor]==true) continue;
                    queue.offer(neighbor);
                    dist[neighbor] = dist[node] + 6;
                    visited[neighbor] = true;
                }
            }
        }

        int[] ret = new int[v-1];
        int r = 0;
        for(int i=1; i<=v; i++){
            if(i==s) continue;
            else ret[r++] = dist[i];
        }

        return ret;
    }

    private static void print(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
            if(i!=nums.length-1) System.out.print(" ");
        }
        System.out.println();
    }



}
