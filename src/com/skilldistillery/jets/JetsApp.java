package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class JetsApp {

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
		AirField airfield = new AirField();
		airfield.setJets(app.getJetsInput());
		System.out.println(airfield.getJets());
		app.menu();

//		CargoPlane cp = new CargoPlane("Cessna", 50, 300, 1_000);
//		cp.loadCargo();
//		System.out.println(cp.toString());
//		FighterJet fj = new FighterJet("F16",500,1000,20_000);
//		FighterJet fr = new FighterJet("F16",500,1000,20_001);
//		ArrayList <Jet> jetArr = new ArrayList<>(); 
//		jetArr.add(cp);
//		jetArr.add(fj);
//		jetArr.add(fr);
//		airfield.setJets(jetArr);
//		fr.fight();
//		System.out.println(field.getJets().toString());

	}

	public List<Jet> getJetsInput() {
		String fileName = "Jets.txt";
		List<Jet> jetArr = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] jetParams = line.split(",");
				int param2 = Integer.parseInt(jetParams[2]);
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
		airfield.setJets(getJetsInput());
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
				continue;
			}
			switch (choice) {
				case 1:
					System.out.println(airfield.getJets());
					continue;
				case 2:
					continue;
				case 3:
					continue;
				case 4:
					continue;
				case 5:
					continue;
				case 6:
					continue;
				case 7:
					continue;
				case 8:
					continue;
				case 9:
					break;
				default:
					System.out.println("Only numbers 1-9 are available");
					continue;
			}
			input.close();
			break;

		}

	}

}
