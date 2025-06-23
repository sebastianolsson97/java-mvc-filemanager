package labb3;

public class Main {

	public static void main(String[] args) {
		   Documentmodel model = new Documentmodel();
	       Filemanager filemanager = new Filemanager();
	       IView view = ViewFactory.createView();
	       new Controller(model, filemanager, view); 

}
}