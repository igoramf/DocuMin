package documin.elementos;

import java.util.ArrayList;

import documin.documento.documentoInterface;

/**
 * 
 * @author Igor Falcão
 *
 */

public class Atalho extends Elemento implements documentoInterface{
	
	/**
	 * ArrayList com os Elementos do Atalho.
	 */
	private ArrayList<Elemento> elementos;
	
	/**
	 * Tamanho limite do ArrayList de elementos.
	 */
	private int tamanho;
	
	/**
	 * Para mostar se o documneto é atalho. 
	 */
	private boolean eAtalho;
	
	/**
	 * Constrói o atalho.
	 * @param valor	titulo do Atalho
	 * @param prioridade Media das prioridades do documento referenciado.
	 */
	public Atalho(String valor, int prioridade) {
		super(valor, prioridade);
		this.elementos = new ArrayList<>();
	}
	
	/**
	 * Cria uma representação completa do atalho.
	 */
	@Override
	public String representacaoCompleta() {
		String retorno = "";
		for (Elemento elemento : elementos) {
			if(elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				retorno += elemento.representacaoCompleta() + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Cria uma representação resumida do atalho.
	 */
	@Override
	public String representacaoResumida() {
		String retorno = "";
		for (Elemento elemento : elementos) {
			if(elemento.getPrioridade() == 4 || elemento.getPrioridade() == 5) {
				retorno += elemento.representacaoResumida() + "\n";
			}
		}
		return retorno;
	}
	
	/**
	 * Retorna o titulo do Atalho.
	 */
	@Override
	public String getTitulo() {
		return this.valor;
	}
	
	/**
	 * Retorna a quantidade de elementos presentes no atalho.
	 */
	@Override
	public int contaElementos() {
		return this.elementos.size();
	}
	
	/**
	 * Retorna o arraylist de elementos. 
	 */
	@Override
	public ArrayList<Elemento> getElementos() {
		return this.elementos;
	}
	
	/**
	 * Move o elemento desejado uma posição acima.
	 */
	@Override
	public void moveElementoAcima(int posicao) {
		if(posicao == 0) {return;} 
		
		Elemento elementoAcima = this.elementos.get(posicao - 1); 
		Elemento elemento = this.elementos.get(posicao);
		
		this.elementos.add(posicao - 1, elemento);
		this.elementos.add(posicao, elementoAcima);
	}

	
	/**
	 * Move o elemento desejado uma posição abaixo.
	 */
	@Override
	public void moveElementoAbaixo(int posicao) {
		if(posicao == this.contaElementos() - 1) {return;}
		
		Elemento elementoInferior = this.elementos.get(posicao + 1);
		Elemento elemento = this.elementos.get(posicao);
		
		this.elementos.add(posicao + 1, elemento);
		this.elementos.add(posicao, elementoInferior);	
	}



	/**
	 * Remove o elemento desejado.
	 */
	@Override
	public boolean removeElemento(int posicao) {
		if(posicao >= this.contaElementos()) {throw new IllegalArgumentException();}
		this.elementos.remove(posicao);
		return true;
	}
 


	/**
	 * Cria um elemento e retorna a posicao dele.
	 */
	@Override
	public int criaElemento(Elemento e) {
		if(tamanho == elementos.size()) {
			throw new IllegalStateException();
		}
		this.elementos.add(e);
		return this.elementos.indexOf(e);
	}

	/**
	 * Retorna um array de strings com as representações completas dos elementos
	 */
	@Override
	public String[] exibirDocumento() {
		String[] retorno = new String[this.contaElementos()];
		
		for (int i = 0; i < retorno.length; i++) {
			retorno[i] = this.elementos.get(i).representacaoCompleta();
		}
		return retorno;
	}
	
	/**
	 * Retorna o elemento da posição passada. 
	 */
	@Override
	public Elemento getElemento(int elementoPosicao) {
		return this.elementos.get(elementoPosicao);
	}
	
	/**
	 * Retorna true se o arraylist atingiu o limite maximo de elementos.
	 */
	@Override
	public boolean estaCheio() {
		if(elementos.size() == tamanho) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna o tamanhoMaximo de elementos desejado no documento.
	 */
	@Override
	public int getTamanhoMaximo() {
		return this.tamanho;
	}
}
