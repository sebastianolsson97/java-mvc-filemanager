package labb3;

import java.util.Scanner; 

public class ViewFactory {
	public static IView createView() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Select View: ");
		System.out.println("1. Graphical View"); 
		System.out.println("2. Console View");
		System.out.println("Enter your choice: ");
		String choice = scanner.nextLine();
		System.out.flush();
		
		if("1".equals(choice)) {
			return new View();
		} else if ("2".equals(choice)) {
			return new ConsoleView();
		} else {
			System.out.println("Invalid choice. Defaulting to Console View"); 
			return new ConsoleView();
			
		}
	}
}