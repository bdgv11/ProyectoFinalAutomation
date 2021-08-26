package Pojo;

public class Products {

    private String searchCriteria;
    private double dollarPrice;
    private double euroPrice;
    private double poundSterling;

    public Products(String searchCriteria, double dollarPrice, double euroPrice, double poundSterling){
        this.searchCriteria = searchCriteria;
        this.dollarPrice = dollarPrice;
        this.euroPrice = euroPrice;
        this.poundSterling = poundSterling;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public double getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(double dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }

    public double getSterlingPoundPrice() {
        return poundSterling;
    }

    public void setSterlingPoundPrice(double sterlingPoundPrice) {
        this.poundSterling = sterlingPoundPrice;
    }
}