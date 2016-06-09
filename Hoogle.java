import java.util.*;
import java.lang.*;
import java.io.IOException;

class Hoogle {
	
	public static HttpsClient httpsClient;
	public static Parser parser;

	public static void main(String [] args) {
		httpsClient = new HttpsClient();
		parser = new Parser();
		for (String index : args) {
			System.out.println(index + ":");
			try {
				System.out.println(parser.parse(httpsClient.searchWord(index)).replaceAll("&gt;", ">"));
				System.out.println(":END:");
			} catch (IOException e) {
			}
		}
	}
}
