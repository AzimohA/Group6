package application.jsonsimple;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Nina on 2017-11-01.
 */
public class SimplePars {
    private static final String filePath = "C:\\Users\\Nina\\Desktop\\Group6\\example.json";

    public static void main(String[] args) {

        try {
            // read the json file
            FileReader reader = new FileReader(filePath);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // get a String from the JSON object
            JSONObject one = (JSONObject) jsonObject.get("diagram");
            JSONArray content = (JSONArray) one.get("content");
            JSONObject contentOne = (JSONObject) content.get(0);
            JSONObject contentTwo = (JSONObject) content.get(1);
            JSONArray first = (JSONArray) contentOne.get("content");
            JSONArray second = (JSONArray) contentTwo.get("content");

            JSONObject o1 = (JSONObject) first.get(0);
            JSONObject o2 = (JSONObject) first.get(1);
            JSONObject o3 = (JSONObject) first.get(2);
            JSONObject o4 = (JSONObject) first.get(3);

            JSONObject oo1 = (JSONObject) second.get(0);
            JSONObject oo2 = (JSONObject) second.get(1);

            //System.out.print(o1.get("from") + " sends message " + o1.get("message") + " to " + o1.get("to") + "\n");
            //System.out.print(o2.get("from") + " sends message " + o2.get("message") + " to " + o2.get("to") + "\n");

            //System.out.print(oo1.get("from") + " sends message " + oo1.get("message") + " to " + oo1.get("to") + "\n");


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }

    }

}
