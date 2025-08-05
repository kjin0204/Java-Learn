class Solution {
    public int solution(int n, int w, int num) {
         int answer = 0;
        int row = (num - 1) / w;
        int col = (row % 2 == 0) ? (num - 1) % w : (w - 1 - (num - 1) % w);

        for (; row < (n + w - 1) / w; row++) {
            int aboveBox = (row % 2 == 0) ? col + row * w : (w - 1 - col) + row * w;
            if (aboveBox < n) answer++;
        }

        return answer;
    }
}