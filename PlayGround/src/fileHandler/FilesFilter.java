package fileHandler;

import java.io.File;
import java.io.FilenameFilter;

public class FilesFilter implements FilenameFilter{
	public boolean accept(File file) {  
        if (file.isFile() && file.getName().indexOf("txt") > -1) {  
            return true;  
        } else {  
            return false;  
        }  
    }

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return false;
	}
}
