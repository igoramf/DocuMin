package visoes;

import java.util.ArrayList;

import documin.documento.Documento;
import documin.elementos.Elemento;

/**
 * 
 * @author Igor Falcão
 *
 */
public class visaoResumida extends visao {

	public visaoResumida(Documento documento) {
		super(documento);
	}

	@Override
	public String[] exibeVisao() {
		String[] retorno = new String[documento.contaElementos()];
		ArrayList<Elemento> elementos = documento.getElementos();
		
		for (int i = 0; i < retorno.length; i++) {
			retorno[i] = elementos.get(i).representacaoResumida();
		}
		
		return retorno;
	}

}
