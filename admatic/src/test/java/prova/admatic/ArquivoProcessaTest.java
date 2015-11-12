package prova.admatic;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

import org.junit.Test;

import prova.admatic.controller.ArquivoProcessa;
import prova.admatic.model.Arquivo;

public class ArquivoProcessaTest {
	
	@Test(expected = MalformedURLException.class)
	public void testeArquivoProcessaArquivoCaminhoVazio() throws Exception{
		Arquivo arquivo = new Arquivo("");
		new ArquivoProcessa(arquivo);
	}
	
	@Test(expected = FileNotFoundException.class)
	public void testeArquivoProcessaArquivoInexistente() throws Exception{
		Arquivo arquivo = new Arquivo("http://www.google.com.br/casa");
		new ArquivoProcessa(arquivo);
	}
	@Test(expected = UnknownHostException.class)
	public void testeArquivoProcessaArquivoUrlRuim() throws Exception{
		Arquivo arquivo = new Arquivo("http://wwgw.google.com.br");
		new ArquivoProcessa(arquivo);
	}
	
	
	@Test
	public void testeInverterPalavra(){
		ArquivoProcessa processa = null;
		try {
			processa = new ArquivoProcessa(new Arquivo("http://www.google.com.br"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String palavra = new String("Jefferson");
		assertEquals(new String("nosreffeJ"), processa.invertePalavra(palavra)); ;
	}
	
	@Test
	public void testeRealizaTratamento(){
		ArquivoProcessa processa = null;
		try {
			processa = new ArquivoProcessa(new Arquivo("http://www.google.com.br"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		String palavra = new String("\\/c3á-SsR~&è");
		assertEquals(new String("caSsRe"), processa.realizaTratamentos(palavra)); ;
	}
}
