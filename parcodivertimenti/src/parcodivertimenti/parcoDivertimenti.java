package parcodivertimenti;

public class parcoDivertimenti {

	public static void main(String[] args) {

		// Variabili generali, giorni di apertura, visitatori giornalieri, guadagno netto totale, guadagno netto giornaliero
		
		int daysOpen = 3; 
		int visitors = 200;
		int totalNet = 0; 
		int dailyNet = 0;

		int totalSatisfied = 0; // Numero di soddisfatti totali
		String mostVisited = ""; // La giostra piu visitata

		// Definizione variabili delle atrazioni
		
		String haunted = "Haunted House"; // Nome
		int capacityH = 8; // Posti disponibili ogni giro
		int costH = 22; // Costo operativo
		int ticketH = 9; // Costo biglietto
		int turnsH = 6; // Giri massimi giornalieri
		int currentCapacityH = 0; // Posti occupati 
		int earnedH = 0; // Guadagno 

		String roller = "Roller Coaster";
		int capacityR = 7;
		int costR = 15;
		int ticketR = 8;
		int turnsR = 5;
		int currentCapacityR = 0;
		int earnedR = 0;

		String tower = "Drop Tower";
		int capacityT = 5;
		int costT = 14;
		int ticketT = 5;
		int turnsT = 8;
		int currentCapacityT = 0;
		int earnedT = 0;
		
		String cars = "Bumper Cars";
		int capacityC = 10;
		int costC = 20;
		int ticketC = 7;
		int turnsC = 8;
		int currentCapacityC = 0;
		int earnedC = 0;

		// Dichiarazione e assegnazione variabili che contengono il numero di visitatori gionalieri/totali per ogni attrazione

		int visitedH = 0;
		int totalVisitedH = 0;
		int visitedR = 0;
		int totalVisitedR = 0;
		int visitedT = 0;
		int totalVisitedT = 0;
		int visitedC = 0;
		int totalVisitedC = 0;

		// Dichiarazione e assegnazione variabili che contengono il numero di tempo di
		// attesa totale per ogni attrazione

		int totalWaitTimeH = 0;
		int totalWaitTimeR = 0;
		int totalWaitTimeT = 0;
		int totalWaitTimeC = 0;

		// Apertura ciclo giornaliero

		for (int a = 0; a < daysOpen; a++) {

			// Generazione tempo di attesa per ogni attrazione
			
			int waitTimeH = (int) (Math.random() * 10 + 2);
			int waitTimeR = (int) (Math.random() * 10 + 2);
			int waitTimeT = (int) (Math.random() * 10 + 2);
			int waitTimeC = (int) (Math.random() * 10 + 2);
			
			// Apertura ciclo dei visitatori

			for (int i = 0; i < visitors; i++) {
				
				// Generazione budget, pazienza, scelta delle attrazioni

				int budget = (int) (Math.random() * 20 + 2);
				int freeTime = (int) (Math.random() * 10 + 3);
				int choice = (int) (Math.random() * 4);
				
				boolean happy = false; // Serve per poi gestire la soddisfazione (se sale su almeno una giostra questo diventa TRUE)
				String userChoices = ""; // Variabile che contiene le scelte dell attrazione di ogni utente

				// Finche il visitatore non ha provato a salire su tutte le giostre, continua a provare a salire
				
				while (userChoices.length() < 4) {

					// Se la giostra scelta e tra le giostre visitate in precedenza, genera una nuova scelta
					
					if (userChoices.contains(String.valueOf(choice)))
						choice = (int) (Math.random() * 4);
					
					// Se la giostra scelta e Haunted House, e il visitatore non ha mai provato a salire su questa giostra, entra dentro questo IF
					
					if (choice == 0 && !(userChoices.contains(String.valueOf(choice)))) {
						
						// Controllo se budget e pazienza sono sufficienti
						
						if (budget >= ticketH && freeTime >= waitTimeH) {
							
							// Controllo se l'attrazione ha raggiunto il numero massimo di giri giornalieri
							
							if (currentCapacityH < capacityH * turnsH) {
								
								// Aggiornamento valori: tempo di attesa totale, capacita corrente
								// dell'attrazione, visitatori giornalieri, guadagno giornaliero

								budget -= ticketH;
								totalWaitTimeH += waitTimeH;
								currentCapacityH++;
								happy = true;
								visitedH++;
								earnedH += ticketH;
							}
						}
					} else if (choice == 1 && !(userChoices.contains(String.valueOf(choice)))) {

						if (budget >= ticketR && freeTime >= waitTimeR) {

							if (currentCapacityR < capacityR * turnsR) {
								budget -= ticketR;
								totalWaitTimeR += waitTimeR;
								currentCapacityR++;
								happy = true;
								visitedR++;
								earnedR += ticketR;
							}
						}
					} else if (choice == 2 && !(userChoices.contains(String.valueOf(choice)))) {

						if (budget >= ticketT && freeTime >= waitTimeT) {

							if (currentCapacityT < capacityT * turnsT) {
								budget -= ticketT;
								totalWaitTimeT += waitTimeT;
								currentCapacityT++;
								happy = true;
								visitedT++;
								earnedT += ticketT;
							}
						}
					} else if (choice == 3 && !(userChoices.contains(String.valueOf(choice)))) {

						if (budget >= ticketC && freeTime >= waitTimeC) {

							if (currentCapacityC < capacityC * turnsC) {
								budget -= ticketC;
								totalWaitTimeC += waitTimeC;
								currentCapacityC++;
								happy = true;
								visitedC++;
								earnedC += ticketC;
							}
						}
					}
					
					// Aggiornamento variabile che contiene tutte le attrazioni scelte
					
					if (userChoices.length() != 4 && !(userChoices.contains(String.valueOf(choice))))
						userChoices += String.valueOf(choice);

					// Aggiornamento soddisfatti giornalieri

					if (happy && userChoices.length() == 4) {
						totalSatisfied++;}
				}
			}
			
			// Aggiornamento numero totale di visitatori su tutti i giorni

			totalVisitedH += visitedH;
			totalVisitedR += visitedR;
			totalVisitedT += visitedT;
			totalVisitedC += visitedC;
			
			// Calcolo il numero di giri giornalieri effettuati per ogni giostra

			double turnsCompletedH = Math.ceil((double) visitedH / capacityH);
			double turnsCompletedR = Math.ceil((double) visitedR / capacityR);
			double turnsCompletedT = Math.ceil((double) visitedT / capacityT);
			double turnsCompletedC = Math.ceil((double) visitedC / capacityC);

			// Calcolo il netto giornaliero per ogni attrazione

			dailyNet += earnedH - ((int) turnsCompletedH) * costH;
			dailyNet += earnedR - ((int) turnsCompletedR) * costR;
			dailyNet += earnedT - ((int) turnsCompletedT) * costT;
			dailyNet += earnedC - ((int) turnsCompletedC) * costC;

			// Aggiornamento del guadagno netto e reset dei guadagni giornalieri

			totalNet += dailyNet;
			dailyNet = 0;
			earnedH = 0;
			earnedR = 0;
			earnedT = 0;
			earnedC = 0;

			// Reset gionaliero di visitatori di ogni giostra

			visitedH = 0;
			visitedR = 0;
			visitedT = 0;
			visitedC = 0;
			
			// Reset gionaliero dei posti occupati di ogni attrazione
			
			currentCapacityH = 0;
			currentCapacityR = 0;
			currentCapacityT = 0;
			currentCapacityC = 0;
			
		}

		System.out.println("STATISTICHE FINALI DEL PARCO!\n");

		// Identificazione dell'attrazione piu visitata

		for (int j = 0; j < 4; j++) {

			if (totalVisitedH > totalVisitedT && totalVisitedH > totalVisitedR && totalVisitedH > totalVisitedC) {
				mostVisited = "Haunted House";
			} else if (totalVisitedR > totalVisitedH && totalVisitedR > totalVisitedT
					&& totalVisitedR > totalVisitedC) {
				mostVisited = "Roller Coaster";
			} else if (totalVisitedT > totalVisitedH && totalVisitedT > totalVisitedR
					&& totalVisitedT > totalVisitedC) {
				mostVisited = "Drop Tower";
			} else if (totalVisitedC > totalVisitedH && totalVisitedC > totalVisitedR
					&& totalVisitedC > totalVisitedT) {
				mostVisited = "Bumper Cars";
			} else
				mostVisited = "Piu di una giostra e la piu visitata";
		}

		// Calcolo tempo medio di attesa per attrazione per tutta la durata di apertura del parco

		System.out.println("Il tempo medio di attesa per " + haunted + " e: "
				+ (totalVisitedH == 0 ? 0 : (totalWaitTimeH / totalVisitedH)) + " minuti.");
		System.out.println("Il tempo medio di attesa per " + roller + " e: "
				+ (totalVisitedR == 0 ? 0 : (totalWaitTimeR / totalVisitedR)) + " minuti.");
		System.out.println("Il tempo medio di attesa per " + tower + " e: "
				+ (totalVisitedT == 0 ? 0 : (totalWaitTimeT / totalVisitedT)) + " minuti.");
		System.out.println("Il tempo medio di attesa per " + cars + " e: "
				+ (totalVisitedC == 0 ? 0 : (totalWaitTimeC / totalVisitedC)) + " minuti.\n");

		// Stampa giostra piu visitata

		System.out.println("La giostra piu visitata e: " + mostVisited+"\n");

		// Calcolo e stampa della percentuale di visitatori soddisfatti

		System.out.println("La percentuale di visitatori soddisfatti e: "
				+ (double) ((totalSatisfied * 100) / (visitors * daysOpen)) + "%\n");

		// Stampa netto totale

		System.out.println("Il netto totale e: " + totalNet + "$");	
	}
}