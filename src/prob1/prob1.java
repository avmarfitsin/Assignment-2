package prob1;

public class prob1 {
    static void Problem1Sort( int[] a, int arraySize)
    {
        int i=1; 
        int m = a[0]; 
        int exp = 1; 
        int[] b = new int[arraySize];
        
        while (i<arraySize)
        {
            if (a[i]>m)
                m = a[i];
            i+=1;
        }
        
        do
        {
            int[] sortarr = new int[m];
            i=0;
            while (i<arraySize)
            {
            	int inde=(a[i]/exp)%10;
                sortarr[inde]=sortarr[inde]+1;
                i++;
            }
            
            i=1;
            while(i<sortarr.length)
            {
                sortarr[i]+= sortarr[i-1];
                i+=1;
            }
            
            i=arraySize-1;
            while(i>=0)
            {
            	int indx=(a[i]/exp)%10;
            	sortarr[indx]-=1;
                b[sortarr[indx]] = a[i];
                i-=1;
            }
            i=0;
            while(i<arraySize)
            {
                a[i] = b[i];
                i+=1;
            }
            
            exp *= 10; 
        }
        while (m/exp!=0);
    }    

    
    
    public static void main(String[] args) 
    {
    	int[] arr={5464,21231,877,11,230};
    	Problem1Sort(arr,5);
    	for(int i=0; i<arr.length; i++)
        {
       	 System.out.print(arr[i] + " ");
        }
    }
}
