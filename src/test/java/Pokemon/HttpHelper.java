package Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class HttpHelper {


	public static String GetRequest(String URL) throws IOException {
		URL url = new URL(URL);
		URLConnection conn = url.openConnection();
		InputStream is = conn.getInputStream();
		
		 String result = IOUtils.toString(is, StandardCharsets.UTF_8);
		 
		return result;
		 
	}
}
