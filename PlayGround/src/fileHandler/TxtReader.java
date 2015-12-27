package fileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TxtReader {
	
	private String filePath;
	private ArrayList<String> fileInform = new ArrayList<String>(); 
	
	public TxtReader(String filePath){
		this.filePath = filePath;
	}
	
	
    public void readTxtFile(){
        try {
                String encoding="UTF-8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ 
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    int i=0;
//                    System.out.println(filePath);
                    while((file.length() != 0)&&((lineTxt = bufferedReader.readLine()) != null)){
                   		fileInform.add(lineTxt.substring(lineTxt.lastIndexOf("^")+1, lineTxt.length()));
//                    	System.out.println(fileInform.get(fileInform.size()-1));
                   		i++;
                    }
                    read.close();
        }else{
            System.out.println("Failed to find file " + filePath);
        }
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
     
    }
    
    public ArrayList<String> getFileInform(){
    	return fileInform;
    }
	
	
}
