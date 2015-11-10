package prova.admatic.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ArquivoGrava {
	public void gravarArquivo(String caminho, String nome, ArrayList<String> conteudo){
		FileWriter resultadoArquivo = null;
		try {
			resultadoArquivo = new FileWriter(caminho+"/"+nome+".txt");
		
		    PrintWriter gravaConteudo = new PrintWriter(resultadoArquivo);
		    for(int i = 0; i < conteudo.size() ;i++){
		    	gravaConteudo.println(conteudo.get(i));
		    }
	
		    resultadoArquivo.close();
		} catch (IOException e) {
			System.out.println("Erro ao criar arquivo: ");
			e.printStackTrace();
		}
	}
}
