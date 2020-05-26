package sjgyh.domain;

@SuppressWarnings("all")
public class ModFunction {
    private int function_id;
    private String function_name;
    private String type;
    private String description;
    private String priority;
    private double prepass;

    public ModFunction() {
    }

    public ModFunction(int function_id, String function_name, String type, String description, String priority, double prepass) {
        this.function_id = function_id;
        this.function_name = function_name;
        this.type = type;
        this.description = description;
        this.priority = priority;
        this.prepass = prepass;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }

    public String getFunction_name() {
        return function_name;
    }

    public void setFunction_name(String function_name) {
        this.function_name = function_name;
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

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public double getPrepass() {
        return prepass;
    }

    public void setPrepass(double prepass) {
        this.prepass = prepass;
    }

    @Override
    public String toString() {
        return "ModFunction{" +
                "function_id=" + function_id +
                ", function_name='" + function_name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", prepass='" + prepass + '\'' +
                '}';
    }
}
