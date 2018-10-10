package prob2;

public class prob2{ 
    public static void merge(int[] arr, int arraySize) 
    { 
    	int i=0;
    	int a=0; 
        int b=0; 
        int c=0; 
        
        if(arr==null) 
        { 
            return; 
        } 
  
        if(arr.length!=1&&arr.length!=0) 
        { 
            int centre = (int)((double)(arr.length)*0.5); 
            int[] lsd = new int[centre]; 
            while(i<centre) 
            { 
                lsd[i] = arr[i]; 
                i++;
            } 
            i=centre;
            int[] rsd = new int[arr.length-centre]; 
            
            while(i<arr.length) 
            { 
                rsd[i-centre] = arr[i]; 
                i++;
            } 
            merge(lsd,arraySize); 
            merge(rsd,arraySize); 
  
            do 
            { 
            	if(lsd[a]>=rsd[b])
                { 
                    arr[c] = rsd[b]; 
                    b+=1; 
                } 
            	else if(lsd[a]<rsd[b]) 
                { 
                    arr[c]=lsd[a]; 
                    a+=1; 
                } 
                c+=1; 
            }
            while(a<lsd.length&&b<rsd.length);
            
            while(b<rsd.length) 
            { 
                arr[c]=rsd[b]; 
                b+=1; 
                c+=1; 
            } 
            while(a<lsd.length) 
            { 
                arr[c]=lsd[a]; 
                a+=1; 
                c+=1; 
            } 
        } 
    } 
    public static void print(int[] arr)
    {
        for(int i=0; i<arr.length; i++) 
        {
            System.out.print(arr[i]+" "); 
        } 
    }
  
 
    public static void main(String[] args) 
    { 
        int arr[] = {43734,21432,444,6568}; 
        merge(arr,4);  
        print(arr);
    }
}

