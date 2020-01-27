package aula11ex1;

import java.util.ArrayList;

public class BubbleSort implements Strategy{
	

	public ArrayList<Telemovel> sort(ArrayList<Telemovel> arr, Attribute a){
		
		for(Telemovel t:arr) {
			t.setC(a);
		}
	
		int n = arr.size();
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr.get(j).compareTo( arr.get(j+1)) > 0)
				{
					// swap temp and arr[i]
					Telemovel temp = arr.get(j);
					arr.set(j,arr.get(j+1));
					arr.set(j+1,temp);
					
				}
		
		return arr;
		
	}

}
	
	

