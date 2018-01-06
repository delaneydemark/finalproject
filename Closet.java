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

public class Closet extends JFrame{
  public static void main(String[] args){
    HomeScreen w= new HomeScreen();
    //ArticleAddScreen w = new ArticleAddScreen();
    w.setVisible(true);
  }
  
  public ArrayList<Article> clothes = new ArrayList<Article>();
  
  public Closet(){
  	
  }
  
  public void add(Article art){
  	clothes.add(art);
  }
  
  public static void writeToCSV(String fileN){
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
  	}
  }
  
  
}
