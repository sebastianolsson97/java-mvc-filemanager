package labb3;

import java.util.Scanner; 

public class ConsoleView implements IView{
	private Controller controller;
	private Scanner scanner = new Scanner(System.in);
	
@Override 
public void setController(Controller controller) {
	this.controller = controller; 
	showMenu();
}
	
@Override
public void displayText(String text) {
	System.out.println("File content: \n" + text);
}

@Override 
public String getTextInput() {
	System.out.println("Enter text to save: ");
	return scanner.nextLine();
}

@Override
public boolean promptSaveChanges() {
	System.out.println("Do you want to save changes? (yes/no): ");
	String input = scanner.nextLine().trim().toLowerCase();
	return input.equals("yes");

}

@Override
public void showSaveSuccess() {
	System.out.println("File saved successfully");
}

@Override
public void showError(String message) {
	System.out.println("Error: " + message);
}

@Override
public String promptFileSave() {
	System.out.println("Enter file name to save (including path): ");
	return scanner.nextLine();
}

@Override
public String promptFileOpen() {
	System.out.print("Enter file name to open (including path): ");
	return scanner.nextLine();
}


public void showMenu() {
	while (true) {
		System.out.println("\nMenu: ");
		System.out.println("1. Read file");
		System.out.println("2. Create new file");
		System.out.println("3. Exit");
		System.out.print("Your choice: ");
		String choice = scanner.nextLine();
		System.out.flush();
		
		switch (choice) {
		case "1": 
			controller.openDocument();
			break; 
		case "2": 
			controller.newDocument();
			System.out.println("File content: " + controller.getDocumentContent());
			break;
		case "3": 
			controller.exitApplication();
			return; 
		default: 
			System.out.println("Invalid choice. Try again");
		}
	}
}
}


	