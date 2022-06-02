package controller;

import java.io.IOException;

public interface IArquivoController {

	 public void readFile(String path,String nome,String ano,String mes,String Registro) throws IOException;
	 public void createFile(String path2, String nome2,String Registro) throws IOException;

	}
