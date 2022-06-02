package view;
import javax.swing.JOptionPane;
import controller.StreamController;
import controller.IArquivoController;
public class FiltrarInformaçoes {
	
	public static void main(String[]args) {
		String ano = JOptionPane.showInputDialog("Qual o ano?");
		String mes = JOptionPane.showInputDialog("Qual o mes?");
		
		IArquivoController arqCont = new StreamController();
		String Registro = "";
		String dirWin = "C:\\Windows";
		String path = "C:\\TEMP";
		String nome = "SteamCharts.csv";
		String dirWin2 = "C:\\Windows";
		String path2 = "C:\\TEMP";
		String nome2 = "Nome e media de jogadores";
		System.out.println(ano);
		System.out.println(mes);
		try {
			arqCont.readFile(path, nome, ano, mes,Registro);
			arqCont.createFile(path2, nome2,Registro);
		} catch (Exception e) {
			
		}
	
		
	}

}