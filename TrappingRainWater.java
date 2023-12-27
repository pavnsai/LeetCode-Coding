public class TrappingRainWater {
    public int trap(int[] height) {
        int l=0,r=height.length-1,leftMax=0,rightMax=0,ans=0;
        while(l<r){
            if(height[l]<=height[r]){
                if(height[l]>=leftMax){
                    leftMax=height[l];
                }else{
                    ans+=leftMax-height[l];
                }
                l++;
            }else{
                if(height[r]>=rightMax){
                    rightMax=height[r];
                }else{
                    ans+=rightMax-height[r];
                }
                r--;
            }
        }
        return ans;
    }

    //Second Approach

    public int trap2(int[] height) {
        int ans=0;
        int prefix[]=new int[height.length];
        int suffix[]=new int[height.length];
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<height.length;i++){
            maxi=Math.max(maxi,height[i]);
            prefix[i]=maxi;
        }
        maxi=Integer.MIN_VALUE;
        for(int i=height.length-1;i>=0;i--){
            maxi=Math.max(maxi,height[i]);
            suffix[i]=maxi;
        }
        for(int i=0;i<height.length;i++){
            // System.out.println(prefix[i]);
            // System.out.println(suffix[i]);
            int check=Math.min(prefix[i],suffix[i]);
            ans+=check-height[i];
        }
        return ans;
    }
}
