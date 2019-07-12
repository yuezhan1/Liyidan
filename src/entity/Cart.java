package entity;

import java.util.Date;

public class Cart {
    int id;
    String name;
    float price;
    String introce;
    int buyCount;
    String type;
    String username;
    Date time;
    public Cart(){}
    public Cart(int id, String name, float price, String introce, int buyCount, String type, String username) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.introce = introce;
        this.buyCount = buyCount;
        this.type = type;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
