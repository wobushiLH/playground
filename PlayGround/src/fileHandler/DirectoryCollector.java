package fileHandler;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;


public class DirectoryCollector {
	
	public List<String> getDirectoryList(File file) {  
		  
        List<String> result = new ArrayList<String>();  
  
        if (!file.isDirectory()) {  
            System.out.println(file.getAbsolutePath());  
            result.add(file.getAbsolutePath());  
        } else {  
            File[] directoryList = file.listFiles();  
            for (int i = 0; i < directoryList.length; i++) {  
                result.add(directoryList[i].getPath());  
            }  
        }  
  
        return result;  
    }  
	
}
