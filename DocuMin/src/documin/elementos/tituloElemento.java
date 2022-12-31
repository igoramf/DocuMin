package documin.elementos;

/**
 * 
 * @author Igor Falcão
 *
 */

public class tituloElemento extends Elemento{
	
	private int nivel;
	private boolean linkavel;
	
	/**
	 * Construtor do elemento de titulo
	 * @param valor valor do titulo
	 * @param prioridade prioridade do titulo
	 * @param nivel nivel do titulo
	 * @param linkavel se o titulo é linkavel
	 */
	public tituloElemento(String valor, int prioridade, int nivel, boolean linkavel) {
		super(valor, prioridade);
		this.nivel = nivel;
		this.linkavel = linkavel;
	}

	@Override
	public String representacaoCompleta() {
		if(this.linkavel) {
			return nivel + ". " + valor + "--" + nivel + "-" + valor.toUpperCase().trim();
		}else {
			return nivel + ". " + valor;
		}
	}

	@Override
	public String representacaoResumida() {
		return nivel + ". " + valor.substring(0, valor.indexOf(" ")); 
	}

}
