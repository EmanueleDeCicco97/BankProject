package it.emanuele;
import java.util.ArrayList;
import java.util.Scanner;

public class Operazioni{

	private ArrayList<Correntista> correntista = new ArrayList<Correntista>();
	private Scanner in = new Scanner(System.in);
	
	public void azzera() {
		correntista.clear();
	}

	
	public void caricamento() {               					  //caricamento Utenti
		String nome;
		String cognome;
		String cf;
		String n_conto;
		double saldo=0;
		boolean verifica; 
		int np; 
		System.out.println("Quante persone vuoi registrare");  //scelta quantità persona da caricare
		np=Integer.parseInt(in.nextLine());
		
		
		for(int i=0;i<np;i++) {           					 //ciclo di caricamento
			verifica=true;
			System.out.println("Inserisci il Nome del propietario del "+(i+1)+ " conto");
			nome=in.nextLine();
			System.out.println("Inserire il Cognome del propietario del "+(i+1)+" conto");
			cognome=in.nextLine();
			System.out.println("Inserire il Codice Fiscale del propietario del "+(i+1)+" conto");
			cf=in.nextLine();
			
			System.out.println("Dammi il numero del conto della "+(i+1)+" conto");
			n_conto=in.nextLine();
		
			
			for(int j=0; j<correntista.size(); j++) { 	//controllo
				for(int s=0; s<correntista.get(j).conto.size();s++) {
				if(this.correntista.get(j).conto.get(s).getNumero_conto().equals(n_conto)) {
					System.out.println(" conto gia esistente");
					i--;
					verifica=false;
				}
				}
				}
			
			if(verifica) {
				
			System.out.println("Inserisci il saldo"); 	  //inserimento Denaro
			boolean ver=false;
			while(!ver) {
				
			try {
				
			saldo=Double.parseDouble(in.nextLine());
			ver=true;
			
			}catch(Exception e) {
				
			ver=false;
			System.out.println("Riprova");
			
			}
			}
			
			for(int j=0;j<correntista.size();j++) {   		 //controllo
				if(correntista.get(j).getCf().equals(cf)) {
					if(correntista.get(j).getNome().equals(nome) && correntista.get(j).getCognome().equals(cognome)) {
					System.out.println("Conto aggiunto a persona esistente");
					this.correntista.get(j).conto.add(new Conto(n_conto, saldo));
					verifica=false;
				}else{
					System.out.println("Hai inserito un Codice Fiscale gia registrato");
					verifica=false;
					i--;
				}
				}
			}
			}
			
			if(verifica) {
			this.correntista.add(new Correntista(nome, cognome,cf,n_conto,saldo));
			System.out.println("Utente inserito");
			}
		}
		}

	public void stampa() {  								 //stampa dei valori
		
			System.out.println(correntista);
		
	}
	
	public void ordinamento() { 							 //ordinamento dei valori
		Correntista temp = new Correntista("","","","",0.00); 
		
		int verifica; 
		
		for(int i=0;i<correntista.size();i++) {  			//ciclo verifica (controllo)
			for(int j=0;j<correntista.size();j++) {
				verifica = correntista.get(i).getCognome().compareToIgnoreCase(correntista.get(j).getCognome());
				if(verifica<0) {
				
					temp.setCorrentista(correntista.get(i)); 
					correntista.get(j).setCorrentista(temp);
				}
			}
		}
		
		stampa();
	}
	
	public void modifica() { 								 //opzione modifica dati in base al codice fiscale
		
		String nome;
		String cognome;
		String cf;
		System.out.println("Inserisci il nome");
		nome=in.nextLine();
		System.out.println("Inserisci il cognome");
		cognome=in.nextLine();

		for(int i=0;i<correntista.size();i++) {  		  //inserimento
			if(correntista.get(i).getNome().equals(nome) && correntista.get(i).getCognome().equals(cognome)) {
				System.out.println(correntista.get(i));	
			}
		}
		
		System.out.println("Inserisci il Codice Fiscale della persona che vuoi modificare");   		//inserimento codice fiscale
		cf=in.nextLine();
		for(int i=0;i<correntista.size();i++) {
		if(correntista.get(i).getNome().equals(nome) && correntista.get(i).getCognome().equals(cognome) && correntista.get(i).getCf().equals(cf)) {
			
			System.out.println("Inserisci il nuovo nome");
			correntista.get(i).setNome(in.nextLine());
			System.out.println("Inserisci il nuovo cognome");
			correntista.get(i).setCognome(in.nextLine());
			System.out.println("Modifica andata a buon fine");
		}
		}
	}
	
