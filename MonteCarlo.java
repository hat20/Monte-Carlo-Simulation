import java.util.*;
class MonteCarlo
{	

	public static void main(String args[])
	{
	 	MonteCarlo obj = new MonteCarlo();
		Scanner fp = new Scanner(System.in);
		System.out.println("Enter the number of days for which you have data present");
		int n = fp.nextInt();
		int num_sales[] = new int[n];
		double prob[] = new double[n];
		double cp[] = new double[n];
		int rnd[] = new int[n];
		
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
		int randNum[] = new int[m];
		int res[] = new int[m];
		System.out.println("Enter "+m+" random numbers");
		for(int i=0;i<m;i++)
		{
			randNum[i] = fp.nextInt();
			res[i] = obj.result(randNum[i],rnd,num_sales);
		}

		for(int i=0;i<m;i++)
		{
			System.out.println("Prediction for day "+ (i+1) +" is -> " +res[i] );
		}

		//Predicting on the basis of random numbers

		

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


