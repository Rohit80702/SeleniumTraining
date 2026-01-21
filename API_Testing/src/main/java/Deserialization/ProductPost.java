package Deserialization;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPost {
    private String id;
    private String name;
    private DataGet data;
    private String createdAt;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DataGet getData() { return data; }
    public void setData(DataGet data) { this.data = data; }

    public String getCreatedAt(){return createdAt;}
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}

