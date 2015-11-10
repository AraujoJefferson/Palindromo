package prova.admatic.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.Normalizer;
import java.util.ArrayList;

import prova.admatic.model.Arquivo;

public class ArquivoProcessa {
	
	private Arquivo arquivo;
	private ArrayList<String> arquivoConteudo;
	private ArrayList<String> arquivoConteudoInvertido;
	

	public ArquivoProcessa(Arquivo arquivo){
		this.arquivo = arquivo;
		this.arquivoConteudo = new ArrayList<String>();
		this.arquivoConteudoInvertido = new ArrayList<String>();
		buscaTrataArquivo(this.arquivo.getCaminhoWeb());
	}

	public void processaResultado(String diretorio) {
		ArquivoGrava grava = new ArquivoGrava();
		grava.gravarArquivo(diretorio,new String("resultado"), geraResultado());
	}
	
	private ArrayList<String> geraResultado(){
		ArrayList<String> resultado = new ArrayList<String>();
		int qtdRegistros = this.arquivoConteudo.size();
		String palavra;
		String palavraInvertida;
		
		for(int i = 0; i < qtdRegistros; i++){
			palavra = arquivoConteudo.get(i);
			palavraInvertida = arquivoConteudoInvertido.get(i);
			
			if(palavra.toCharArray().length <= 1){
				resultado.add(new String("não"));
			}else{
				if(palavra.equals(palavraInvertida)){
					resultado.add(new String("sim"));
				}else{
					resultado.add(new String("não"));
				}
			}
		}
		return resultado;
	}
	
	private void buscaTrataArquivo(String caminhoWeb){
		try{
			URL url = new URL(caminhoWeb);
		
			BufferedReader in =
	                new BufferedReader(new InputStreamReader(url.openStream()));
	
	        String inputLine;
	        String palavra;
	
	        while ((inputLine = in.readLine()) != null) {
	        	palavra = realizaTratamentos(inputLine.toString());
	        	
	        	this.arquivoConteudo.add(palavra);
	        	this.arquivoConteudoInvertido.add(invertePalavra(palavra));
	        }
	        in.close();
		}catch(FileNotFoundException fnf){
			System.out.println("O arquivo não foi encontrado: "+ fnf.getMessage());			
		}catch(UnknownHostException uhe){
			System.out.println("Não foi possível buscar o arquivo: "+ uhe.getMessage());			
		}catch (Exception e) {  
	        System.out.println("Problema na leitura do arquivo: ");
	        e.printStackTrace();
	    }  		
	}
	
	private String invertePalavra(String palavra){
		String invertido = new String();
		char[] charArray = palavra.toCharArray();
		for(int i = (charArray.length - 1); i >= 0 ; i--){
			invertido = invertido + charArray[i];
		}
		return invertido;
	}
	
	private String realizaTratamentos(String palavra){
		if(palavra == null || palavra.isEmpty()){
			return new String("");
		}
		String trat1 = trataAcentuacao(palavra);
		String trat2 = trataCaracteresEspeciais(trat1);
		
		return trat2;
	}
	
	private String trataCaracteresEspeciais(String palavra){
		return palavra.replaceAll("[^a-zA-Z]", "");
	}
	
	private String trataAcentuacao(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
}
