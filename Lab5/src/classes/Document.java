package classes;

import java.io.Serializable;
import java.util.HashMap;

public class Document implements Serializable {
    private String id;
    private String name;
    private HashMap<String, Object> tags = new HashMap<String, Object>();
    private String path;

    public Document(String id, String name, String path)
    {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public HashMap<String, Object> getTags() {
        return tags;
    }
}
