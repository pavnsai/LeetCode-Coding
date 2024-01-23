 class NinjasTrainingTLE {
    public static int sum(int n,int last,int points[][]){
        if(n==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    maxi=Math.max(maxi,points[0][i]);
                }
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                int point=points[n][i]+sum(n-1,i,points);
                maxi=Math.max(maxi,point);
            }
        }
        return maxi;
    }
    public static int ninjaTraining(int n, int points[][]) {
        return sum(n-1,3,points);
    }
}
