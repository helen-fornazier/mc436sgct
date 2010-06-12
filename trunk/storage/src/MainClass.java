import DataBase.DataBase;
import DataBase.StorageDB;
import DataBase.Usuario;




public class MainClass {

	/* Exemplo de uso do Storage */
	public static void main(String[] args) {
		
		StorageDB storage = new StorageDB();
		DataBase database = new DataBase();
		DataBase auxDB;
		
		auxDB = storage.loadDataBase();
		database.printDatabase(auxDB);
		
		
		Usuario user1;
		String auxCPF;
		String[] auxCPFs;
		
		//database.printDatabase(database);
		
		//Inserindo Usuarios
		database.insertUsuario("machado", "123", "Machado de Assis", "2143514646", "", 
				"", "60", "m", "false");
		database.insertUsuario("monteiro", "123", "Monteiro Lobato", "6357653275", "", 
				"", "45", "m", "false");
		database.insertUsuario("perdigao", "123", "Maria Perdigao Sadia", "735897947096343", "", 
				"", "32", "m", "false");
		database.insertUsuario("maria", "123", "Maria Clara", "7498659873285", "", 
				"", "21", "m", "false");
		
		//database.printDatabase(database);
		
		//Mudando status
		auxCPF = database.searchUsuarioLogin("machado");
		database.getListaUsuario().get(database.searchUsuario(auxCPF)).changeStatus();
		database.getListaUsuario().get(database.searchUsuario("6357653275")).changeStatus();
		auxCPFs = database.searchUsuarioNome("Maria");
		for (int i = 0; i < auxCPFs.length; i++) {
			database.getListaUsuario().get(database.searchUsuario(auxCPFs[i])).changeStatus();
		}
		
		//database.printDatabase(database);
		
		//Inserindo avaliadores
		database.insertAvaliador(auxCPFs[0], "Formado na UNIP.", "lala");
		database.insertAvaliador(auxCPFs[1], "Formado na Metodista.", "lulu");
		
		//database.printDatabase(database);
		
		//Inserindo autores
		database.insertAutor("2143514646", "lili");
		database.insertAutor("6357653275", "lolo");
		
		//database.printDatabase(database);
		
		//Inserindo material
		database.getListaAutor().get(database.searchAutor("2143514646")).insertMaterial("Pedro e Machado", "resumo1", "title1", "");
		database.getListaAutor().get(database.searchAutor("6357653275")).insertMaterial("Lobato e Jujuca", "resumo2", "title2", "");
		
		//database.printDatabase(database);
		
		//Avaliando material
		database.getListaAutor().get(0).getListaMaterial().get(0).avaliarMaterial(database.searchAvaliador("735897947096343"), 3, "");
		
		//database.printDatabase(database);
		
		//Salvando database
		storage.saveDataBase(database);
		
	}
}
