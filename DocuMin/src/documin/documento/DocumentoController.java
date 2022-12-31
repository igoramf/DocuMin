package documin.documento;

import java.util.HashMap;
import java.util.NoSuchElementException;
/**
 * 
 * @author Igor Falcão
 *
 */

public class DocumentoController {
	/**
	 * HashMap para armazenar os documentos
	 */
	private HashMap<String, Documento> documentosMap;
	
	/**
	 * Constrói o controlador de documentos
	 *
	 */
	public DocumentoController() {
		this.documentosMap = new HashMap<>();
	}
	
	 /**
	  * Cria um documento
	  * @param titulo titulo que vai referenciar o documento
	  * @return
	  */
	public boolean criarDocumento(String titulo) {
		if(documentosMap.containsKey(titulo)) {
			return false;
		}
		if (titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento documento = new Documento(titulo);
		return documentosMap.put(titulo, documento) != null;
	}
	
	/**
	 * Cria um documento com tamanho maximo de elementos
	 * @param titulo titulo que vai referenciar o documento
	 * @param tamanhoMaximo tamanho maximo de elementos no documentos
	 * @return
	 */
	public boolean criarDocumento(String titulo, int tamanhoMaximo) {
		if(documentosMap.containsKey(titulo)) {
			return false;
		}
		if (titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		Documento documento = new Documento(titulo, tamanhoMaximo);
		return documentosMap.put(titulo, documento) != null;
	}
	
	/**
	 * remove um documento
	 * @param titulo
	 */
	public void removerDocumento(String titulo) {
		if(titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if(!documentosMap.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		documentosMap.remove(titulo);
	}
	
	/**
	 * Retorna a quantidade de elementos no documento
	 * @param titulo titulo do documento 
	 * @return
	 */
	public int contarElementos(String titulo) {
		if(titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if(!documentosMap.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		Documento doc = documentosMap.get(titulo);
		return doc.contaElementos();
	}
	
	
	/**
	 * Retorna um array de String com as representações dos elementos do documento
	 * @param titulo titulo do documento
	 * @return
	 */
	public String[] exibirDocumento(String titulo) {
		if (titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if(!documentosMap.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		Documento doc = documentosMap.get(titulo);
		return doc.exibirDocumento();
	}
	
	/**
	 * Retorna um documento
	 * @param titulo titulo do documento que vai ser retornado
	 * @return
	 */
	public Documento getDocumento(String titulo) {
		if (titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException("TÍTULO NÃO PODE SER VAZIO");
		}
		if(!documentosMap.containsKey(titulo)) {
			throw new NoSuchElementException();
		}
		return documentosMap.get(titulo);
	}
}
