package progetto;

/**
 * Estende il concetto di IllegalArgumentException nei casi in cui un oggetto di Operaio non sia usato nella maniera giusta 
 * @author anton
 *
 */
public class BusyWorkerException extends IllegalArgumentException {
	/**
	  * Costruttore che genera l'eccezione
	  */
	public BusyWorkerException() {};
	
	/**
	 * Genera un' eccezione accompagnata da un messaggio esplicativo del problema
	 * @param msg spiega la causa della generazione dell'eccezione
	 */
	public BusyWorkerException(String msg) {
		super(msg);
	}
}