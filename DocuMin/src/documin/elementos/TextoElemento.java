package documin.elementos;


/**
 * 
 * @author Igor Falcão
 *
 */
public class TextoElemento extends Elemento{
	
	/**
	 * Constrói o elemento de texto
	 * @param valor valor do texto
	 * @param prioridade prioridade do texto
	 */
	public TextoElemento(String valor, int prioridade) {
		super(valor, prioridade);
	}
	
	/**
	 * retorna a representação completa do texto
	 */
	@Override
	public String representacaoCompleta() {
		return this.valor;
	}
	
	/**
	 * retorna a representação resumida do texto
	 */
	@Override
	public String representacaoResumida() {
		return this.valor;
	}

}
