package Pokemon;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonHelper {

	
	
	public static  JSONObject GetJSONObj(String json) throws JSONException
	{
		JSONObject obj = new JSONObject(json);
		 
		 return obj;
	}
	
	public static List<String> GetJsonArray(String json, String list, String objName1,String objName2) throws JSONException {
		
		List<String> strings =  new ArrayList<String>();  
		JSONObject obj = GetJSONObj(json);
		JSONArray arr = obj.getJSONArray(list); // notice that `"posts": [...]`
		
		 for (int i = 0; i < arr.length(); i++)
		 {
			 
			 JSONObject jsonObj = arr.getJSONObject(i);
			 
			 
			 if(objName2 != "")
			 {
				  jsonObj = jsonObj.getJSONObject(objName2);
			 }
				 
			 strings.add(jsonObj.getString(objName1));  
		 }
		 
		 return strings;
	}
}
