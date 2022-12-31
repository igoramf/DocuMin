package visoes;

import java.util.ArrayList;

import documin.documento.Documento;
import documin.elementos.Elemento;

/**
 * 
 * @author Igor Falcão
 *
 */
public class visaoPrioritaria extends visao{

	private int prioridade;

	public visaoPrioritaria(Documento documento, int prioridade) {
		super(documento);
		this.prioridade = prioridade;
	}
	
	/**
	 * Exibe a visao desejada
	 */
	@Override
	public String[] exibeVisao() {
		String[] retorno = new String[this.qntdElementosMaiores()];
		ArrayList<Elemento> elementos = documento.getElementos();
		for (int i = 0; i < elementos.size(); i++) {
			if(elementos.get(i).getPrioridade() >= this.prioridade) {
				retorno[i] = elementos.get(i).representacaoCompleta();
			}
		}
		return retorno;
	}
	
	/**
	 * Retorna a quantidade de elementos que possuem prioridade maior ou igual a prioridade passada no constructor
	 * @return
	 */
	private int qntdElementosMaiores() {
		int maiores = 0;
		ArrayList<Elemento> elementos = documento.getElementos();
		for (int i = 0; i < elementos.size(); i++) {
			if(elementos.get(i).getPrioridade() >= this.prioridade) {
				maiores++;
			}
		}
		return maiores;
	}

}
