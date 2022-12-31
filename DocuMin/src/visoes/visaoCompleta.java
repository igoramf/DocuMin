package visoes;

import java.util.ArrayList;

import documin.documento.Documento;
import documin.elementos.Elemento;

public class visaoCompleta extends visao {

	public visaoCompleta(Documento documento) {
		super(documento);
	}

	@Override
	public String[] exibeVisao() {
		String[] retorno = new String[documento.contaElementos()];
		ArrayList<Elemento> elementos = documento.getElementos();
		
		for (int i = 0; i < retorno.length; i++) {
			retorno[i] = elementos.get(i).representacaoCompleta();
		}
		return retorno;
	}

}
