package labb2;

public interface IView {
	void setController(Controller controller);
	void displayText(String text);
	String getTextInput();
	boolean promptSaveChanges();
	void showSaveSuccess();
	void showError(String message);
	String promptFileSave();
	String promptFileOpen();
	

}
