package application.gsonpars;

/**
 * Created by Nina on 2017-10-26.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GsonParser {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("processes")
    @Expose
    private List<Process> processes = new ArrayList<Process>();
    @SerializedName("diagram")
    @Expose
    private Diagram diagram;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public Diagram getDiagram() { return diagram; }

    public void setDiagram(Diagram diagram) {
        this.diagram = diagram;
    }

}