package wso2.codeWithJson;

import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * Created by irunika on 11/10/15.
 */
public class JsonObjects {
    private HashMap<Integer, JSONObject>  map = new HashMap<Integer, JSONObject>();

    public JsonObjects(){
        makeObject();
    }

    public void makeObject(){
        JSONObject a = new JSONObject();
        a.put("name", "Irunika");
        a.put("age", 23);

        JSONObject b = new JSONObject();
        b.put("name", "Lakmal");
        b.put("age", 21);

        JSONObject c = new JSONObject();
        c.put("name", "Weeraratne");
        c.put("age", 24);

        JSONObject d = new JSONObject();
        d.put("name", "Gayan");
        d.put("age", 20);

        map.put(1,a);
        map.put(2,b);
        map.put(3,c);
        map.put(4,d);
    }

    public JSONObject getDetails(Integer index){

        if(map.containsKey(index)){
            return map.get(index);
        }
        else
            return null;
    }
}
