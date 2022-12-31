package documin;

import documin.documento.*;
import documin.elementos.*;
import visoes.visaoController;


/**
 * 
 * @author Igor Falcão
 *
 */

public class Facade {
	
	/**
	 * Atributo do Controlador de documentos
	 */
    private DocumentoController documentoController;
    /**
     * Atributo do controlador de elementos. 
     */
    private elementoController elementoController;
    
    /**
     * Atributo do controlador de visao
     */
    private visaoController visaoController;

    /**
     * Constrói o facade.
     */
    public Facade() {
        this.documentoController = new DocumentoController();
        this.elementoController = new elementoController(documentoController);
        this.visaoController = new visaoController(documentoController);
    }
    
    /**
     * Cria o documento
     * @param titulo Titulo do documento
     * @return
     */
    public boolean criarDocumento(String titulo) {
        return this.documentoController.criarDocumento(titulo);
    }
    
    /**
     * Cria um documento
     * @param titulo titulo do documento
     * @param tamanhoMaximo tamanho limite do documento
     * @return
     */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		return this.documentoController.criarDocumento(titulo, tamanhoMaximo);
	}
	
	/**
	 * Remove um documento
	 * @param titulo
	 */
	public void removerDocumento(String titulo) {
		this.documentoController.removerDocumento(titulo);
	}
	
	/**
	 * Retorna a quantidade de elementos do documento
	 * @param titulo
	 * @return
	 */
	public int contarElementos(String titulo) {
		return this.documentoController.contarElementos(titulo);
	}
	
	/**
	 * Exibe o documento
	 * @param titulo titulo do documento que vai ser exibido
	 * @return
	 */
	public String[] exibirDocumento(String titulo) {
		return this.documentoController.exibirDocumento(titulo);
	}
	
	/**
	 * Cria um elemento de texto 	
	 * @param tituloDoc	titulo do Documento que vai ser criado o elemento
	 * @param valor	valor do elemento
	 * @param prioridade prioridade do elemento
	 * @return
	 */
	public int criarTexto(String tituloDoc, String valor, int prioridade) {
		return this.elementoController.criaTexto(tituloDoc, valor, prioridade);	
	}
	
	/**
	 * Cria um elemento de titulo 
	 * @param tituloDoc titulo do documento que vai ser criado o elemento
	 * @param valor	valor do elemento
	 * @param prioridade prioridade do elemento
	 * @param nivel nivel do elemento
	 * @param linkavel se o elemento é linkavel
	 * @return
	 */
	public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
		return this.elementoController.criarTitulo(tituloDoc, valor, prioridade, nivel, linkavel);
	}
	
	/**
	 * Cria um elemento de lista
	 * @param tituloDoc Titulo do documento que vai ser criado o elemento
	 * @param valorLista valor do elemento
	 * @param prioridade prioridade do elemento
	 * @param separador String que vai separar os valores da lista
	 * @param caractere	caractere onde vai ficar os separadores
	 * @return
	 */
	public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String caractere) {
		return this.elementoController.criarLista(tituloDoc, valorLista, prioridade, separador, caractere);
	}
	
	/**
	 * Cria um elemento de termos 
	 * @param tituloDoc	titulo do documento que vai ser criado
	 * @param valorTermos valor do elemento
	 * @param prioridade prioridade do elemento
	 * @param separador String que separar os valores da lista
	 * @param ordem ordem dos valores dos termos
	 * @return
	 */
	public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
		return this.elementoController.criarTermos(tituloDoc, valorTermos, prioridade, separador, ordem);
	}
	
	/**
	 * Retorna uma representacao completa do elemento desejado
	 * @param tituloDoc titulo do documento que vai buscar o elemento
	 * @param elementoPosicao posicao do elemento desejado no documento
	 * @return
	 */
	public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
		return this.elementoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Retorna uma representacao resumida do elemento desejado
	 * @param tituloDoc	titulo do documento onde vai ser buscado o elemento
	 * @param elementoPosicao posicao do elemento desejado no documento
	 * @return
	 */
	public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
		return this.elementoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
	}
	/**
	 * Apaga um elemento de um documento	
	 * @param tituloDoc	titulo do documento onde vai ser apagado um elemento
	 * @param elementoPosicao posicao do elemento no documento
	 * @return
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		return this.elementoController.apagarElemento(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Move um elemento uma posicao acima
	 * @param tituloDoc	titulo do documento onde vai haver a troca de posição
	 * @param elementoPosicao posição do elemento no documento
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		this.elementoController.moverParaCima(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Move um elemento uma posicao abaixo
	 * @param tituloDoc	titulo do documento onde vai haver a troca de posição
	 * @param elementoPosicao posição do elemento no documento
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		this.elementoController.moverParaBaixo(tituloDoc, elementoPosicao);
	}
	
	/**
	 * Cria um atalho
	 * @param tituloDoc titulo do documento onde vai ser criado o atalho
	 * @param tituloDocReferenciado Documento que vai se tornar atalho
	 * @return
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		return this.elementoController.criarAtalho(tituloDoc, tituloDocReferenciado);
	}

	/**
	 * Cria uma visao completa do documento
	 * @param tituloDoc titulo do documento a ser referenciado
	 * @return
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		return this.visaoController.criarVisaoCompleta(tituloDoc);
	}
	
	/**
	 * Cria uma visao resumida do documento
	 * @param tituloDoc titulo do documento a ser referenciado
	 * @return
	 */
	public int criarVisaoResumida(String tituloDoc) {
		return this.visaoController.criaVisaoResumida(tituloDoc);
	}
	
	/**
	 * Cria uma visao prioritaria do documento
	 * @param tituloDoc titulo do documento a ser referenciado
	 * @param prioridade prioridade minima para um elementos ser representado
	 * @return
	 */
	public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
		return this.visaoController.visaoPrioritaria(tituloDoc, prioridade);
	}
	
	/**
	 * Cria uma visao de titulo do documento
	 * @param tituloDoc titulo do documento referenciado
	 * @return
	 */
	public int criarVisaoTitulo(String tituloDoc) {
		return this.visaoController.visaoTitulo(tituloDoc);
	}
	
	/**
	 * Exibe uma visao
	 * @param visaold numero da visao desejada
	 * @return
	 */
	public String[] exibirVisao(int visaold) {
		return this.visaoController.exibirVisao(visaold);
	}

	
	
}

