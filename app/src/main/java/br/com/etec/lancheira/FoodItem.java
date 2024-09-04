package br.com.etec.lancheira;

public class FoodItem {
    private final String name;
    private final int imageResourceId;

    public FoodItem(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}