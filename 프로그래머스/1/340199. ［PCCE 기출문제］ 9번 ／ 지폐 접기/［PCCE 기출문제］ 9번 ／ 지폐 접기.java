class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        boolean possible = false;
        for(int i = 0; i< wallet.length; i ++){
            for(int j =0; j < bill.length; j++){
                if(bill[j] > wallet[i]){
                    if(isPossible(bill,wallet)){
                        possible = true;
                        break;
                    }else{
                        grapBill(bill);
                        i = 0; 
                        j = 0;
                        answer++;
                    }
                    
                }
                if(possible) break;
            }
        }
        
        return answer;
    }
    
    public boolean isPossible(int[] bill, int[] wallet){
        boolean possible = false;
        if( wallet[0] >= bill[0] && wallet[1] >= bill[1]
           || wallet[0] >= bill[1] && wallet[1] >= bill[0]
           // || wallet[1] >= bill[0] && wallet[0] >= bill[1]
        ){
            possible = true;
        } else {
            possible = false;
        }
        
        return possible;
    }
    
    
//     public boolean isPossible(int[] bill, int[] wallet){
//         boolean possible = false;
//         if(wallet[0] >= bill[0] && wallet[1] >= bill[1]
//           || ((wallet[0] < bill[0] || wallet[1] >= bill[0])
//                  && wallet[0] >= bill[1])
//           || ((wallet[1] < bill[1] || wallet[0] >= bill[1])
//                  && wallet[1] >= bill[0])){
//             possible = true;
//         } else {
//             possible = false;
//         }
        
//         return possible;
//     }
    
    public void grapBill(int[] bill){
        if(bill[0] > bill[1]){
            int grap = bill[0] / 2;
            bill[0] = grap;
        } else {
            int grap = bill[1] / 2;
            bill[1] = grap;
        }
            
    }
}