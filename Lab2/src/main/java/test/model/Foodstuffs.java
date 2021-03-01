package test.model;

import java.sql.Date;

public class Foodstuffs {

    private int id;
    private String name;
    private int purchasePrice;
    private int amount;
    private int markup;
    private Date shelfLife;
    private String comment;

    public Foodstuffs(){

    }

    public Foodstuffs(String name){
        this.name = name;
    }

    public Foodstuffs(String name, int purchasePrice, int amount, int markup){
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
        this.markup = markup;
    }

    public Foodstuffs(int id, String name, int purchasePrice, int amount, int markup, Date shelfLife){
        this.id = id;
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
        this.markup = markup;
        this.shelfLife = shelfLife;
    }

    public Foodstuffs(String name, int purchasePrice, int amount, int markup, Date shelfLife, String comment){
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
        this.markup = markup;
        this.shelfLife = shelfLife;
        this.comment = comment;
    }

    public Foodstuffs(String name, int purchasePrice, int amount, int markup, Date shelfLife){
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.amount = amount;
        this.markup = markup;
        this.shelfLife = shelfLife;
    }

    public void setName(String name) { this.name = name; }

    public void setPurchasePrice(int purchasePrice) { this.purchasePrice = purchasePrice; }

    public void setAmount(int amount) { this.amount = amount; }

    public void setMarkup(int markup) { this.markup = markup; }

    public void setShelfLife(Date shelfLife) { this.shelfLife = shelfLife; }

    public void setComment(String comment) { this.comment = comment; }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getPurchasePrice() { return purchasePrice; }

    public int getAmount() { return amount; }

    public int getMarkup() { return markup; }

    public Date getShelfLife() { return shelfLife; }

    public String getComment() { return comment; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FoodStuff{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", purchasePrice=").append(purchasePrice);
        sb.append(", amount=").append(amount);
        sb.append(", markup=").append(markup);
        sb.append(", shelfLife=").append(shelfLife);
        sb.append(", comment=").append(comment);
        sb.append('}');
        return sb.toString();
    }
}
