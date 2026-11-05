class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        for(int i=0;i<arr1.length;i++){
            boolean val=false;
            for(int j=0;j<arr2.length;j++){
                int t=arr1[i]-arr2[j];
                if(t<0)t=-t;
                if(t<=d){
                    val=true;
                    break;
                }
            }
            if(!val){
                c++;
            }
        }
        return c;
    }
}
