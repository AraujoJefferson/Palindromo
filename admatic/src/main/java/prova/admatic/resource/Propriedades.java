package prova.admatic.resource;

import java.io.FileInputStream;
import java.util.Properties;

public class Propriedades {
	private static Properties props = null;

	public static Propriedades start() {
		Propriedades propriedades = new Propriedades();
		FileInputStream file;
		try {
			file = new FileInputStream("./propriedade/caminhos.properties");

			propriedades.props = new Properties();
			propriedades.props.load(file);

		} catch (Exception e) {
			System.out.println("Propriedade não encontrada: " + e.getMessage());
		}
		return propriedades;
	}

	public String getCaminhoWeb() {
		return props.getProperty("CAMINHO_WEB");
	}

	public String getDiretorioSaida() {
		return props.getProperty("DIR_SAIDA");
	}
}
