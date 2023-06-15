package models;

public class Product {
    private int productId;
    private String productName;
    private double unitPrice;
    private int unitsInStock;

    public Product(int productId, String productName, double unitPrice, int unitsInStock) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.unitsInStock = unitsInStock;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }
}
