package application.gsonpars;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nina on 2017-10-28.
 */
public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("example.json"));
            GsonParser gp = gson.fromJson(br, GsonParser.class);
            //System.out.println(gp);

            List<Content> list = gp.getDiagram().getContent();

            if (gp != null) {
                for (Content c : list)
                    for (Content_ con : c.getContent()) {
                        System.out.print("from: " + con.getFrom() + "\n" +
                                "to: " + con.getTo() + "\n" +
                                "message: " + con.getMessage() + "\n\n");
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br == null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
