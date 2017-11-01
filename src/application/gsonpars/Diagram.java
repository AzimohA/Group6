package application.gsonpars;

/**
 * Created by Nina on 2017-10-28.
 */

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diagram {

    @SerializedName("node")
    @Expose
    private String node;
    @SerializedName("content")
    @Expose
    private static List<Content> content = new ArrayList<Content>();

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public static List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}
