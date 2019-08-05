package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;

public class FileSearch {
	
	public static int search(String fileName, String pattern){
		int count = 0;
		try(FileReader fis  = new FileReader(fileName)){
			BufferedReader reader = new BufferedReader(fis);
			String line;
			while((line = reader.readLine()) != null){
				int index;
				while(line.length() >= pattern.length() && (index = line.indexOf(pattern)) != -1){
					count++;
					line = line.substring(index + pattern.length());
				}
			}
		}catch(Exception e){
			
		}
		return count;
	}

	public static void main(String[] args) {
		String fileName = "E:\\test.txt";
		System.out.print(search(fileName, "1069"));
	}

}
