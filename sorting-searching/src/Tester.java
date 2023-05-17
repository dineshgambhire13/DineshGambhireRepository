import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Tester {
	
	public static void search(Scanner sc, List<CricketTeam> teams) {
		
		int searchChoice = 1;
		String name = "";
		while(searchChoice != 0) {
			
			System.out.println("\n0. Exit\n1. Linear search\n2. Binary search\n");
			System.out.print("Enter your choice: ");
			searchChoice = sc.nextInt();
			
			if(searchChoice != 0) {
				System.out.print("Enter team name you want to search: ");
				name = sc.next();
			}
				
			switch (searchChoice) {
				case 0:
					System.out.println("Thank you!");
					break;
				case 1:
					//linear search
					int index1 = Search.linearSearch(teams, name);
					if(index1 != -1) {
						System.out.println(teams.get(index1).toString());
					}else {
						System.out.println("Team not found...");
					}
					break;
				case 2:
					//binary search
					List<CricketTeam> sortedTeams = Sort.selectionSortByTeamName(teams);
					System.out.println("\nSorted by Team Name using selection sort:\n " + sortedTeams.toString());
					int index2 = Search.recBinarySearch(sortedTeams, name);
					if(index2 != -1) {
						System.out.println("\nTeam found: " + sortedTeams.get(index2).toString());
					}else {
						System.out.println("\nTeam not found...");
					}
					break;
				default:
					System.out.println("Invalid choice, Please enter valid number...");
					break;
			}
		}
	}
	
public static void sort(Scanner sc, List<CricketTeam> teams) {
		
		int sortChoice = 1;
		while(sortChoice != 0) {
			System.out.println("\n0. Exit\n1. Selection sort\n2. Bubble sort\n3. Insertion sort\n4. Merge sort\n5. Quick sort\n");
			System.out.print("Enter your choice: ");
			sortChoice = sc.nextInt();
			
			switch (sortChoice) {
				case 0:
					System.out.println("Thank you!");
					break;
				case 1:
					//Selection sort
					System.out.println("\nSorted by points using selection sort:\n " + Sort.selectionSortByPoints(teams).toString());
					break;
				case 2:
					//Bubble sort
					System.out.println("\nSorted by points using bubble sort:\n " + Sort.bubbleSortByPoints(teams).toString());
					
					break;
				case 3:
					//Insertion sort
					System.out.println("\nSorted by points using Insertion sort:\n " + Sort.insertionSortByPoints(teams).toString());
					
					break;
				case 4:
					//Merge sort
//					Sort.mergeSortByPoints(teams);
					break;
				case 5:
					//Quick sort
					break;
				default:
					System.out.println("Invalid choice, Please enter valid number...");
					break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		List<CricketTeam> teams = new ArrayList<CricketTeam>();
		
		int operationChoice = 1;
		while(operationChoice != 0) {
			
			System.out.println("\n0. Exit\n1. Add team\n2. Search\n3. Sort\n4. Display list\n5. Shuffle list elements\n ");
			System.out.print("Enter your choice: ");
			operationChoice = sc.nextInt();
			
			switch (operationChoice) {
				case 0:
					System.out.println("Thank you!");
					break;
				case 1:
					teams.add(CricketTeam.createTeam(sc));
					break;
				case 2:
					search(sc, teams);
					break;
				case 3:
					sort(sc, teams);
					break;
				case 4:
					System.out.println(teams.toString());
					break;
				case 5:
					Collections.shuffle(teams);
					System.out.println("After shuffling: " + teams.toString());
					break;
				default:
					System.out.println("Invalid choice, Please enter valid number...");
					break;
			}
		}
		
		sc.close();
	}

}
