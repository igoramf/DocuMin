package documin.elementos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author Igor Falcão
 *
 */
public class termosElemento extends Elemento {

		private String separador;
		private String ordem;
	
	/**
	 * Constrói o elemento de termos 
	 * @param valor valor dos termos
	 * @param prioridade prioridade do elemento
	 * @param separador separador dos valores do termos
	 * @param ordem ordem que vai se organizar os valores
	 */
	public termosElemento(String valor, int prioridade, String separador, String ordem) {
		super(valor, prioridade);
		this.separador = separador;
		this.ordem = ordem;
	}
	
	/**
	 * retorna a representação completa do termo
	 */
	@Override
	public String representacaoCompleta() {	
		String[] palavras = this.getPalavrasOrdenadas();
		String frase = "Total termos: " + palavras.length + "\n- ";
		for (int index = 0; index < palavras.length; index++) {
			frase += palavras[index];
			if (index != palavras.length - 1) {
				frase += ", ";
			}
		}
		frase += "\n";
		return frase;
	}
	
	/**
	 * Retorna a representacao resumida do termo
	 */
	@Override
	public String representacaoResumida() {
		String [] palavras = this.getPalavrasOrdenadas();
		String frase = "";
		for (int index = 0; index < palavras.length; index++) {
			frase += palavras[index];
			if (index != palavras.length - 1) {
				frase += this.separador;
			}
		}
		frase += "\n";
		return frase;
	}
	
	/**
	 * Retorna um array com os valores do termo ordenados
	 * @return
	 */
	private String[] getPalavrasOrdenadas() {
		String[] palavras = this.getArrayPalavras();
		
		for (int index = 0; index < palavras.length; index++) {
			palavras[index] = palavras[index].toLowerCase();
		}
		
		if (this.ordem == "NENHUM") return palavras;	
		if (this.ordem == "ALFABÉTICA") Arrays.sort(palavras);
		if (this.ordem == "TAMANHO") {
			Arrays.sort(palavras, Comparator.comparing(String::length).reversed());
		}
		return palavras;
	}
	
	
	/**
	 * Retorna um array de string com os valores do termo
	 * @return
	 */
	private String[] getArrayPalavras() {
		String[] array = this.valor.split(this.separador);
		ArrayList<String> result = new ArrayList<>();
		for (String item : array) {
			if (!item.equals(this.separador.trim())) {
				result.add(item);
			};
		}
		
		return result.toArray(new String[] {});
	}
	
}
