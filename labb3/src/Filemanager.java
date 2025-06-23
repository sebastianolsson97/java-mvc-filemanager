package labb2;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Filemanager {
	public void saveToFile(String path, String content) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {
			writer.write(content);
	
		}
	}
public String loadFromFile(String path) throws IOException {
	StringBuilder content = new StringBuilder();
	try (BufferedReader reader = new BufferedReader (
			new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
		String line;
		while ((line = reader.readLine()) != null) {
			content.append(line).append("\n");
		}
	}
return content.toString();
}
}


	


