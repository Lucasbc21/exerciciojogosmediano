package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class StreamController implements IArquivoController{

	public StreamController (){
		super();
	}

	@Override
	public void readFile(String path, String nome,String ano,String mes,String Registro) throws IOException {
		
		File arq = new File (path,nome);
		if(arq.exists() && arq.isFile()) {
		FileInputStream fluxo = new FileInputStream(arq);
		InputStreamReader leitor = new InputStreamReader(fluxo);
		BufferedReader buffer = new BufferedReader(leitor);
		String linha = buffer.readLine();
		System.out.println("Nome do jogo                   |                  Media de jogadores ativos");
		
		while(linha != null) {
			String[] fileiradaVirgula = linha.split(",");
			if (fileiradaVirgula[1].equals(ano) && fileiradaVirgula[2].equals(mes)){
			
			 System.out.println(fileiradaVirgula[0]+"              |          "+fileiradaVirgula[5] );
			//	System.out.println(Registro);
             Registro = fileiradaVirgula[0]+"                   |                   "+fileiradaVirgula[5] ;
			 }
			 linha = buffer.readLine();

		}
		 
		 buffer.close();
		 leitor.close();
		 fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
			
		}
		
		
	}

	@Override
	public void createFile(String path2, String nome2,String Registro) throws IOException {
		File dir = new File(path2);
		File arq = new File(path2, nome2 + ".csv");
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt(Registro);
			FileWriter fileWriter = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretorio inválido");
		}
		
	}

	private String geraTxt(String Registro) {
		StringBuffer buffer = new StringBuffer();
		String linhasaida = "";
		
			
			if (!linhasaida.equalsIgnoreCase("null")) {
				linhasaida = Registro;
				buffer.append(linhasaida+"\n");
			}
		
			return buffer.toString();
		}

	
}
