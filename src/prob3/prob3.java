package prob3;

public class prob3 {
		static class Node
		{
			 int ine;
			 Node next;
			 Node last;
		}
		static Node rear;
		static Node front;
		static int size;
		public static void LinkedList()
		{
		 rear=null;
		 front=null;
		 size=0;
		}

		
		
		public static void add(int o)
		{
			Node oldrear=rear;	//storing old position of rear
			rear=new Node();	//creating new rear
			rear.ine=o;
			rear.next=null;
			rear.last=oldrear;	//linking up old rear and new
			size++;	//linked list gains 1 in size after add
			if(size==1)	//if one node, it is both front and rear
			{
				if(rear!=null)
				front=rear;
				else if(front!=null)
				rear=front;
			}
			if(size>1&&oldrear!=null)
			oldrear.next=rear;
		}
		
		
		public static void print()
		{
			try{
			Node point=new Node();
				point=front;
				for (int tempmin=0; tempmin<size; tempmin++)
				{
					if(tempmin==0)
					{
						System.out.print(point.ine);
					}
					else
					System.out.print(","+point.ine);
					point=point.next;	
				}
			}
			catch(Exception e)
			{
				System.out.println("Index out of bounds");
			}
		}
	    public static int[] intoarr(Node front)
	    {
	    	int[] arr= new int[size];
	    	Node point=front;
	    	for(int tempmin=0; point.next!=null; tempmin++)
	    	{
	    		arr[tempmin]=point.ine;
	    	}
	    	return arr;
	    }
	    public static Node intolinked(int[] arr)
	    {
	    	for(int tempmin=0;tempmin<arr.length;tempmin++)
	    	{
	    		Node back=new Node();
	    		if(tempmin==0)
		    	{
	    			back.ine=arr[tempmin];
		    		front=back;
		    	}
	    	Node forw=new Node();
	    	
	    	forw.ine=arr[tempmin];
	    	back.next=forw;
	    	forw.last=back;
	    	}
	    	return front;
	    }
	    public static void quicksort()
	    {
	    	try {
				intolinked(quickSort(intoarr(front), 0, intoarr(front).length));
			} catch (Exception e) 
	    	{
			}
	    }
	    private static int[] quickSort(int[] arr, int min, int max) {

	        int minval = arr[min];
	        int tempmin = min;
	        
	        if (max <= min)
	            return arr;
	        
	        while (tempmin <= max) {
	        	if (minval<arr[tempmin])
	            {
	            int temp = arr[tempmin];
		        arr[tempmin] = arr[max-1];
		        arr[max-1] = temp;
	            }
	        	else if (minval>arr[tempmin])
	            {
	            int temp = arr[min+1];
		        arr[tempmin] = arr[tempmin+1];
		        arr[tempmin+1] = temp;
	            }
	            else
	                tempmin+=1;
	        }
	        quickSort(arr, min, min - 1);
	        quickSort(arr, max + 1, max);
	        return null;
	    }
		
		public static void main(String[] args)
		{
			LinkedList();
			quicksort();
		}
}
