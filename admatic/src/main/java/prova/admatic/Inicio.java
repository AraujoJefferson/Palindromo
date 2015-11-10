package prova.admatic;

import prova.admatic.controller.ArquivoProcessa;
import prova.admatic.model.Arquivo;

public class Inicio 
{
	private static final String CAMINHO_WEB = new String("http://alcor.concordia.ca/~vjorge/Palavras-Cruzadas/Lista-de-Palavras.txt");
	private static final String DIR_SAIDA = new String("/home/jefferson");
    public static void main( String[] args )
    {
    	Arquivo arquivo = new Arquivo(CAMINHO_WEB);
        ArquivoProcessa processa = new ArquivoProcessa(arquivo);
        processa.processaResultado(DIR_SAIDA);
        System.out.println("Resultado gerado!");
//		System.out.println(realizaTratamentos("\\/c3á-SsR~&è"));
    }
}
