package visoes;

import documin.documento.Documento;

/**
 * 
 * @author Igor Falcão
 *
 */

public abstract class visao {
	protected Documento documento;
	
	public visao(Documento documento) {
		this.documento = documento;
	}
	
	public abstract String[] exibeVisao();
}
