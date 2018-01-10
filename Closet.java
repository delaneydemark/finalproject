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
import java.lang.String;

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
  			String occasion = article[2].substring(1,article[2].length()-1);
  			String color = article[3].substring(1,article[3].length()-1);
  			String brand = article[4];
  			String material = article[5];
  			String price = article[6];
  			String dates = article[7].substring(1,article[7].length()-1);
  			String fileName = article[8];
  			Article art = new Article(category, size, occasion, color, brand, material,
  									price, dates, fileName);
  			add(art);
  			
  		}
  	}catch(IOException e){
  			e.printStackTrace();
  	}
  	sort();
  	for(int i = 0; i<clothes.size(); i++){
  		System.out.println(Article.toString(clothes.get(i)));
  	}
  }
  
  public void add(Article art){
  	clothes.add(art);
  }
  
  public void remove(Article art){
  	clothes.remove(art);
  }

    public int len(){
	return clothes.size();
    }

    public Article get(int n){
	return clothes.get(n);
    }
  
  public void clear(){
  	clothes.clear();
  	writeToCSV("articles.csv");
  }
  
  public void writeToCSV(String fileN){
  	FileWriter fileWriter = null;
  	try{
  		fileWriter = new FileWriter(fileN);
  		
  		//csv file header
  		/*fileWriter.append("category");
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
  		fileWriter.append("\n");*/
  		
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
  
  /*public ArrayList<String> stringToArrayList(){
  	String str = this.substring(1, this.length()-1);
  	String arr[] = str.split(",");
  	ArrayList<String> res = new ArrayList<String>();
  	for (int i = 0; i<arr.length; i++){
  		res.set(i,arr[i]);
  	}
  	return res;
  }*/
  
  public void sort(){
  	// separate arraylists for each category
  	ArrayList<Article> tops = new ArrayList<Article>();
  	ArrayList<Article> bottoms = new ArrayList<Article>();
  	ArrayList<Article> dresses = new ArrayList<Article>();
  	ArrayList<Article> shoes = new ArrayList<Article>();
  	ArrayList<Article> other = new ArrayList<Article>();
  	for(int i = 0; i<clothes.size(); i++){
		//for each article in clothes
  		Article art = clothes.get(i);
  		// makes category all lowercase to eliminate capitalization issues
  		String category = art.getCategory().toLowerCase();
  		// adds the article to the appropriate arraylist
  		if (category.equals("shirt")){
  			tops.add(art);
  		}
  		else if (category.equals("shorts") || category.equals("pants") 
  				|| category.equals("skirt")){
  			bottoms.add(art);
  		}
  		else if (category.equals("dress")){
  			dresses.add(art);
  		}
  		else if (category.equals("shoes")){
  			shoes.add(art);
  		}
  		else{
  			other.add(art);
  		}
  	}
  	// clears clothes
  	clothes.clear();
  	// adds each of the arraylists to clothes in order
  	clothes.addAll(tops);
  	clothes.addAll(bottoms);
  	clothes.addAll(dresses);
  	clothes.addAll(shoes);
  	clothes.addAll(other);
  	// sorted
  }
}

  
  

