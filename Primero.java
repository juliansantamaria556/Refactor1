public class Primero 
{     
	public static void main(String[] args) 
	{
       	final int M = 1000;
     	final int RR = 50;
	    final int CC = 4;
     	final int ORDMAX = 30;
     	int P[] = new int[M+1];
     	int PAGENUMBER = 1;
     	int PAGEOFFSET = 1;
     	int ROWOFFSET;
     	int J = 1;
    	int K = 1;
     	boolean JPRIME;
     	int ORD = 2;
     	int SQUARE = 9; 
    	int N=0;
     	int MULT[] = new int[ORDMAX+1];
     	P[1] = 2;
        while (K < M) 
		{
        	do 
			{
            	J += 2;
            	if( J == SQUARE) 
				{
		        	ORD++;
         		    SQUARE=P[ORD]*P[ORD];
         		    MULT[ORD-1]=J;
           		}
         		N=2;
	            JPRIME=true;
         		while (N < ORD && JPRIME) 
				{
	     			while (MULT[N]<J)
	     				MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                    	JPRIME=false;
					N++;
                }
             }while (!JPRIME);
	        K++;
         	P[K]=J;
       	}
	    while (PAGEOFFSET <= M) 
		{
			System.out.println("The First "+Integer.toString(M)+" Prime Numbers === Page "+Integer.toString(PAGENUMBER)+"\n");
       		for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) 
			{
             		for (int C = 0; C <= CC - 1; C++)
	                     if (ROWOFFSET + C * RR <= M)
                     		System.out.printf("%10d", P[ROWOFFSET + C * RR]);
               
             	System.out.println();
         	}
     		System.out.println("\f");
     		PAGENUMBER++;
     		PAGEOFFSET += RR*CC;
       	}
   	} 
}