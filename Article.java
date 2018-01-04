import java.util.ArrayList;

public class Article{
    private String category;
    private String size
    private ArrayList<String> occassion;
    private ArrayList<String> color;
    private String brand;
    private String material;
    private double price;
    private ArrayList<String> dates;
    private String fileName;

    public Article(String ca, String s, String o, String co, String b, String m,
		   String p, String d, String f){
		category = ca;
		size = s;
		// for now, when the user puts in co,o,d they have to put a space in between
		String[] occ = o.split("\\s");
		for (int i = 0; i<occ.length; i++){
			occassion.add(occ[i]);
		}
		String[] col = co.split("\\s");
		for (int i = 0; i<col.length; i++){
			color.add(col[i]);
		}
		brand = b;
		material = b;
		price = Double.parseDouble(p);
		String[] date = d.split("\\s");
		for (int i = 0; i<date.length; i++){
			dates.add(date[i]);
		}
		fileName = f; 
	
    }
    
    public String getCategory(){
    	return category;
    }
    private void setCategory(String c){
    	category = c;
    }
    
    public String getSize(){
    	return size;
    }
    private void setSize(String s){
    	size = s;
    }
    
    public ArrayList<String> getOccassion(){
    	return occassion;
    }
    private void setOccasion(String o){
    	occassion.add(o);
    }
    
    public ArrayList<String> getColor(){
    	return color;
    }
    private void setColor(String c){
    	color.add(c);
    }
    
    public String getBrand(){
    	return brand;
    }
    private void setBrand(String b){
    	brand = b;
    }
    
    public String getMaterial(){
    	return material;
    }
    private void setMaterial(String m){
    	material = m;
    }
    
    public double getPrice(){
    	return price;
    }
    private void setPrice(double p){
    	price = p;
    }
    
    public ArrayList<String> getDates(){
    	return dates;
    }
    private void setDates(String d){
    	dates.add(d);
    }
    
    public String getFileName(){
    	return fileName;
    }
    private void setFileName(String f){
    	fileName = f;
    }
    
}
