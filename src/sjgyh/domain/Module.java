package sjgyh.domain;

@SuppressWarnings("all")
public class Module {
    private int id;
    private String type;
    private String size;
    private String unit;

    public Module() {
    }

    public Module(int id, String type, String size, String unit) {
        this.id = id;
        this.type = type;
        this.size = size;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
