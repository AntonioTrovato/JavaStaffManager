package progetto;

/**
 * Estende il concetto di IllegalArgumentException nei casi in cui un oggetto di Dirigente o Quadro non sia usato nella maniera giusta 
 * @author anton
 *
 */
public class ManagerException extends IllegalArgumentException{
	/**
	  * Costruttore che genera l'eccezione
	  */
	public ManagerException() {}
	
	/**
	 * Genera un' eccezione accompagnata da un messaggio esplicativo del problema
	 * @param msg spiega la causa della generazione dell'eccezione
	 */
	public ManagerException(String msg) {
		super(msg);
	}
}