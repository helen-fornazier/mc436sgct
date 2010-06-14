package DataBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StorageDB {
	
	
	/* Salva o objeto DataBase */
	public void saveDataBase(DataBase database){
		try{
			FileOutputStream fileOut = new FileOutputStream("database.sav");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(database);
			out.close();
			fileOut.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* Carrega o objeto DataBase */
	public DataBase loadDataBase() {
		
		DataBase database = null;
		
		try{
			FileInputStream fileIn = new FileInputStream("database.sav");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			database = (DataBase) in.readObject();
			in.close();
			fileIn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException i) {
			i.printStackTrace();
		}
		
		return database;
	}
	
}
