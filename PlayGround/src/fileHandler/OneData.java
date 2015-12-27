package fileHandler;

import java.io.File;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;

public class OneData {

	private String date;
	private ArrayList<File> files;
	private int filesNum;
	private int offset;
	private ArrayList<ArrayList<String>> oneDataInform;
	
	private double[] MalePercent;
	private double[] FemalePercent;
	private double[] Age14to19Percent;
	private double[] Age20to24Percent;
	private double[] Age25to29Percent;
	private double[] Age30to34Percent;
	private double[] Age35to39Percent;
	private double[] Age40to44Percent;
	private double[] Age45to49Percent;
	private double[] AgeElsePercent;
	
	private double AvgMalePercent = 0;
	private double AvgFemalePercent = 0;
	private double AvgAge14to19Percent = 0;
	private double AvgAge20to24Percent = 0;
	private double AvgAge25to29Percent = 0;
	private double AvgAge30to34Percent = 0;
	private double AvgAge35to39Percent = 0;
	private double AvgAge40to44Percent = 0;
	private double AvgAge45to49Percent = 0;
	private double AvgAgeElsePercent = 0;
	private double AvgAgeOver40Percent = 0;
	
	OneData(String date){
		this.date = date;
		files = new ArrayList<File>();
	}
	
	public void addFile(File file){
		files.add(file);
	}
	
