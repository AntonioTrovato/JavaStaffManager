package progetto;

public class OrdinaPerTipoPersonale implements CriterioDiOrdinamento<Personale>
{
	public int ordina(Personale x, Personale y)
	{
		return x.getClass().getSimpleName().compareTo(y.getClass().getSimpleName());
	}
}
