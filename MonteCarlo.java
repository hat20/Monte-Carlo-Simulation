import java.util.*;
class MonteCarlo extends RandomNumbers
{	

	public static void main(String args[])
	{
	 	MonteCarlo obj = new MonteCarlo();
		Scanner fp = new Scanner(System.in);
		System.out.println("Enter the number of days for which you have data present");
		int n = fp.nextInt(); //stores number of days for which user has data 
		int num_sales[] = new int[n]; //stores the amount of sales that might have happened on some previous day 
		double prob[] = new double[n]; // stores the probability of the corresponding sales number
		double cp[] = new double[n]; //stores cumulative probability
		int rnd[] = new int[n]; //stores range of Random Number based on cumulative probability
		
		//Taking data from user

		System.out.println("Now you shall provide the past data");
		System.out.println("Enter number of sales in a day followed by its probability");
		for(int i=0;i<n;i++)
		{
		num_sales[i] = fp.nextInt();
		prob[i] = fp.nextDouble();
		}

		//Calculating Cumulative probability

		cp = obj.calculate_cp(prob);

		//Assigning Random Numbers to cumulative probability distribution

		rnd = obj.randomRange(cp);

		//Prediction Part

		System.out.println("Enter the number of days for which you want prediction");
		int m = fp.nextInt();
		int randNum[] = new int[m]; //stores the newly generated or entered random numbers
		int res[] = new int[m]; // stores sales prediction for every day 

		//Skipping the newline
		fp.nextLine();

		System.out.println("Do you want to enter random numbers? Type 'Yes' or 'No'");
		String s = fp.nextLine(); 
		if(s.equalsIgnoreCase("yes") == true)
		{	System.out.println("Enter "+m+" random numbers");
			for(int i=0;i<m;i++)
				randNum[i] = fp.nextInt();
		}
		else
		{
			System.out.println("Do you want Unique Random Numbers? Type 'Yes' or 'No'");
			s = fp.nextLine();
			if(s.equalsIgnoreCase("yes") == true)
				randNum = obj.unique_random_numbers(m); //Derived from RandomNumbers.java
			else
				randNum = obj.random_numbers(m);//Derived from RandomNumbers.java
		}
		

		for(int i=0;i<m;i++)
			res[i] = obj.result(randNum[i],rnd,num_sales);
		
		//Predicting on the basis of Random Numbers

		for(int i=0;i<m;i++)
		{
			System.out.println("Prediction for day "+ (i+1) +" is -> " +res[i] );
		}

	}

//Function to calculate cumulative probability values
	double[] calculate_cp(double prob[])
	{
		int n = prob.length;
		double cp[] = new double[n];
		cp[0] = prob[0];
		for(int i=1;i<n;i++)
		{
			cp[i]=cp[i-1]+prob[i]; 
		}
		return cp;     
	}


	int[] randomRange(double cp[])
	{
		int n = cp.length;
		int rnd[] = new int[n];
		for(int i=0;i<n;i++)
		{
			rnd[i] = ((int)(cp[i]*100)) -1;
		}
		return rnd;
	}

	int result(int r,int rnd[],int num_sales[])
	{
		int i =0;
		while(r>rnd[i])
		{	

			i++;
		}
		return num_sales[i];
	}
}


