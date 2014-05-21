public int[] searchRange(int[] A, int target) {
        int begin =0;int end = A.length-1;
        int[] res = {-1,-1};
        while(begin<=end){
            int mid = begin +(end-begin)/2;//wrong: begin+(end-begin)>>1
            if(A[mid]==target){
                int lt=mid-1;int rt=mid+1;
                while(lt>=0&&A[lt]==target) lt--;
                while(rt<A.length&&A[rt]==target)rt++;
                res[0]=lt+1;
                res[1]=rt-1;
                break;
            }else{
                if(A[mid]>target){
                    end=mid-1;
                }else{
                    begin = mid+1;
                }
            }
        }
        return res;
    }