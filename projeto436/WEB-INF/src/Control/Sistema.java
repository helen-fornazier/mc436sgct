package Control;

import DataBase.DataBase;
import DataBase.StorageDB;

public class Sistema {
	public ControleDeLogin cLogin;
	public ControleDeSubmissao cAvaliacao;
	public ControleDeSubmissao cSubmissao;

	public Sistema () {
		this.cLogin = new ControleDeLogin();
		//this.cAvaliacao = new ControleDeAvaliacao();
		//this.cSubmissao = new ControleDeSubmissao();
	}
	
}