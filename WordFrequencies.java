import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;

public class WordFrequencies{

	public static void	main(String[] args) throws Exception{
	
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		java.io.BufferedReader stdIn =  new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

			String s = stdIn.readLine();
			String[] words;
				while(s != null){
					
					if ( args.length == 0 ) {
						words = normal(s);
					} else if ( args[0].equals("-s") || args[0].equals("-sc") || args[0].equals("-cs") ) {
						words = sensitive(s);
					} else {
						throw new IllegalArgumentException();
					}

					for ( String i : words ) {
						if ( map.containsKey(i) ) {
							int number = map.get(i);
							number++;
							map.put(i,number);
						} else {
							map.put(i,1);
						}
					}
					s= stdIn.readLine();
				}

			Set<String> keys = map.keySet();
			words = keys.toArray( new String[keys.size()]);
			Arrays.sort(words);

			if ( args.length == 0 || args[0].equals("-s")) {
				for ( String i : words ) {
					System.out.println( i + " " + map.get(i));
				}
			} else {
				for ( String i : words ) {
					System.out.println( i );
				}
			}

	}

	public static String[] normal( String str ) {
		//return a string array capitalized for normal op.
		String[] words = str.split("\\W+");
		for ( String i : words ) {
			i = i.toUpperCase();
		}
		return words;
	}

	public static String[] sensitive( String str ) {
		//returns a string array for case-sensitive operation
		return str.split("\\W+");
	}
}


//create a .txt (in text edit), save it in the same location as WordFrequencies.java, test running java WordFrequencies ( try blank here  or -s/-c/-sc/-cs) < ___________ (insert .txt file name here)
