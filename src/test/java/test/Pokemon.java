package test;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.*;
import org.junit.jupiter.api.Test;

import Pokemon.HttpHelper;
import Pokemon.JsonHelper;
class Pokemon {

	String URL = "https://pokeapi.co/api/v2/pokemon?limit=30,";
	@Test
	void test() throws IOException, JSONException {
		
		try{
		String result = HttpHelper.GetRequest(URL);
		 
		List<String> pokemonURLs = JsonHelper.GetJsonArray(result, "results","url", "" );
	
		List<String> results = new ArrayList<String>(); 
		 for (int i = 0; i < pokemonURLs.size(); i++)
		 {
			 String resultPokemon = HttpHelper.GetRequest(pokemonURLs.get(i));
			 
			 List<String> types = JsonHelper.GetJsonArray(resultPokemon, "types","name", "type");
			 
			 
			 for(int j=0; j< types.size();j++) {
				 if(types.get(j).equals("normal")) {
					 results.add(resultPokemon);
					 break;
				 }
			 }
		 }
		 
		 System.out.println("");
		 for(int j=0; j< results.size();j++) {
			 System.out.println(results.get(j));
		 }
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}

}
