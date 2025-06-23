import java.io.*;
import model.*;

public class FileUtil {

public static void saveDrawing(DrawingComposite drawing, String filename) {
	try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
		out.writeObject(drawing);
		System.out.println("Drawing saved to file: " + filename);
	} catch (IOException e) {
		System.err.println("Error saving drawing: " + e.getMessage());
		
	}
}
public static DrawingComposite loadDrawing(String filename) {
	try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
		return (DrawingComposite) in.readObject();
	} catch (IOException | ClassNotFoundException e) {
		System.err.println("Error loading drawing: " + e.getMessage());
		return null; 
	}
}
}
