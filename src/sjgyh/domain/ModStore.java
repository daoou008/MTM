package sjgyh.domain;

import java.util.Date;

@SuppressWarnings("all")
public class ModStore {
    private int function_id;
    private String type;
    private String description;
    private int priority;
    private double prepass;
    private int quantity;

    public ModStore() {
    }

    public ModStore(int function_id, String type, String description, int priority, double prepass, int quantity) {
        this.function_id = function_id;
        this.type = type;
        this.description = description;
        this.priority = priority;
        this.prepass = prepass;
        this.quantity = quantity;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ModStore{" +
                "function_id=" + function_id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", prepass=" + prepass +
                ", quantity=" + quantity +
                '}';
    }
}
