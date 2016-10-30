package wendler531;

public class Lift
{
	
	public static double[][] freshP = {  { 0.65 ,0.75 ,0.85 } ,{0.70 , 0.80 , 0.90},{0.75 , 0.85 , 0.95} ,{0.40 , 0.50 , 0.60}};
	public static double[][] heavyP = {  { 0.65 ,0.75 ,0.85 } ,{0.70 , 0.80 , 0.90},{0.75 , 0.85 , 0.95} ,{0.40 , 0.50 , 0.60}};
	public static boolean freshSwitch = true;
	
	private int oneRepMax;
	public static int weeks;
	private String name;
	
	public Lift()
	{
		this.name = "";
		oneRepMax = 0;
	}
	
	public Lift(String name)
	{
		this.name = name;
		oneRepMax = 0;
	}
	
	public Lift(int onerepmax,String name)
	{
		this.name = name;
		oneRepMax = onerepmax;
	}

	public int getOneRepMax()
	{
		return oneRepMax;
	}

	public void setOneRepMax(int orm)
	{
		this.oneRepMax = orm;
	}

	public void setName(String n)
	{
		this.name = n;
	}
	public void calOneRepMax(int weight,int reps)
	{
		this.oneRepMax = (int)(.0333*weight*reps)+weight;
	}
	
	public String getName()
	{
		return name;
	}
	
	public static int getWeeks()
	{
		return weeks;
	}

	public String CalWorkout()
	{
		String result = "\n";
		int temp = 0 ;
		int Ormtemp = oneRepMax;
		int reps =0;
		
		for(int i = 0 ; i < weeks ; i++)
		{
			if(i % 4 == 0)
			{
				result += String.format( " Cycle %d\t\t\t",((i/4)+1));	
			}
		}
		
		for(int i = 0 ; i < 4 ; i++)
		{
			result += "\n";
			
			for(int k = 0 ; k < weeks/4 ; k++)
			result += String.format( " Week %d\t\t\t\t",i+1);	
			
			for(int t = 0; t < 3 ; t++)
			{
				result += "\n";
				
				for(int v = 0; v < weeks/4 ; v++)
				{
					Ormtemp+=5;
					reps = 5;
					if(freshSwitch == true)
					{
					temp = (int) (Ormtemp*freshP[i][t]);
					}
					else
					{
					temp = (int) (Ormtemp*heavyP[i][t]);
					}
					
					if (i == 1)
					{
						reps = 3;
					}
					else if (i == 2 && t > 0)
					{
						reps -= 2;
						if(t == 2)
							reps =1;
					}
					else if (i > 2)
					{
						reps = 10;
					}
					
					
					result += String.format(" set  %d  :  %d lbs X %d \t" ,(t+1),temp,reps);
				}
				Ormtemp = oneRepMax;
			}
		}
		return result;
	}
	
	public String toString()
	{
		return "\t" + name + "\n" + " One Rep Max : " + oneRepMax + "lbs" + CalWorkout() + "\n";
	}
	
	// end of class
}