	public void printFileInfo(){
//		for (int i = 0; i < files.size(); i++) {
//			System.out.println(files.get(i).getAbsolutePath());
//		}
		System.out.println("total txt files number in " + date + ": " + files.size());
	}
	
	
	public void setFiles(ArrayList<String> fileNames){
		for(int i=0; i<fileNames.size();i++){
			files.add(new File(fileNames.get(i)));
		}
	}
	
	
	private void loadTxtFile(){
		oneDataInform = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < files.size(); i++) {
			TxtReader reader = new TxtReader(files.get(i).getAbsolutePath());
			reader.readTxtFile();
			oneDataInform.add(reader.getFileInform());
		}
		this.filesNum = oneDataInform.size();
		MalePercent = new double[filesNum];
		FemalePercent = new double[filesNum];
		Age14to19Percent = new double[filesNum];
		Age20to24Percent = new double[filesNum];
		Age25to29Percent = new double[filesNum];
		Age30to34Percent = new double[filesNum];
		Age35to39Percent = new double[filesNum];
		Age40to44Percent = new double[filesNum];
		Age45to49Percent = new double[filesNum];
		AgeElsePercent = new double[filesNum];
	}
	
	public void getOneDataInform(int printOption, int numberFormat){
		this.offset=0;
		loadTxtFile();
		
//		System.out.println("datas size: " + filesNum);
//		System.out.println("file number: " + files.size());
		
		for (int i = 0; i < filesNum; i++) {
			if (oneDataInform.get(i).size() != 0){
				MalePercent[i] = Double.valueOf(oneDataInform.get(i).get(0));
				FemalePercent[i] = Double.valueOf(oneDataInform.get(i).get(1));
				Age14to19Percent[i] = Double.valueOf(oneDataInform.get(i).get(2));
				Age20to24Percent[i] = Double.valueOf(oneDataInform.get(i).get(3));
				Age25to29Percent[i] = Double.valueOf(oneDataInform.get(i).get(4));
				Age30to34Percent[i] = Double.valueOf(oneDataInform.get(i).get(5));
				Age35to39Percent[i] = Double.valueOf(oneDataInform.get(i).get(6));
				Age40to44Percent[i] = Double.valueOf(oneDataInform.get(i).get(7));
				Age45to49Percent[i] = Double.valueOf(oneDataInform.get(i).get(8));
				AgeElsePercent[i] = Double.valueOf(oneDataInform.get(i).get(9));
			}else
				offset++;
		}
		calcualteAverages();
		printAvgs(printOption, numberFormat);
	}
	
	private void printAvgs(int printOption, int numberFormat){
		
		
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(4);
		nf.setRoundingMode(RoundingMode.HALF_UP);
		
		System.out.println("------------------------------------------");
		System.out.println("Path: " + this.date);
		System.out.println("Num of txt files: " + this.filesNum);
		System.out.println("Num of empty files: " + this.offset);
		System.out.println("");
		System.out.println("Male:         " + AvgMalePercent);
		System.out.println("Female:       " + AvgFemalePercent);
		System.out.println("Gender Total: " + AvgMalePercent+AvgFemalePercent);
		System.out.println("//////////");
		System.out.println("Age 14 - 19: " + AvgAge14to19Percent);
		System.out.println("Age 20 - 24: " + AvgAge20to24Percent);
		System.out.println("Age 25 - 29: " + AvgAge25to29Percent);
		System.out.println("Age 30 - 34: " + AvgAge30to34Percent);
		System.out.println("Age 35 - 39: " + AvgAge35to39Percent);
//		System.out.println("Age 40 - 44: " + AvgAge40to44Percent);
//		System.out.println("Age 45 - 49: " + AvgAge45to49Percent);
		System.out.println("Age Over 40: " + (AvgAge40to44Percent+AvgAge45to49Percent+AvgAgeElsePercent)/1);
		System.out.println("Age Total: " + AvgAge14to19Percent+AvgAge20to24Percent
													+AvgAge25to29Percent+AvgAge30to34Percent
													+AvgAge35to39Percent+AvgAge40to44Percent
													+AvgAge45to49Percent+AvgAgeElsePercent);
		System.out.println("------------------------------------------");
		System.out.println("                                          ");
		
//		System.out.println((AvgAge40to44Percent+AvgAge45to49Percent+AvgAgeElsePercent)/1);		
		
//		System.out.println("------------------------------------------");
//		System.out.println("Path: " + this.date);
//		System.out.println("Num of txt files: " + this.filesNum);
//		System.out.println("Num of empty files: " + this.offset);
//		System.out.println("");
//		System.out.println("Male:         " + nf.format(AvgMalePercent));
//		System.out.println("Female:       " + nf.format(AvgFemalePercent));
//		System.out.println("Gender Total: " + nf.format(AvgMalePercent+AvgFemalePercent));
//		System.out.println("//////////");
//		System.out.println("Age 14 - 19: " + nf.format(AvgAge14to19Percent));
//		System.out.println("Age 20 - 24: " + nf.format(AvgAge20to24Percent));
//		System.out.println("Age 25 - 29: " + nf.format(AvgAge25to29Percent));
//		System.out.println("Age 30 - 34: " + nf.format(AvgAge30to34Percent));
//		System.out.println("Age 35 - 39: " + nf.format(AvgAge35to39Percent));
//		System.out.println("Age 40 - 44: " + nf.format(AvgAge40to44Percent));
//		System.out.println("Age 45 - 49: " + nf.format(AvgAge45to49Percent));
//		System.out.println("Age Over 50: " + nf.format(AvgAgeElsePercent));
//		System.out.println("Age Total: " + nf.format(AvgAge14to19Percent+AvgAge20to24Percent
//													+AvgAge25to29Percent+AvgAge30to34Percent
//													+AvgAge35to39Percent+AvgAge40to44Percent
//													+AvgAge45to49Percent+AvgAgeElsePercent));
//		System.out.println("------------------------------------------");
//		System.out.println("                                          ");

	}
	
	
	private void calcualteAverages(){
		for (int i = 0; i < filesNum; i++) {
			AvgMalePercent = AvgMalePercent + MalePercent[i];
			AvgFemalePercent = AvgFemalePercent + FemalePercent[i];
			AvgAge14to19Percent = AvgAge14to19Percent + Age14to19Percent[i];
			AvgAge20to24Percent = AvgAge20to24Percent + Age20to24Percent[i];
			AvgAge25to29Percent = AvgAge25to29Percent + Age25to29Percent[i];
			AvgAge30to34Percent = AvgAge30to34Percent + Age30to34Percent[i];
			AvgAge35to39Percent = AvgAge35to39Percent + Age35to39Percent[i];
			AvgAge40to44Percent = AvgAge40to44Percent + Age40to44Percent[i];
			AvgAge45to49Percent = AvgAge45to49Percent + Age45to49Percent[i];
			AvgAgeElsePercent = AvgAgeElsePercent + AgeElsePercent[i];
		}
		AvgMalePercent = AvgMalePercent/(filesNum-offset);
		AvgFemalePercent = AvgFemalePercent/(filesNum-offset);
		AvgAge14to19Percent = AvgAge14to19Percent/(filesNum-offset);
		AvgAge20to24Percent = AvgAge20to24Percent/(filesNum-offset);
		AvgAge25to29Percent = AvgAge25to29Percent/(filesNum-offset);
		AvgAge30to34Percent = AvgAge30to34Percent/(filesNum-offset);
		AvgAge35to39Percent = AvgAge35to39Percent/(filesNum-offset);
		AvgAge40to44Percent = AvgAge40to44Percent/(filesNum-offset);
		AvgAge45to49Percent = AvgAge45to49Percent/(filesNum-offset);
		AvgAgeElsePercent = AvgAgeElsePercent/(filesNum-offset);
	}
	
	public String getDate(){
		return date;
	}
	
	
	public double getMalePercent(){
		return AvgMalePercent;
	}
	
	public double getFemalePercent(){
		return AvgFemalePercent;
	}
	
	public double getAge14to19Percent(){
		return AvgAge14to19Percent;
	}
	
	public double getAge20to24Percent(){
		return AvgAge20to24Percent;
	}
	
	public double getAge25to29Percent(){
		return AvgAge25to29Percent;
	}
	
	public double getAge30to34Percent(){
		return AvgAge30to34Percent;
	}
	
	public double getAge35to39Percent(){
		return AvgAge35to39Percent;
	}
	
	public double getAge40to44Percent(){
		return AvgAge40to44Percent;
	}
	
	public double getAge45to49Percent(){
		return AvgAge45to49Percent;
	}
	
	public double getAgeElsePercent(){
		return AvgAgeElsePercent;
	}
}
