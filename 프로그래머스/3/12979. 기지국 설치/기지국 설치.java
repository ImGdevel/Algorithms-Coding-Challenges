import java.util.*;

class Solution {
    

    
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        // 정렬되어있나?
        Arrays.sort(stations);
        int area = w * 2 + 1;
        int end = 1;
        //System.out.println(area);
        for(int i=0; i < stations.length; i++){
            int point = stations[i];
            int pointLeft = Math.max(point - w, 1);
            int pointRight = Math.min(point + w, n);
            int d = pointLeft - end;
            // 기지국 건설
            answer += (d>0)? ((d-1) / area) + 1 : 0;
            //System.out.println(answer + " " + end + "~" + pointLeft + ">" + d);
            end = pointRight + 1;
            
        }
        int last = (n + 1) - end ;
        answer += (last>0)? ((last-1) / area) + 1 : 0;
        //System.out.println(answer + " " + last );
        return answer;
    }
}