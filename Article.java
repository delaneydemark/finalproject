import java.util.ArrayList;

public class Article implements Comparable<Article>{


    private String category;
    private String size;
    private ArrayList<String> occasion = new ArrayList<String>();
    private ArrayList<String> color = new ArrayList<String>();
    private String brand;
    private String material;
    private String price;
    private ArrayList<String> dates = new ArrayList<String>();
    private String fileName;

    public Article(String ca, String s, String o, String co, String b, String m,
		   String p, String d, String f){
		category = ca;
		size = s;
		// for now, when the user puts in co,o,d they have to put a comma in between
		// splitting the occasion string on commas which creates an array
		String occ[]= o.split(", ");
		// adding each of the occasions to the arraylist 
		for (int i = 0; i<occ.length; i++){
			occasion.add(occ[i]);
		}
		// splitting the color string on commas which creates an array
		String col[] = co.split(", ");
		// adding each of the colors to the color arraylist
		for (int i = 0; i<col.length; i++){
			color.add(col[i]);
		}
		brand = b;
		material = m;
		price = p;
		// splitting the dates string on a comma which creates an array
		String date[] = d.split(", ");
		// adding each of the dates to the dates arraylist
		for (int i = 0; i<date.length; i++){
			dates.add(date[i]);
		}
		fileName = f; 
	
    }
    
    public String getCategory(){
    	return category;
    }
    public void setCategory(String c){
    	category = c;
    }
    
    public String getSize(){
    	return size;
    }
    public void setSize(String s){
    	size = s;
    }
    
    public ArrayList<String> getOccasion(){
    	return occasion;
    }
     /* adding the occasion to the arraylist,
    not deleting and replacing with new*/
    public void setOccasion(String o){
    	occasion.clear();
    	String occ[]= o.split(", ");
		// adding each of the occasions to the arraylist 
		for (int i = 0; i<occ.length; i++){
			occasion.add(occ[i]);
		}
    }
    
    public ArrayList<String> getColor(){
    	return color;
    }
     /* adding the color to the arraylist,
    not deleting and replacing with new*/
    public void setColor(String c){
    	color.clear();
    	String col[] = c.split(", ");
		// adding each of the colors to the color arraylist
		for (int i = 0; i<col.length; i++){
			color.add(col[i]);
		}
    }
    
    public String getBrand(){
    	return brand;
    }
    public void setBrand(String b){
    	brand = b;
    }
    
    public String getMaterial(){
    	return material;
    }
    public void setMaterial(String m){
    	material = m;
    }
    
    public String getPrice(){
    	return price;
    }
    // gui will take the user input as a string, so convert it to a double
    public void setPrice(String p){
    	price = p;
    }
    
    public ArrayList<String> getDates(){
    	return dates;
    }
     /* adding the date to the arraylist,
    not deleting and replacing with new*/
    public void setDates(String d){
    	dates.clear();
    	String date[] = d.split(", ");
		// adding each of the dates to the dates arraylist
		for (int i = 0; i<date.length; i++){
			dates.add(date[i]);
		}
    }
    
    public String getFileName(){
    	return fileName;
    }
    public void setFileName(String f){
    	fileName = f;
    }
    
    public static String toString(Article art){
    	return art.getCategory() + "," + art.getSize() + "," + art.getOccasion() + "," + art.getColor() + 
    			"," + art.getBrand() + "," + art.getMaterial() + "," + art.getPrice() + "," + art.getDates() +
    			"," + art.getFileName();
    }

  public int compareTo(Article other){
    return getCategory().compareTo(other.getCategory());
  }

}
