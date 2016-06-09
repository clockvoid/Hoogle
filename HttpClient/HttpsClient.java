import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

class HttpsClient {

	private String constURL = "https://www.haskell.org/hoogle/";

	public String searchWord(String arg) throws IOException {
		URL url = new URL(constURL + "?hoogle=" + arg);
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String body = "";
		String tmp;
		while ((tmp= reader.readLine()) != null) {
			body += tmp + "\n";
		}
		reader.close();
		conn.disconnect();
		return body;
	}
}
