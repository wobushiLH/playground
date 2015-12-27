package fileHandler;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class TxtFilesCollector{

	
	public void getDirectoryList(ArrayList<OneData> datas, File file) {  
		  
		
		
		if (file.isDirectory()){
			
			File[] directoryList = file.listFiles(new FileFilter() {  
                public boolean accept(File file) {  
                    if (file.isFile() && file.getName().indexOf("txt") > -1) {  
                        return true;  
                    } else {  
                        return false;  
                    }  
                }  
            });  
			
			if(directoryList.length == 0){
				directoryList = file.listFiles();
				for(int i=0; i< directoryList.length;i++)
					getDirectoryList(datas, directoryList[i]);
			}else{
				for(int i=0; i< directoryList.length;i++){
					if(i==0)
						datas.add(new OneData(directoryList[i].getParent()));
					datas.get(datas.size()-1).setFiles(new FilesCollector().getFileList(directoryList[i].getAbsoluteFile()));
				}
					
			}
		}
	}
}
