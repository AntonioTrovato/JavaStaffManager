package progetto;

/**
 * Estende il concetto di IllegalArgumentException nei casi in cui un oggetto di Squadra non sia usato nella maniera giusta 
 * @author workgroup
 *
 */
public class FakeMemberException extends IllegalArgumentException{
	/**
	  * Costruttore che genera l'eccezione
	  */
	public FakeMemberException() {};
	
	/**
	 * Genera un' eccezione accompagnata da un messaggio esplicativo del problema riscontrato
	 * @param msg spiega la causa della generazione dell'eccezione
	 */
	public FakeMemberException(String msg) {
		super(msg);
	}
}