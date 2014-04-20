class Solution {

public:
  int removeDuplicates(int A[], int n) {
      int i=0,j=0,last=A[0],dep=0;
      while(i<n){
          if(A[i]==last&&dep<2){
              A[j]=A[i];
              //i++;
              j++;
              dep++;
          }
          else if(A[i]!=last){
              last=A[i];
              dep=0;
              A[j]=A[i];
              j++;
              dep++;
          }
          i++;
      }
      return j;
  }
};
