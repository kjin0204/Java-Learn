import java.util.*;

class Solution {
    static int[] arr;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
         answer = 0;


        arr = new int[5];
        DFS(n,q,0,1, ans);
        return answer;
    }
    public static void DFS(int n,int[][] q,int L, int s, int[] ans){
        if(L == 5){
            if(check(q,ans)){
                answer++;
            }
            return;
        }
        for(int i = s; i<=n; i++){
            arr[L] = i;
            DFS(n,q, L+1, i+1,ans);
        }
    }
    public static boolean check(int[][]q, int[]ans){
        List<Integer> list = new ArrayList();
        for(int x : arr) list.add(x);
        for(int i = 0; i < q.length; i++){
            int cnt = 0;
            for(int j = 0; j < q[i].length; j++){
                if(list.contains(q[i][j])){
                    cnt++;
                }
            }
            if(ans[i] != cnt){
                return false;
            }
        }
        return true;
    }
}