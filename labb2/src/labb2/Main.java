package labb2;

public class Main {

	public static void main(String[] args) {
		   Documentmodel model = new Documentmodel();
	       Filemanager filemanager = new Filemanager();
	       IView view = new View();
	       new Controller(model, filemanager, view); 

	}

}
