package file;

import java.io.File;

public class FileList {
	
	public static void listFile(String path){
		File file = new File(path);
		for(File f : file.listFiles()){
			if(f.isFile()){
				System.out.println(f.getName());
			}
		}
	}
	
	public static void listAllFile(String path, String prefix){
		File file = new File(path);
		for(File f : file.listFiles()){
			if(f.isFile()){
				System.out.println(prefix + f.getName());
			}else if(f.isDirectory()){
				System.out.println(prefix + f.getName());
				listAllFile(f.getAbsolutePath(), prefix + "\t");
			}
		}
	}

	public static void main(String[] args) {
		String path = "F:\\µÁ”∞";
		listAllFile(path, "");
	}

}
