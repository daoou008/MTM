package sjgyh.domain;

@SuppressWarnings("all")
public class CusModFunction {
    private int function_id;
    private String name;
    private String type;
    private String description;
    private int priority;
    private double prepass;
    private int alternative;//客户、模块组合对应后，查找库存，得出可用库存

    public CusModFunction(int function_id, String name, String type, String description, int priority, double prepass) {
        this.function_id = function_id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.priority = priority;
        this.prepass = prepass;
    }

    public CusModFunction() {
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getPrepass() {
        return prepass;
    }

    public void setPrepass(double prepass) {
        this.prepass = prepass;
    }

    public int getAlternative() {
        return alternative;
    }

    public void setAlternative(int alternative) {
        this.alternative = alternative;
    }

    @Override
    public String toString() {
        return "CusModFunction{" +
                "function_id=" + function_id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", prepass=" + prepass +
                ", alternative=" + alternative +
                '}';
    }
}
