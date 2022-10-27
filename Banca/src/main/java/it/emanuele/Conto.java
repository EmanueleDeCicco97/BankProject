package it.emanuele;

public class Conto {

	private String numero_conto;
	private double saldo;
	
	public Conto(String numero_conto, double saldo) {
		setNumero_conto(numero_conto);
		setSaldo(saldo);
	}
	
	@Override
	public String toString() {
		return "Conto [numero_conto=" + numero_conto + ", saldo=" + saldo + "]";
	}
	
	public String getNumero_conto() {
		return numero_conto;
	}
	public void setNumero_conto(String numero_conto) {
		this.numero_conto = numero_conto;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
