import java.util.*;

class Solution {
    
    class Robot{
        int x;
        int y;
        int dx;
        int dy;
        List<Integer> l_x;
        List<Integer> l_y;
        int count;
        int number;
        boolean goal = false;

        public Robot(){
            l_x = new ArrayList();
            l_y = new ArrayList();
        }

    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int routecount = routes[0].length;


        List<Robot> robots = new ArrayList<>();
        for(int i = 0; i < routes.length; i++) {
            Robot temp = new Robot();
            int s_index = routes[i][0];
            int d_index = routes[i][1];
            temp.x = points[s_index - 1][1];
            temp.y = points[s_index - 1][0];
            temp.dx = points[d_index - 1][1];
            temp.dy = points[d_index - 1][0];
            temp.number = i + 1;
            temp.count = 1;

            for(int j= 0; j < routecount; j++) {
                temp.l_y.add(points[routes[i][j] -1][0] );
                temp.l_x.add(points[routes[i][j] -1][1] );
            }


            robots.add(temp);
        }
        
        int count = 0;
        
        
        
        
        
        while(robots.size() > 0) {
            count++;

            Map<String,Integer> check = new HashMap<>();

            
            for(int i = 0; i < robots.size(); i++) {
                Robot ro = robots.get(i);

                String point = ro.y +"," + ro.x;

                check.put(point, check.getOrDefault(point, - 1) + 1);
                
                
                if(ro.x == ro.dx
                        && ro.y == ro.dy && !ro.goal)
                {
                    if(ro.count == routecount - 1 &&
                        ro.l_y.get(routecount - 1) == ro.y && ro.l_x.get(routecount - 1) == ro.x)
                        ro.goal = true;
                    else {
                        ++ro.count;
                        ro.dx = ro.l_x.get(ro.count);
                        ro.dy = ro.l_y.get(ro.count);
                    }
                }
            }

            robots.removeIf(x -> x.goal);
            
            
            for(String key : check.keySet()){
                if(check.get(key) > 0)
                    answer += 1;
            }

            for(int i = 0; i < robots.size(); i++) {
                Robot ro = robots.get(i);


                if(ro.y != ro.dy) {
                    ro.y =  ro.dy < ro.y ? ro.y - 1 : ro.y + 1;
                }
                else if(ro.x != ro.dx) {
                    ro.x = ro.dx < ro.x ? ro.x - 1 : ro.x + 1;
                }


            }

        }


        return answer;
    }
}