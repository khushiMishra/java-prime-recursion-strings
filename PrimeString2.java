import java.io.*;
public class PrimeString2 {
	
	private int min = 30;
	private int max = 70;//44
	private String series = new String();

    public static void main(String[] args) {
        System.out.println("Begin PrimeString\n");
        PrimeString2 ps = new PrimeString2();
		ps.iterate();
		System.out.println("Series:" + ps.series +"\n");
		System.out.println("End PrimeString\n");
    }
    
    /*
     *  Iterate over the numerical range
     */
	public void iterate(){
		for(int i = this.min; i <= this.max; i++){
			if(this.isPrime(i)){				
				this.series = this.series + findMiddle(Integer.toString(this.F(i)));
				System.out.println("-----------------------------------\n");
			}
		}
	}
	
	/*
	* The given function F
	*/
	public int F(int n){
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return F(n - 1) + F(n - 2);	
	}
	
	/*
	* Check whether a number is prime
	*/	
	public boolean isPrime(int n) {
	    // fast even test.
	    if(n > 2 && (n & 1) == 0){
	    	System.out.println(n + " is NOT prime\n");
	       return false;
	    }

	    // only odd factors need to be tested up to n^0.5
	    for(int i = 3; i * i <= n; i += 2)
	        if (n % i == 0) {
	        	System.out.println(n + " is NOT prime\n");
	            return false;
	        }

	    System.out.println(n + " is prime\n");    
	    return true;
	}
	
	/*
	 * Find the middle number in the string
	 */
	public String findMiddle(String s){
		System.out.println(s + "\n");
		
		int len = s.length();
		int half = len/2;
		System.out.println("half: " + half + "\n");
			
		if(len % 2 == 0){	
			System.out.println("Even: " + Character.toString(s.charAt(half-1)) + Character.toString(s.charAt(half)) + "\n");
			return Character.toString(s.charAt(half-1)) + Character.toString(s.charAt(half));
		}
		else{
			System.out.println("Odd: " + Character.toString(s.charAt(half)) + "\n");
			return Character.toString(s.charAt(half));
		}		 
	}
}