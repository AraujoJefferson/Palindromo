package prova.admatic;

import prova.admatic.controller.ArquivoProcessa;
import prova.admatic.model.Arquivo;
import prova.admatic.resource.Propriedades;

public class Inicio {

	private static final String CAMINHO_WEB = Propriedades.start().getCaminhoWeb();
	private static final String DIR_SAIDA = Propriedades.start().getDiretorioSaida();

	public static void main(String[] args) {
		Arquivo arquivo = new Arquivo(CAMINHO_WEB);
		ArquivoProcessa processa = null;
		try {
			processa = new ArquivoProcessa(arquivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		processa.processaResultado(DIR_SAIDA);
		System.out.println("Resultado gerado!");
	}
}
