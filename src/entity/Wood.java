package entity;

public class Wood {
    private int id;
    private String name;
    private float price;
    private String introce;
    private int count;
    private String type;

    public Wood() {
    }

    public Wood(String name, float price, String introce, int count, String type) {
        this.name = name;
        this.price = price;
        this.introce = introce;
        this.count = count;
        this.type = type;
    }

    public Wood(int id, String name, float price, String introce, int count, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.introce = introce;
        this.count = count;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIntroce() {
        return introce;
    }

    public void setIntroce(String introce) {
        this.introce = introce;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
