package ge.tbcitacademy.models;

import javax.xml.bind.annotation.XmlElement;

public class Tag {
    private long id;
    private String name;

    @XmlElement
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
