package visoes;

import java.util.ArrayList;

import documin.documento.Documento;
import documin.documento.DocumentoController;

/**
 * 
 * @author Igor Falcão
 *
 */
public class visaoController {
	
	private DocumentoController documentoController;
	private ArrayList<visao> visoes;
	
	/**
	 * Construtor de visao que referencia o documentoController
	 * @param documentoController
	 */
	public visaoController(DocumentoController documentoController) {
		this.documentoController = documentoController;
		this.visoes = new ArrayList<visao>();
	}
	
	/**
	 * Cria uma visao completa do documento
	 * @param tituloDoc titulo do documento referenciado
	 * @return
	 */
	public int criarVisaoCompleta(String tituloDoc) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		visaoCompleta v = new visaoCompleta(doc);
		this.visoes.add(v);
		return visoes.indexOf(v);
	}
	
	/**
	 * Cria uma visao resumida do documento
	 * @param tituloDoc titulo do documento referenciado
	 * @return
	 */
	public int criaVisaoResumida(String tituloDoc) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		visaoResumida v = new visaoResumida(doc);
		this.visoes.add(v);
		return visoes.indexOf(v);	
	}
	
	/**
	 * Cria uma visaoPrioritaria do documento referenciado
	 * @param tituloDoc titulo do documento referenciado
	 * @param prioridade valor minimo de prioridade dos elementos
	 * @return
	 */
	public int visaoPrioritaria(String tituloDoc, int prioridade) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		visaoPrioritaria v = new visaoPrioritaria(doc, prioridade);
		this.visoes.add(v);
		return visoes.indexOf(v);
	}
	
	/**
	 * Cria uma visao de titulo
	 * @param tituloDoc titulo do documento referenciado
	 * @return
	 */
	public int visaoTitulo(String tituloDoc) {
		if (tituloDoc.isBlank() || tituloDoc.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento doc = this.documentoController.getDocumento(tituloDoc);
		visaoTitulo v = new visaoTitulo(doc);
		this.visoes.add(v);
		return this.visoes.indexOf(v);
	}
	
	/**
	 * Exibe uma visao
	 * @param visaold numero da visao desejada
	 * @return
	 */
	public String[] exibirVisao(int visaold) {
		if(visaold > visoes.size()) {
			throw new IndexOutOfBoundsException("NUMERO DE VISAO INVALIDO!");
		}
		return this.visoes.get(visaold).exibeVisao();
	}
}
