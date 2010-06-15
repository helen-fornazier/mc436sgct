package Control;

import DataBase.DataBase;
import DataBase.StorageDB;

public class Sistema {
	public ControleDeLogin cLogin;
	public ControleDeAvaliacao cAvaliacao;
	public ControleDeSubmissao cSubmissao;

	public Sistema () {
		this.cLogin = new ControleDeLogin(this);
		this.cAvaliacao = new ControleDeAvaliacao(this);
		this.cSubmissao = new ControleDeSubmissao(this);
	}
	
}