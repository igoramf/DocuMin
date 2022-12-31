package documin.elementos;

/**
 * 
 * @author Igor Falcão
 *
 */

public abstract class Elemento {
	/**
	 * Prioridade do elemento
	 */
	protected int prioridade;
	
	/**
	 * Valor do elemento
	 */
	protected String valor;
	
	/**
	 * Constrói o elemento
	 * @param valor valor do elemento
	 * @param prioridade prioridade do elemento
	 */
	public Elemento(String valor, int prioridade) {
		this.valor = valor;
		this.prioridade = prioridade;
	}
	
	/**
	 * Retorna o valor do elemento
	 * @return
	 */
	public String getValor() {
		return this.valor;
	}
	
	/**
	 * Retorna a prioridade do elemento
	 * @return
	 */
	public int getPrioridade() {
		return this.prioridade;
	}
	
	/**
	 * Metodo abstrato para representação completa do elemento
	 * @return
	 */
	public abstract String representacaoCompleta();
	
	/**
	 * Metodo abstrato para representação resumida do elemento
	 * @return
	 */
	public abstract String representacaoResumida();
}
