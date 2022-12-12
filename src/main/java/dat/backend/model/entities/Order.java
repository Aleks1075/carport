package dat.backend.model.entities;

import java.sql.Timestamp;

public class Order
{
    private int order_id;
    private String username;
    private Timestamp order_date;
    private int carport_length;
    private int carport_width;
    private String order_status;
    private double price;

    public Order(int order_id, String username, int carport_length, int carport_width, String order_status, double price)
    {
        this.order_id = order_id;
        this.username = username;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.order_status = order_status;
        this.price = price;
    }

    public Order(int order_id, String username, Timestamp order_date, int carport_length, int carport_width, String order_status, double price)
    {
        this.order_id = order_id;
        this.username = username;
        this.order_date = order_date;
        this.carport_length = carport_length;
        this.carport_width = carport_width;
        this.order_status = order_status;
        this.price = price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public int getCarport_length() {
        return carport_length;
    }

    public void setCarport_length(int carport_length) {
        this.carport_length = carport_length;
    }

    public int getCarport_width() {
        return carport_width;
    }

    public void setCarport_width(int carport_width) {
        this.carport_width = carport_width;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
