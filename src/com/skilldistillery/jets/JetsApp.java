package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JetsApp {

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		app.menu();

	}

	public List<Jet> getJetsInput(String file) {
		String fileName = file;
		List<Jet> jetArr = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] jetParams = line.split(",");
				Double param2 = Double.valueOf(jetParams[2]);
				int param3 = Integer.parseInt(jetParams[3]);
				int param4 = Integer.parseInt(jetParams[4]);
				if (jetParams[0].equalsIgnoreCase("Cargo")) {
					CargoPlane cp = new CargoPlane(jetParams[1], param2, param3, param4);
					jetArr.add(cp);
				} else if (jetParams[0].equalsIgnoreCase("fighter")) {
					FighterJet fj = new FighterJet(jetParams[1], param2, param3, param4);
					jetArr.add(fj);
				} else {
					JetImpl gj = new JetImpl(jetParams[1], param2, param3, param4);
					jetArr.add(gj);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println(fileName + " File not Found, cannot load Airfield");
			;
		} catch (IOException e) {
			System.err.println("General IO Error");
		}

		return jetArr;

	}

	public void menu() {
		Scanner input = new Scanner(System.in);
		int choice = 0;
		AirField airfield = new AirField();
		List<Jet> jetArr = getJetsInput("Jets.txt");
		airfield.setJets(jetArr);
		while (true) {
			try {
				System.out.println("Select an option!");
				System.out.println("************************");
				System.out.println("1: List fleet");
				System.out.println("2: Fly all jets");
				System.out.println("3: View fastest jet");
				System.out.println("4: View jet with longest range");
				System.out.println("5: Load all Cargo Jets");
				System.out.println("6: Dogfight!");
				System.out.println("7: Add a jet to Fleet");
				System.out.println("8: Remove a jet from Fleet");
				System.out.println("9: Quit");
				System.out.println("************************");

				choice = input.nextInt();
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("\nPlease enter a valid number");
				prettyMenu();
				continue;
			}
			switch (choice) {
				case 1:
					System.out.println(airfield.getJets());
					prettyMenu();
					continue;
				case 2:
					jetFlight(jetArr);
					prettyMenu();
					continue;
				case 3:
					fastestJet(jetArr);
					prettyMenu();
					continue;
				case 4:
					jetRange(jetArr);
					prettyMenu();
					continue;
				case 5:
					jetCargo(jetArr);
					prettyMenu();
					continue;
				case 6:
					jetFight(jetArr);
					prettyMenu();
					continue;
				case 7:
					addJet(jetArr, input);
					continue;
				case 8:
					removeJet(jetArr, input);
					continue;
				case 9:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Only numbers 1-9 are available");
					prettyMenu();
					continue;
			}
			input.close();
			break;

		}

	}

	public void addJet(List<Jet> jetArr, Scanner input) {
		JetImpl gj;
		input.nextLine();
		while (true) {
			try {
				System.out.println("Enter jet model");

				String param1 = input.nextLine();
				System.out.println("Enter numeric jet speed");
				double param2 = input.nextDouble();
				System.out.println("Enter numeric jet range(Whole number)");
				int param3 = input.nextInt();
				System.out.println("Enter numeric jet price");
				long param4 = input.nextLong();
				gj = new JetImpl(param1, param2, param3, param4);
				break;
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("Please enter valid information");
				continue;
			}
		}

		jetArr.add(gj);

	}

	public void fastestJet(List<Jet> jetArr) {
		Jet fjet = jetArr.get(0);
		for (Jet jet : jetArr) {
			if (jet.getSpeed() > fjet.getSpeed()) {
				fjet = jet;

			}

		}
		System.out.println(fjet.toString());
	}

	public void prettyMenu() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread interruption error");
			;
		}

	}

	public void jetRange(List<Jet> jetArr) {
		Jet fjet = jetArr.get(0);
		for (Jet jet : jetArr) {
			if (jet.getRange() > fjet.getRange()) {
				fjet = jet;

			}

		}
		System.out.println(fjet.toString());
	}

	public void jetFlight(List<Jet> jetArr) {
		for (Jet jet : jetArr) {
			jet.fly();

		}

	}

	public void jetCargo(List<Jet> jetArr) {
		int count = 0;
		for (Jet jet : jetArr) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
				count++;
			}

		}
		if (count == 0) {
			System.out.println("No cargo planes in airfield");
		}

	}

	public void jetFight(List<Jet> jetArr) {
		int count = 0;
		for (Jet jet : jetArr) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("No fighter jets in airfield");
		}
	}

	public void removeJet(List<Jet> jetArr, Scanner input) {
		while (true) {
			try {
				if (jetArr.size() <= 0) {
					System.out.println("All jets are removed");
					break;
				}
				System.out.println(
						"Select a jet number to remove starting at 1, enter 0 to quit. Array size is " + jetArr.size());
				int jetDelete = input.nextInt() - 1;
				if (jetDelete > jetArr.size() - 1 || jetDelete < -1) {
					System.out.println("Number not in range");
					input.nextLine();
					continue;
				} else if (jetDelete == -1) {
					System.out.println("Returning to menu");
					prettyMenu();
					break;
				}
				jetArr.remove(jetDelete);
			} catch (InputMismatchException e) {
				input.nextLine();
				System.out.println("Please enter a whole number");
				continue;
			}
			break;
		}

	}
}
