package application.gsonpars;

/**
 * Created by Nina on 2017-10-28.
 */

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Content {

    @SerializedName("node")
    @Expose
    private String node;
    @SerializedName("content")
    @Expose
    private List<Content_> content_ = null;

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public List<Content_> getContent() {
        return content_;
    }

    public void setContent(List<Content_> content) {
        this.content_ = content_;
    }


}
