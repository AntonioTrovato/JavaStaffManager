package progetto;

import java.util.ArrayList;

public class Sorter<T> 
{
	public ArrayList<T> sort(ArrayList<T> collezione, CriterioDiOrdinamento<T> criterio)
	{
		if (collezione.size()<2) return collezione;
		for(int i=0;i<collezione.size()-1;i++)
		{
			for(int j=i+1;j<collezione.size();j++)
			{
				if(criterio.ordina(collezione.get(i), collezione.get(j))>0)
				{
					T appoggio = collezione.get(i);
					collezione.set(i, collezione.get(j));
					collezione.set(j, appoggio);
				}
			}
		}
		return collezione;
	}
}
