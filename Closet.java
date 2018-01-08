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
  		String[] lines = new String[clothes.size()];
  		while((currentLine = br.readLine()) != null){
  			
  			System.out.println(currentLine);
  		}catch(IOException e){
  			e.printStackTrace();
  		}
  	}
  }
  
  public void add(Article art){
  	this.add(art);
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
}
  
  

