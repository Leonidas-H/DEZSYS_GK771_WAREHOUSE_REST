package rest.model;

public class ProductTemplate {
    private String name;
    private String category;
    private String[] units;
    private int minQty;
    private int maxQty;

    public ProductTemplate(String name, String category, String[] units, int minQty, int maxQty) {
        this.name = name;
        this.category = category;
        this.units = units;
        this.minQty = minQty;
        this.maxQty = maxQty;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String[] getUnits() {
        return units;
    }

    public int getMinQty() {
        return minQty;
    }

    public int getMaxQty() {
        return maxQty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnits(String[] units) {
        this.units = units;
    }
    
    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }

    public void setMaxQty(int maxQty) {
        this.maxQty = maxQty;
    }
}