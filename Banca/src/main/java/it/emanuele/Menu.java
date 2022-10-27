package it.emanuele;
import java.util.Scanner;

public class Menu {
	
	Scanner in = new Scanner(System.in);
	private boolean charge; 
	private int scelta=0; 
	
public void ScMenu(Operazioni operazioni) {
	
	boolean verifica;
	charge=false;
	
	while(scelta!=7) {
	System.out.println("-----------------------------------------");
	System.out.println("|1)Inserisci utente		        |");
	System.out.println("|2)Modifica dei dati dell'utente        |");
	System.out.println("|3)Ordina in base al cognome e stampa   |");
	System.out.println("|4)Prelievo		                |");
	System.out.println("|5)Versamenti		                |");
	System.out.println("|6)Stampa utenti		        |");
	System.out.println("|7)Esci		                        |");
	System.out.println("-----------------------------------------");
	
	verifica=false;
	while(!verifica) { //controllo
	try {
	scelta = Integer.parseInt(in.nextLine());
	verifica=true;
	}catch(Exception e) {
	verifica=false;
	System.out.println("Riprova");
	}
	}
	
	switch(scelta)
	{
	case 1:
		operazioni.caricamento();
		charge=true;
		break;
	case 2:
		if(charge) {
			operazioni.modifica();
		}else {
			System.out.println("Non puoi modificare senza aver caricato ");
		}
		break;
	case 3:
		if(charge) {
			operazioni.ordinamento();
		}else {
			System.out.println("Non puoi ordinare senza aver caricato ");
		}
		break;
	case 4:
		if(charge) {
			operazioni.prelievo();
		}else {
			System.out.println("Non puoi prelevare senza aver caricato ");
		}
		break;
	case 5:
		if(charge) {
			operazioni.versamento();
		}else {
			System.out.println("Non puoi versare senza aver caricato");
		}
		break;
	case 6:
		if(charge) {
			operazioni.stampa();
		}else {
			System.out.println("Non puoi Stampare senza aver caricato");
		}
		break;
	case 7:
		System.out.println("Chiusura");
		break;
	default:
		System.out.println("Hai sbagliato pulsante");
		break;
		}
	  }
    }
 }