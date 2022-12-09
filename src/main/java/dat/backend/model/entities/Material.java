package dat.backend.model.entities;

public class Material
{
    private int materialId;
    private String description;
    private String type;
    private String unit;
    private double unit_price;

    public Material(int materialId, String description, String type, String unit, double unit_price)
    {
        this.materialId = materialId;
        this.description = description;
        this.type = type;
        this.unit = unit;
        this.unit_price = unit_price;
    }

    public Material(String description, String type, String unit, double unit_price)
    {
        this.description = description;
        this.type = type;
        this.unit = unit;
        this.unit_price = unit_price;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialId=" + materialId +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", unitPrice=" + unit_price +
                '}';
    }
}
