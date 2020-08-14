 /*
  找零钱，有1 ，4,16,64，四种面值的硬币和1024一种面值的纸币，，问如果小明拿1024元纸币去买一个价值为N（0<N<=1024）的东西，他会收到多少硬币作为找零
  如：输入1000输出3
  （1024-1000）/16 = 1 ... 8   8/4 =2     1+2 = 3
 */
 
 public static int changes(int n){
        int count = 0;
        int rests = 1024-n;
        if(rests == 0) return 0;
        while(rests>0){
            if(rests>= 64){
                if(rests%64 == 0){
                    count = rests/64;
                    break;
                }else{
                    count+= rests/64;
                    rests =rests%64;
                }
            } else if(rests>=16 && rests<64){
                if(rests%16 == 0){
                    count  += rests/16;
                    break;
                }else{
                    count+= rests/16;
                    rests = rests%16;
                }
            }else if(rests>= 4 && rests <16){
                if(rests%4 == 0){
                    count += rests/4;
                    break;
                }else{
                    count+= rests/4;
                    rests = rests%4;
                }
            } else{
                count += rests;
                rests = 0;
            }
        }
      return count;
    }
