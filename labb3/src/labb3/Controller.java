package labb3;

import java.io.*;

public class Controller {
	
	private Documentmodel documentmodel;
	private Filemanager filemanager;
	private IView view;
	
	public Controller(Documentmodel documentmodel, Filemanager filemanager,IView view) {
	this.documentmodel=documentmodel;
	this.filemanager=filemanager;
	this.view=view;
	view.setController(this);
	initView();
	}
		
	private void initView() {
	view.displayText(documentmodel.getContent()); 
	
	}

	public void newDocument() {
	if (documentmodel.isModified() && view.promptSaveChanges()) {
		saveDocument();
	}
	documentmodel.setContent("");
	documentmodel.setFilePath("");
	documentmodel.setModified(false);
	view.displayText("");
	
	String newContent = view.getTextInput();
	documentmodel.setContent(newContent);
	documentmodel.setModified(true);
	
	
	if(view.promptSaveChanges()) {
		saveDocument();
	}
	
	}
	public void openDocument() {
		String filePath = view.promptFileOpen();
		if (filePath != null) {
		try {
			String content = filemanager.loadFromFile(filePath);
			documentmodel.setContent(content);
			documentmodel.setFilePath(filePath);
			documentmodel.setModified(false);
			view.displayText(content);
		} catch (IOException e) {
			view.showError("Failed to open file: " + e.getMessage());
		}
		}
		}
	
	public void saveDocument () {
	if (documentmodel.getFilePath().isEmpty()) {
		saveDocumentAs();
	} else {
		try {
			filemanager.saveToFile(documentmodel.getFilePath(), documentmodel.getContent());
			documentmodel.setModified(false);
			view.showSaveSuccess();
		} catch (IOException e) {
			view.showError("Failed to save file: " + e.getMessage());
		}
	}}
	public void saveDocumentAs() {
		String filePath = view.promptFileSave(); 
		if (filePath != null) {
			try {
				filemanager.saveToFile(filePath, documentmodel.getContent());
				documentmodel.setFilePath(filePath);
				documentmodel.setModified(false);
				view.showSaveSuccess();
			} catch (IOException e) {
				view.showError("Failed to save file: " + e.getMessage());
			}
		}
	}
	
	public String getDocumentContent() {
		return documentmodel.getContent();
	}
	
	public void exitApplication () {
		if (documentmodel.isModified() && view.promptSaveChanges()) {
			saveDocument();
		}
		System.exit(0);
	}
}

