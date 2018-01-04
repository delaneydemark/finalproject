import java.util.ArrayList;

public class Article{

	public static void main(String[] args){
		Article test = new Article("Shirt", "Small", "Evening Formal", "Red Black", "Zara",
						"Silk", "95.00", "1/1/18 1/2/18 1/3/18", "test.jpg");
		System.out.println(test.getCategory());
		System.out.println(test.getSize());
		System.out.println(test.getOccasion());
		System.out.println(test.getColor());
		System.out.println(test.getBrand());
		System.out.println(test.getMaterial());
		System.out.println(test.getPrice());
		System.out.println(test.getDates());
		System.out.println(test.getFileName());
	}
    private String category;
    private String size;
    private ArrayList<String> occasion = new ArrayList<String>();
    private ArrayList<String> color = new ArrayList<String>();
    private String brand;
    private String material;
    private double price;
    private ArrayList<String> dates = new ArrayList<String>();
    private String fileName;

    public Article(String ca, String s, String o, String co, String b, String m,
		   String p, String d, String f){
		category = ca;
		size = s;
		// for now, when the user puts in co,o,d they have to put a space in between
		// splitting the occasion string on whitespace which creates an array
		String occ[]= o.split("\\s+");
		// adding each of the occasions to the arraylist 
		for (int i = 0; i<occ.length; i++){
			occasion.add(occ[i]);
		}
		// same for colors
		String col[] = co.split("\\s+");
		for (int i = 0; i<col.length; i++){
			color.add(col[i]);
		}
		brand = b;
		material = m;
		price = Double.parseDouble(p);
		// same for dates
		String date[] = d.split("\\s+");
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
    
    public ArrayList<String> getOccasion(){
    	return occasion;
    }
    private void setOccasion(String o){
    	occasion.add(o);
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
