package org.howard.edu.hw2;
/*
 * Class: LargeScaleProgramming
 * Name: Yasmin Senior
 * 
 * 
 */
import java.io.FileNotFoundException;
import java.util.*;

public class Readfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fileread fr = new Fileread();
		HashMap<String, Integer> my_map = new HashMap<String, Integer>(); // I made a hashmap to store my words
		
		try {
			String file_string = fr.readToString("main/java/resources/Word.txt"); //this stores my text string in a file 
			String[] separated = file_string.replaceAll("[^a-zA-z ]", "").toLowerCase().split(" "); //getting rid of punctuation and putting word in an array
			for (int x = 0; x < separated.length; x++) {
				if (separated[x].length() > 3) {
					if (my_map.get(separated[x]) == null) { //set value to zero, if not in hashmap
						my_map.put(separated[x], 1);
					}
					else { //increment count if in hashmap
						my_map.put(separated[x], my_map.get(separated[x]) + 1);
					}
				}
			}
			for (String i : my_map.keySet()) {
				System.out.println(i + " " + my_map.get(i));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}

	}

}