package documin.elementos;

import documin.documento.Documento;
import documin.documento.DocumentoController;
/**
 * 
 * @author Igor Falcão
 *
 */
public class elementoController {
	/**
	 * Documento controller
	 */
	private DocumentoController documentoController;
	
	/**
	 * Constrói o controlador de elementos
	 * @param documentoController
	 */
	public elementoController(DocumentoController documentoController) {
		this.documentoController = documentoController;
	}
	
	/**
	 * Cria o elemento de texto
	 * @param docTitulo titulo do documento referenciado
	 * @param valor valor do elemento
	 * @param prioridade prioridade do elemento de texto
	 * @return
	 */
	public int criaTexto(String docTitulo, String valor, int prioridade) {
		if (docTitulo.isBlank() || docTitulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if(prioridade > 5 || prioridade < 1) {
			throw new IllegalArgumentException("Prioridade tem que ser entre 1 e 5");
		}
		Documento doc = this.documentoController.getDocumento(docTitulo);
		TextoElemento text = new TextoElemento(valor, prioridade);
		return doc.criaElemento(text);
	}
		
	/**
	 * Cria o elemento de titulo
	 * @param docTitulo titulo do documento referenciado
	 * @param valor valor do titulo
	 * @param prioridade prioridade do titulo
	 * @param nivel nivel do titulo
	 * @param linkavel se o titulo é linkável
	 * @return
	 */
	public int criarTitulo(String docTitulo, String valor, int prioridade, int nivel, boolean linkavel) {
		if (docTitulo.isBlank() || docTitulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if(prioridade > 5 || prioridade < 1) {
			throw new IllegalArgumentException("Prioridade tem que ser entre 1 e 5");
		}
		Documento doc = this.documentoController.getDocumento(docTitulo);
		tituloElemento titulo = new tituloElemento(valor, prioridade, nivel, linkavel);
		return doc.criaElemento(titulo);
	}
	
	/**
	 * Cria o elemento de lista
	 * @param docTitulo titulo do documento referenciado
	 * @param valorLista valor da lista
	 * @param prioridade prioridade da lista
	 * @param separador separador dos valores da lista
	 * @param caractere caractere que vão ser substituidos pelo separador
	 * @return
	 */
	public int criarLista(String docTitulo, String valorLista, int prioridade, String separador, String caractere) {
		if (docTitulo.isBlank() || docTitulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if(prioridade > 5 || prioridade < 1) {
			throw new IllegalArgumentException("Prioridade tem que ser entre 1 e 5");
		}
		Documento doc = this.documentoController.getDocumento(docTitulo);
		listaElemento lista = new listaElemento(valorLista, prioridade, separador, caractere);
		return doc.criaElemento(lista);
	}
	
	/**
	 * 
	 * @param docTitulo
	 * @param valorTermos
	 * @param prioridade
	 * @param separador
	 * @param ordem
	 * @return
	 */
	public int criarTermos(String docTitulo, String valorTermos, int prioridade, String separador, String ordem) {
		if (docTitulo.isBlank() || docTitulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if(prioridade > 5 || prioridade < 1) {
			throw new IllegalArgumentException("Prioridade tem que ser entre 1 e 5");
		}
		Documento doc = this.documentoController.getDocumento(docTitulo);
		termosElemento termos = new termosElemento(valorTermos, prioridade, separador, ordem);
		return doc.criaElemento(termos);
	}
	
	/**
	 * retorna a representação completa do elemtno
	 * @param docTitulo titulo do documento referenciado
	 * @param elementoPosicao posicao do elemento que vai pegar a representação completa
	 * @return
	 */
	public String pegarRepresentacaoCompleta(String docTitulo, int elementoPosicao) {
		if (docTitulo.isBlank() || docTitulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(docTitulo);
		return doc.getElemento(elementoPosicao).representacaoCompleta();
	}
	
	/**
	 * retorna a representação resumida do elemtno
	 * @param docTitulo titulo do documento referenciado
	 * @param elementoPosicao posicao do elemento que vai pegar a representação resumida
	 * @return
	 */
	public String pegarRepresentacaoResumida(String docTitulo, int elementoPosicao) {
		if (docTitulo.isBlank() || docTitulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(docTitulo);
		return doc.getElemento(elementoPosicao).representacaoResumida();
	}
	
	/**
	 * Apaga um elemento
	 * @param tituloDoc titulo do documento referenciado
	 * @param elementoPosicao posição do elemento que vai ser apagado
	 * @return
	 */
	public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		return doc.removeElemento(elementoPosicao);
	}
	
	/**
	 * Move o elemento uma posicao acima
	 * @param tituloDoc titulo do documento
	 * @param elementoPosicao posição do elemento
	 */
	public void moverParaCima(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		doc.moveElementoAcima(elementoPosicao);
	}
	
	/**
	 * Move o elemento para baixo
	 * @param tituloDoc titulo do documento referenciado
	 * @param elementoPosicao posição do elemento que vai ser movido
	 */
	public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		doc.moveElementoAbaixo(elementoPosicao);
	}
	
	/**
	 * Cria um atalho
	 * @param tituloDoc titulo do documento que vai ser adicionado o atalho
	 * @param tituloDocReferenciado titulo do documento que vai virar atalho
	 * @return
	 */
	public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		Documento atalhoDoc = this.documentoController.getDocumento(tituloDocReferenciado);
		if (doc.temAtalho()) {
			throw new IllegalStateException("DOCUMENTO QUE TEM ATALHOS NÂO PODE SER ATALHO!");
		}
		if(doc.ehAtalho()) {
			throw new IllegalStateException("ATALHO NÃO PODE TER ATALHO!");
		}
		if (doc.estaCheio()) {
			throw new IllegalStateException("NUMERO MAXIMO DE ELEMENTOS JA FOI ATINGIDO!");
		}
		Atalho atalho = new Atalho(atalhoDoc.getTitulo(), atalhoDoc.mediaPrioridadeElementos());
		atalhoDoc.setAtalho();
		return doc.criaElemento(atalho);
	}
}
