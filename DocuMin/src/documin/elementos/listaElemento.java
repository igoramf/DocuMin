package documin.elementos;

import java.util.ArrayList;
/**
 * 
 * @author Igor Falcão
 *
 */
public class listaElemento extends Elemento{
	
	/**
	 * Caractere que vai ser substituido pelo separador
	 */
	private String caractere;
	/**
	 * Separador dos valores da lista
	 */
	private String separador;
	
	/**
	 * Constrói o elemento de lista
	 * @param valor valor da lista
	 * @param prioridade prioridade da lista
	 * @param separador separador dos valores da lista
	 * @param caractere caractere dos valores da lista
	 */
	public listaElemento(String valor, int prioridade, String separador, String caractere) {
		super(valor, prioridade);
		this.separador = separador;
		this.caractere = caractere;
	}
	
	/**
	 * Retorna uma representação completa  
	 */
	@Override
	public String representacaoCompleta() {
		String frase = "";
		String[] palavraslista = this.getArrayPalavras();
		
		for(int idx = 0; idx < palavraslista.length; idx++) {
			frase += this.caractere + " " + palavraslista[idx] + "\n";
		}
		return frase;
	}
	
	/**
	 * Retorna a presentação resumida da lista
	 */
	@Override
	public String representacaoResumida() {
		String frase = "";
		String[] palavrasLista = this.getArrayPalavras();
		
		for(int idx = 0; idx < palavrasLista.length; idx++) {
			frase += palavrasLista[idx];
			if (idx != palavrasLista.length - 1) {
				frase += ", ";
			}
		}
		frase += "\n";
		return frase;
	}
	
	/**
	 * Metodo para pegar um array com os valores da lista
	 * @return
	 */
	private String[] getArrayPalavras() {
		String[] array = this.valor.split(this.separador);
		ArrayList<String> result = new ArrayList<>();
		for (String item: array) {
			if (!item.equals(this.separador.trim())) {
				result.add(item);
			};
		}
		
		return result.toArray(new String[] {});
	}

}
