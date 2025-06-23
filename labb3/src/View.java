package labb2;

import javax.swing.*;
import java.io.*;

public class View extends JFrame implements IView{
	
private JTextArea textArea = new JTextArea();
private Controller controller;

public View() {
	setTitle("Text Editor");
	setSize(800,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	add(new JScrollPane(textArea));
	setVisible(true);
}

@Override
public void setController(Controller controller) {
	this.controller = controller; 
	setupMenu();
}

@Override
public void displayText(String text) {
	textArea.setText(text);
}

@Override
public String getTextInput() {
	return textArea.getText();
}

@Override
public boolean promptSaveChanges() {
	int result = JOptionPane.showConfirmDialog(this, "Do you want to save changes?", "Save Changes", JOptionPane.YES_NO_CANCEL_OPTION);
	return result == JOptionPane.YES_OPTION;
}

@Override
public void showSaveSuccess() {
JOptionPane.showMessageDialog(this, "File saved successfully", "Save", JOptionPane.INFORMATION_MESSAGE);

}

@Override
public void showError(String message) {
	JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
}

@Override
public String promptFileSave() {
	JFileChooser fileChooser = new JFileChooser();
	if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
		File file = fileChooser.getSelectedFile();
		return file.getAbsolutePath();
	}
	return null; 
	
}

@Override
public String promptFileOpen() {
	JFileChooser fileChooser = new JFileChooser();
	if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
		File file = fileChooser.getSelectedFile();
		return file.getAbsolutePath();
	}
	return null; 
	
	
}
private void setupMenu() {
	JMenuBar menuBar=new JMenuBar();
	JMenu fileMenu=new JMenu("File");
	
	JMenuItem newItem=new JMenuItem("New");
	newItem.addActionListener(e-> controller.newDocument());
	
	JMenuItem openItem=new JMenuItem("Open");
	openItem.addActionListener(e -> controller.openDocument());
	
	JMenuItem saveItem=new JMenuItem("Save");
	saveItem.addActionListener(e -> controller.saveDocument());
	
	JMenuItem saveAsItem=new JMenuItem("Save As");
	saveAsItem.addActionListener(e -> controller.saveDocumentAs());
	
	JMenuItem exitItem=new JMenuItem("Exit");
	exitItem.addActionListener(e -> controller.exitApplication());
	
	fileMenu.add(newItem);
	fileMenu.add(openItem);
	fileMenu.add(saveItem);
	fileMenu.add(saveAsItem);
	fileMenu.add(exitItem);
	menuBar.add(fileMenu);
	setJMenuBar(menuBar);
	setVisible(true);
}

}

