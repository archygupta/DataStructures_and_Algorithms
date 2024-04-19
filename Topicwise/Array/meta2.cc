Q2: find the Kth missing item in sequence given longest increasing sequence, ignoring the items before starting element, -> 
[2,3,5,8,10,50,100], k=3 => 7
  
  // Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    
    public int findKthMissingElement(int[] arr, int k){
        for(int i=0;i<arr.length-1;i++){
            int diff = arr[i+1]-arr[i]-1;
            if(diff!=0 && diff >=k){
                return arr[i]+k;
            }
            else{
                k-=diff;
            }
        }
        return arr[arr.length-1]+k;
    }
    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        int res= hw.findKthMissingElement(new int[]{2,3,5,8,10,50,100}, 3);
        System.out.println(res);
        res= hw.findKthMissingElement(new int[]{2}, 5);
        System.out.println(res);
        res= hw.findKthMissingElement(new int[]{2,3,4,10}, 3);
        System.out.println(res);
        res= hw.findKthMissingElement(new int[]{2,3,4,10, 100, 200}, 10);
        System.out.println(res);
    }
}
