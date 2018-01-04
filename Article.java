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
			occasion.add(occ[i]);
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
}