	public void prelievo() {   // Prelievo
		boolean verifica=false; 
		int scelta=0; 
		int prelievo=0; 
		String appoggio; 
		System.out.println("1)Prelievo in base al Codice Fiscale");
		System.out.println("2)Prelievo in base al numero del conto");
		
		
		scelta=Integer.parseInt(in.nextLine());
		switch(scelta) {
		case 1:
			System.out.println("Inserisci il Codice Fiscale");
			appoggio=in.nextLine();
			
			for(int i=0;i<correntista.size();i++) {
				if(correntista.get(i).getCf().equals(appoggio)) { 		 //inserimento del codice fiscale
					if(correntista.get(i).conto.size()>1) { 
						System.out.println("L'utente ha più conti registrati, fai la ricerca con numero conto");
					}else{
					System.out.println("Saldo disponibile "+correntista.get(i).conto.get(0).getSaldo());
					System.out.println("Quanto vuoi prelevare?");
					boolean ver=false;
					while(!ver) {
						
					try {
						
					prelievo=Integer.parseInt(in.nextLine());
					ver=true;
					
					}catch(Exception e) {
						
					ver=false;
					System.out.println("Riprova");
					
					}
					}
					if(prelievo>correntista.get(i).conto.get(0).getSaldo()) {		 //controllo prelievo
					System.out.println("Impossibile svolgere l'operazione");
					}else{
					correntista.get(i).conto.get(0).setSaldo((correntista.get(i).conto.get(0).getSaldo()-prelievo));
					System.out.println("Prelievo eseguito correttamente");
					verifica=true;
					}
					}
				}
			}
			break;
		case 2:
			System.out.println("Inserisci il Numero del Conto");  			  //inserimento numero conto
			appoggio=in.nextLine();
			for(int i=0;i<correntista.size();i++) {
				for(int j=0;j<correntista.get(i).conto.size();j++) {
				if(correntista.get(i).conto.get(j).getNumero_conto().equals(appoggio)) {
					System.out.println("Saldo disponibile  "+correntista.get(i).conto.get(j).getSaldo());
					System.out.println("Quanto vuoi prelevare?");
					boolean ver=false;
					while(!ver) {
						
					try {
						
					prelievo=Integer.parseInt(in.nextLine());
					ver=true;
					
					}catch(Exception e) {
						
					ver=false;
					System.out.println("Riprova");
					
					}
					}
					if(prelievo>correntista.get(i).conto.get(j).getSaldo()) { 		//controllo
					System.out.println("Impossibile svolgere l'operazione");
					}else{
					correntista.get(i).conto.get(j).setSaldo((correntista.get(i).conto.get(j).getSaldo()-prelievo));
					System.out.println("Prelievo eseguito correttamente");
					verifica=true;
					}
				}
			}
			}
			if(!verifica) {
				System.out.println("Non e' stato possibile effettuare la ricerca");
			}
			
			
			break;
		default:
			System.out.println("Chiusura");
			break;
		}	
		
	}

	public void versamento() { //versamento
		
		boolean verifica; 
		int versamento=0; 
		int scelta=0;
		String appoggio;
		System.out.println("Versamento:");
		stampa();
		
		System.out.println("1)Versamento in base al Codice Fiscale");
		System.out.println("2)Versamento in base al Numero del Conto");
		
		
		verifica=false;
		while(!verifica) {     //controllo 
		try {
		scelta = Integer.parseInt(in.nextLine());
		verifica=true;
		}catch(Exception e) {
		verifica=false;
		System.out.println("Riprova");
		}
		}
		
		
		verifica=false;
		switch(scelta) {
		case 1:
			System.out.println("Inserisci il Codice Fiscale");     //inserimento codice fiscale
			appoggio=in.nextLine();
			
			for(int i=0;i<correntista.size();i++) {                //controllo inserimento del codice fiscale
				if(correntista.get(i).getCf().equals(appoggio)) {
					if(correntista.get(i).conto.size()>1) {
						System.out.println("ci sono più conti registrati, fai la ricerca tramite numero conto");
					}else{
					System.out.println("Saldo disponibile "+correntista.get(i).conto.get(0).getSaldo());
					System.out.println("Quanto vuoi versare?");
					boolean ver=false;
					while(!ver) {
						
					try {
						
					versamento=Integer.parseInt(in.nextLine());
					ver=true;
					
					}catch(Exception e) {
						
					ver=false;
					System.out.println("Riprova");
					
					}
					}
					correntista.get(i).conto.get(0).setSaldo((correntista.get(i).conto.get(0).getSaldo()+versamento));
					System.out.println("Versamento eseguito con successo");
					verifica=true;
					}
				
				}
			}
			break;
		case 2:
			System.out.println("Inserisci il Numero del Conto");      //inserimento del conto
			appoggio=in.nextLine();
			for(int i=0;i<correntista.size();i++) {
				for(int j=0;j<correntista.get(i).conto.size();j++) {
				if(correntista.get(i).conto.get(j).getNumero_conto().equals(appoggio)) {
					System.out.println("Il saldo disponibile è di "+correntista.get(i).conto.get(j).getSaldo());
					System.out.println("Quanto vuoi versare?");
					boolean ver=false;
					while(!ver) {
						
					try {
						
					versamento=Integer.parseInt(in.nextLine());
					ver=true;
					
					}catch(Exception e) {
						
					ver=false;
					System.out.println("Riprovaa");
					
					}
					}
					correntista.get(i).conto.get(j).setSaldo((correntista.get(i).conto.get(j).getSaldo()+versamento));
					System.out.println("Versamento eseguito con successo");
					verifica=true;
					}
			}
			}
			if(!verifica) {
				System.out.println("Non e' stato possibile effettuare la ricerca");
			}
			
			break;
		default:
			System.out.println("Chiusura");
			break;
		}		
		if(!verifica) {
			System.out.println("Non e' stato possibile effettuare il versamento");
		}
}
}