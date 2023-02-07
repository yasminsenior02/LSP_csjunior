package org.howard.edu.hw2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.net.URL;

	public class Fileread {
		public String readToString(String resource) throws FileNotFoundException {
			URL url = getClass().getClassLoader().getResource(resource);
			
			if (url != null) {
				File file = new File(url.getPath());
				
				Scanner sc = null;
				try {
					sc = new Scanner(file);
					String output = "";
					while (sc.hasNextLine()) {
						output = output + sc.nextLine() + " ";
					}
					return output.trim();
				} finally {
					sc.close();
				}
			}
			throw new FileNotFoundException();
		}
	}