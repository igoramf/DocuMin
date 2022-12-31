package documin.documento;

import java.util.ArrayList;

import documin.elementos.Atalho;
import documin.elementos.Elemento;

/**
 * 
 * @author Igor Falcão
 *
 */
public class Documento implements documentoInterface {
	
	/**
	 * titulo do documento
	 */
	private String titulo;
	
	/**
	 * tamanho maximo de elementos no documento 
	 */
	private int tamanho;
	
	/**
	 * Verifica se o documento é atalho.
	 */
	private boolean eAtalho;
	
	/**
	 * ArrayList que vai armazenar os elementos do documento
	 */
	private ArrayList<Elemento> elementos;
	
	/**
	 * Constrói um Documento sem quantidade de elementos delimitada
	 * @param titulo titulo do documento
	 */
	public Documento(String titulo) {
		this.titulo = titulo;	
	}
	
	/**
	 * Constrói um documento com a quantidade de elementos delimitada
	 * @param titulo
	 * @param tamanho
	 */
	public Documento(String titulo, int tamanho) {
		this.titulo = titulo;
		if(this.tamanho <= 0) {
			throw new IllegalArgumentException();
		}
		this.tamanho = tamanho;
	}
	
	/**
	 * retorna o titulo do documento
	 */
	@Override
	public String getTitulo() {
		return this.titulo;
	}
	
	/**
	 * Retorna a quantidade de elementos presentes do documento
	 */
	@Override
	public int contaElementos() {
		return this.elementos.size();
	}
	
	/**
	 * Retorna o array de elementos 	
	 */
	@Override
	public ArrayList<Elemento> getElementos() {
		return this.elementos;
	}
	
	/**
	 * Move um elemento uma posição acima
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
	 * Move um elemento uma posição abaixo
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
	 * Remove um elemento do documento
	 */
	@Override
	public boolean removeElemento(int posicao) {
		if(posicao >= this.contaElementos()) {throw new IllegalArgumentException();}
		this.elementos.remove(posicao);
		return true;
	}

	/**
	 * Cria um elemento no documento
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
	 * Verifica se o documento já atingiu o número maximo de elementos
	 */
	@Override
	public boolean estaCheio() {
		if(elementos.size() == tamanho) {
			return true;
		}
		return false;
	}
	
	/**
	 * Retorna um array de string com as representações completas dos elementos do documento 
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
	 * Muda o status de atalho do documento
	 */
	public void setAtalho() {
		this.eAtalho = true;
	}
	
	/**
	 * Verifica se o documento é atalho 
	 * @return
	 */
	public boolean ehAtalho() {
		return this.eAtalho;
	}
	
	/**
	 * Verifica se o documento possui atalhos
	 * @return
	 */
	public boolean temAtalho() {
		for (int i = 0; i <	elementos.size(); i++) {
			if(elementos.get(i) instanceof Atalho) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retorna um elemento do documento pela posição passada
	 */
	
	@Override
	public Elemento getElemento(int elementoPosicao) {
		return this.elementos.get(elementoPosicao);
	}

	/**
	 * Retorna o número máximo de elementos do documento
	 */
	@Override
	public int getTamanhoMaximo() {
		return this.tamanho;
	}
	
	/**
	 * Retorna a média de prioridade dos elementos do documento
	 * @return
	 */
	public  int mediaPrioridadeElementos() {
		int soma = 0;
		for (Elemento elemento : elementos) {
			soma += elemento.getPrioridade();
		}
		return soma / this.contaElementos();
	}
	
	
}
