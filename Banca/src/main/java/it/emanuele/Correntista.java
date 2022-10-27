package it.emanuele;
import java.util.ArrayList;

public class Correntista  {

	private String nome;
	private String cognome;
	private String cf;
	
	ArrayList<Conto> conto = new ArrayList<Conto>();
	
	
	@Override
	public String toString() {
		return "Correntista [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", conto=" + conto + "]";
	}


	public Correntista(String nome, String cognome, String cf, String numero_conto, double saldo) {
		this.nome=nome;
		this.cognome=cognome;
		this.cf=cf;
		this.conto.add(new Conto(numero_conto, saldo));
		
	}

	public void setCorrentista(Correntista corr) {
		this.nome = corr.getNome();
		this.cognome = corr.getCognome();
		this.cf= corr.getCf();
		
		conto.clear();
		if(corr.conto.size()>1) {
			for(int i=0;i<corr.conto.size();i++) {
				this.conto.add(new Conto(corr.conto.get(i).getNumero_conto(),corr.conto.get(i).getSaldo()));
			}
		}
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getCf() {
		return cf;
	}


	public void setCf(String cf) {
		this.cf = cf;
	}
}