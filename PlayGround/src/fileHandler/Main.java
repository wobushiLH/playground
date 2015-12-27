package fileHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		showFolderNames(initialDatas());
//		showTxtNumsInFolder(initialDatas());
		
		
		
		/*
		 * printOption 	= 0: print all 
		 * 				= 1: print male percent only
		 * 				= 2: print female percent only
		 * 				= 3: print Age 14 - 19 percent only
		 *				= 4: print Age 20 - 24 percent only
		 * 				= 5: print Age 25 - 29 percent only
		 * 				= 6: print Age 30 - 34 percent only
		 *  			= 7: print Age 35 - 39 percent only
		 *  			= 8: print Age 40 - 44 percent only
		 *  			= 9: print Age 45 - 49 percent only
		 *    			= 10:print Age Over 50 percent only
		 *    
		 *    
		 * numberFormat = 0: print result in double format
		 * 				  1: print result in percent format
		 * 
		 * 
		 * 
		 */
		

		showDatasInform(initialDatas(),1,1);
		
//		reader.readTxtFile();
	}
	
	
	static void showDatasInform(ArrayList<OneData> datas, int printOption, int numberFormat){
//		System.out.println(datas.size());
		for (int i = 0; i < datas.size(); i++) {
//			System.out.println("---- Directory " + (i + 1) + " ---------");
			datas.get(i).getOneDataInform(printOption, numberFormat);
		}
//		System.out.println(datas.get(22).getDate());
//		datas.get(18).getOneDataInform();
	}

	static ArrayList<OneData> initialDatas(){
		ArrayList<OneData> datas = new ArrayList<OneData>();
		TxtFilesCollector txtFilesCollector = new TxtFilesCollector();
		txtFilesCollector.getDirectoryList(datas, new File("hdt/"));
		return datas;
	}
	
	
	static void showFolderNames(ArrayList<OneData> datas){
		int i = 0;
		for (; i < datas.size(); i++)
			System.out.println(datas.get(i).getDate());
		System.out.println("total folder number: " + i);
	}
	
	static void showTxtNumsInFolder(ArrayList<OneData> datas){
		for (int j=0; j < datas.size(); j++)
			datas.get(j).printFileInfo();
	}
	

}
