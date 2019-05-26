package models;

@SuppressWarnings("all")
public class Department implements java.io.Serializable {

    private String name, loacation;

    public Department() {
        name = " ";
        loacation = " ";
    }

    public Department(String name, String loacation) {
        this.name = name;
        this.loacation = loacation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoacation() {
        return this.loacation;
    }

    public void setLoacation(String loacation) {
        this.loacation = loacation;
    }

    @Override
    public String toString() {
        return "{" + " name='" + name + "'" + ", loacation='" + loacation + "'" + "}";
    }

}