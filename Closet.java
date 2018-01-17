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
import java.util.Random;

public class Closet extends JFrame{
  public static void main(String[] args){
    HomeScreen w= new HomeScreen();
    //ArticleAddScreen w = new ArticleAddScreen();
    w.setVisible(true);
  }
  
  private ArrayList<Article> clothes;
  
  
  
  public Closet(){

    System.out.println("CLOSET");
  	clothes = new ArrayList<Article>();
  	//read in the CSV into clothes
  	BufferedReader br = null;
  	FileReader fr = null;
  	
  	try {
  		fr = new FileReader("articles.csv");
  		br = new BufferedReader(fr);
  		String currentLine;
  		// creates an article for each line in articles.csv
  		// and adds it to the clothes arraylist
  		while((currentLine = br.readLine()) != null){
  			String current = currentLine;
  			// finds the index where the arraylist starts
  			int indexOpen = current.indexOf("[");
  			// finds the index where the arraylist closes
  			int indexClose = current.indexOf("]");
  			/* string for everything before the first arraylist
  			 so it can be split on commas*/
  			String first = current.substring(0,indexOpen);
  			String firstArr[] = first.split(",");
  			// assigns category and size from the split array
  			String category = firstArr[0];
  			String size = firstArr[1];
  			// occasion takes everything between the brackets
  			String occasion = current.substring(indexOpen+1, indexClose);
  			/* current is redefined so it starts after the comma after the 
  			 first arraylist */
  			current = currentLine.substring(indexClose+2);
  			// finds index where the next arraylist opens
			indexOpen = current.indexOf("[");
			// finds index where the next arraylist closes
			indexClose = current.indexOf("]");
			// color takes everything between the brackets
  			String color = current.substring(indexOpen+1, indexClose);
  			/* current is redefined so it starts after the comma 
  			 after the second arraylist*/
  			current = current.substring(indexClose+2);
  			// finds the index where the third arraylist opens
  			indexOpen = current.indexOf("[");
  			// finds the index where the third arraylist closes
  			indexClose = current.indexOf("]");
  			/* string for everything between the second arraylist and the 
  			 third arraylist, which is split on commas*/
  			String second = current.substring(0, indexOpen);
  			String secondArr[] = second.split(",");
  			// assigns brand, material, and price based on the split array
  			String brand = secondArr[0];
  			String material = secondArr[1];
  			String price = secondArr[2];
  			// dates takes everything between the brackets
  			String dates = current.substring(indexOpen+1, indexClose);
  			/* filenName starts after the comma after the third 
  			array and goes to the end */
  			String fileName = current.substring(indexClose+2);
  			// new article constructed using all the determined fields
  			Article art = new Article(category, size, occasion, color, brand, material,
                                  price, dates, fileName);
            // each article is added to clothes
  			add(art);
  			
  		}
  	}catch(IOException e){
      e.printStackTrace();
  	}
  	sort();
    System.out.println("SORT");
  	for(int i = 0; i<clothes.size(); i++){
  		System.out.println(Article.toString(clothes.get(i)));
  	}
  }
  
  public void add(Article art){
  	clothes.add(art);
  }
  
  public boolean remove(Article art){
  	for(int i = 0; i<len(); i++){
  		if (get(i).getFileName().equals(art.getFileName())){
  			clothes.remove(i);
  			return true;
  		}
  	}
  	return false;
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
  /*
  public ArrayList<String> stringToArrayList(){
  	String str = this.substring(1, this.length()-1);
  	String arr[] = str.split(",");
  	ArrayList<String> res = new ArrayList<String>();
  	for (int i = 0; i<arr.length; i++){
    res.set(i,arr[i]);
  	}
  	return res;
    }

  */
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

  	other.sort(null);
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
  
  public int randArticle(String category){
  	Random rand = new Random();
	int artIndex;
  	boolean foundFirst = false;
  	int index = 0; 
  	int firstIndex = 0; 
  	int lastIndex = 0;
  	boolean foundLast = false;
  	while(!foundFirst || !foundLast){
  		Article current = clothes.get(index);
  		if(current.getCategory().equals(category) && !foundFirst){
  			firstIndex = index;
  			foundFirst = true;
  		}
  		if ((clothes.size()-1) == index){
  			lastIndex = index;
  			foundLast = true;
  		}else{
  			Article next = clothes.get(index+1);
  			if(current.getCategory().equals(category) &&
  				!next.getCategory().equals(category)){
  					lastIndex = index;
  					foundLast = true;
  			}
  		}
  		index++;
  	}
	artIndex = rand.nextInt(lastIndex - firstIndex + 1) + firstIndex;
  	return artIndex;
  }
  
  
}
  
  

