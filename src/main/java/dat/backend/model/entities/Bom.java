package dat.backend.model.entities;

public class Bom {
    private int bomId;
    private int orderId;
    private int materialId;
    private String definition;
    private String description;
    private String unit;
    private int length;
    private double price;
    private int quantity;

    public Bom() {
    }

    public Bom(int orderId, int materialId, String definition, String description, String unit, int length, double price, int quantity) {
        this.orderId = orderId;
        this.materialId = materialId;
        this.description = description;
        this.definition = definition;
        this.unit = unit;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public Bom(int materialId, String definition, String description, String unit, int length, double price, int quantity)
    {
        this.materialId = materialId;
        this.definition = definition;
        this.description = description;
        this.unit = unit;
        this.length = length;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBomId() {
        return bomId;
    }

    public void setBomId(int bomId) {
        this.bomId = bomId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Bom{" +
                "bomId=" + bomId +
                ", orderId=" + orderId +
                ", materialId=" + materialId +
                ", definition='" + definition + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", length=" + length +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}