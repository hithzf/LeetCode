package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * ÎÄ¼þ¿½±´
 * @author hzf
 *
 */
public class FileCopy {
	
	public static void copyFile(String source, String target){
		try(InputStream in = new FileInputStream(source)){
			try(OutputStream out = new FileOutputStream(target)){
				byte[] temp = new byte[2048];
				int bytes = 0;
				while((bytes = in.read(temp)) != -1){
					out.write(temp, 0, bytes);
				}
			}
		}catch(Exception e){
			
		}
	}

	public static void main(String[] args) {
		String source = "E:\\test.txt";
		String target = "E:\\copy.txt";
		copyFile(source, target);
	}

}
