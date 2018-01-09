import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Closet extends JFrame{
  public static void main(String[] args){
    HomeScreen w= new HomeScreen();
    //ArticleAddScreen w = new ArticleAddScreen();
    w.setVisible(true);
  }
  
  private ArrayList<Article> clothes;
  
  
  
  public Closet(){
  	clothes = new ArrayList<Article>();
  	//read in the CSV into clothes
  	BufferedReader br = null;
  	FileReader fr = null;
  	
  	try {
  		fr = new FileReader("articles.csv");
  		br = new BufferedReader(fr);
  		String currentLine;
  		while((currentLine = br.readLine()) != null){
  			String article[] = currentLine.split(",");
  			String category = article[0];
  			String size = article[1];
  			String s1 = article[2];
  			
  			
  			
  			System.out.println(currentLine);
  		}catch(IOException e){
  			e.printStackTrace();
  		}
  	}
  }
  
  public void add(Article art){
  	clothes.add(art);
  }
  
  public void writeToCSV(String fileN){
  	FileWriter fileWriter = null;
  	try{
  		fileWriter = new FileWriter(fileN);
  		
  		//csv file header
  		fileWriter.append("category");
  		fileWriter.append(",");
  		fileWriter.append("size");
  		fileWriter.append(",");
  		fileWriter.append("occasion");
  		fileWriter.append(",");
  		fileWriter.append("color");
  		fileWriter.append(",");
  		fileWriter.append("brand");
  		fileWriter.append(",");
  		fileWriter.append("material");
  		fileWriter.append(",");
  		fileWriter.append("price");
  		fileWriter.append(",");
  		fileWriter.append("dates");
  		fileWriter.append(",");
  		fileWriter.append("filename");
  		fileWriter.append("\n");
  		
  		for (int i = 0; i<clothes.size(); i++){
  			fileWriter.append(Article.toString(clothes.get(i)));
  			fileWriter.append("\n");
  		}
  		
  		System.out.println("CSV created successfully!");
  	}catch(Exception e){
  		System.out.println("Error in CSV file writer");
  	}finally{
  		try{
  			fileWriter.flush();
  			fileWriter.close();
  		}catch(IOException e){
  			System.out.println("Error in flushing/closing fileWriter");
  		}
  	}
  }
  
  public ArrayList<String> stringToArrayList(){
  	String str = this.substring(1, this.length()-1);
  	String arr[] = str.split(",");
  	ArrayList<String> res = new ArrayList<String>();
  	for (int i = 0; i<arr.length; i++){
  		res.set(i,arr[i]);
  	}
  	return res;
  }
}
  
  

