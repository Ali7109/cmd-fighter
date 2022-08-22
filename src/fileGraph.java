import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class fileGraph extends fileStructure {
	/**
	 * read the graph from a file database of characters
	 * file format:
	 * number of vertices
	 * number of edges 
	 */
	public fileGraph(String filename) {
		super();
		Scanner myReader;
		try {
			myReader = new Scanner(new File(filename)).useDelimiter("[\n\r,]+");
			V = myReader.nextInt();
			E = myReader.nextInt(); 
			this.adj = new HashMap<Integer, Fighter>();
			
			for(int i = 0; i < E; i++) {
				String str1 = myReader.next();
				double attack = myReader.nextDouble();
				double defense = myReader.nextDouble();
				double stealth = myReader.nextDouble();
				this.adj.put(i, new Fighter(str1,attack,defense,stealth));
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
