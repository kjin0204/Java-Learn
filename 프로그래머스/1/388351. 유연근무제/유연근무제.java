class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        Employee[] employees = new Employee[schedules.length];
        int[] maxOnTime = new int[schedules.length];
        int maxCount = 0;
        int today = 0;
        
        for(int i =0 ; i < schedules.length; i ++){
            int hopeTime = schedules[i];
            int m = hopeTime % 100;
            int h = (hopeTime / 100);
            Employee emplyee = new Employee();
            employees[i] = emplyee;
            emplyee.hopeTime = schedules[i];
            emplyee.allowTime = m + 10 >= 60 ? m + 50: m + 10;
            emplyee.allowTime += h * 100;
            
            today = startday;
            
            for (int j =0; j < timelogs[i].length; j ++)
            {
                
                int workTime = timelogs[i][j];
                
                if(today <= 5){
                    if(emplyee.allowTime >= workTime){
                        emplyee.onTime++;
                    }
                        
                }
                today++;
                today = today > 7 ? 1 : today;
                maxOnTime[i] = emplyee.onTime;
                
                
                // maxCount = maxCount < emplyee.onTime ? emplyee.onTime : maxCount;
            }
            
        }
        int day = startday;
        
        for(int i =0; i <timelogs[0].length; i++ ){
            
            if(day <= 5){
                    maxCount++;
                        
                }
                day++;
                day = day > 7 ? 1 : day;
        }
            
        int count = 0 ;
        
        for (int i =0 ; i < maxOnTime.length; i++ ){
            count = maxCount == maxOnTime[i] ? ++count : count;
        }
        
        // return maxOnTime[0] * 100 + maxOnTime[1] * 10 + maxOnTime[2] + count * 1000 + maxCount * 10000;
        return   count ;
    }
}


class Employee {
    int hopeTime = 0;
    int allowTime = 0;
    int onTime = 0;
}