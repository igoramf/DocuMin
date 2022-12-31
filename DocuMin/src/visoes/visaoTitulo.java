package visoes;

import java.util.ArrayList;

import documin.documento.Documento;
import documin.elementos.Elemento;
import documin.elementos.tituloElemento;


/**
 * 
 * @author Igor Falcão
 *
 */
public class visaoTitulo extends visao {

	public visaoTitulo(Documento documento) {
		super(documento);
	}

	@Override
	public String[] exibeVisao() {
		String[] retorno = new String[this.qntdElementosTitulo()];
		ArrayList<Elemento> elementos = this.documento.getElementos();
		for (int i = 0; i < elementos.size(); i++) {
			if(elementos.get(i) instanceof tituloElemento) {
				retorno[i] = elementos.get(i).representacaoResumida();
			}
			
		}
		return null;
	}
	
	/**
	 * Retorna a quantidade de elementos que são do tipo titulo.
	 * @return
	 */
	private int qntdElementosTitulo() {
		int retorno = 0;
		ArrayList<Elemento> elementos = this.documento.getElementos();
		for (int i = 0; i < elementos.size(); i++) {
			if(elementos.get(i) instanceof tituloElemento) {
				retorno++;
			}
		}
		return retorno;
	}

}
