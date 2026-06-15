package activities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\FST Training\\DemoFolder\\dummy.txt");
		boolean fStatus = file.createNewFile();
		if(fStatus == true) {
			System.out.println("File has been created");
			FileUtils.writeStringToFile(file, "This is a file created for FST program", fStatus);
		}
		System.out.println("Data in file: " + FileUtils.readFileToString(file, "UTF8"));
		File destDir = new File("C:\\FST Training\\DemoFolder\\destDir");
		FileUtils.copyFileToDirectory(file, destDir);
		
		File newFile = FileUtils.getFile(destDir, "dummy.txt");
		System.out.println("Data in file: " + FileUtils.readFileToString(newFile, "UTF8"));

	}

}
