package ooad.demo1;

/**
 * Created by zhongym on 2017/2/28.
 */
public class Guitar {
    private String serialNumber;
    private String builder;
    private String model;
    private String type;
    private String backWood;
    private String topWood;

    private double price;


    public Guitar() {
    }

    public Guitar(String serialNumber, String builder, String model, String type, String backWood, String topWood, double price) {
        this.serialNumber = serialNumber;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
