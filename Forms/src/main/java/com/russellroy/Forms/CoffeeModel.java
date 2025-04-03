package com.russellroy.Forms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CoffeeModel {
    private int id;
    private String name;
    private String type;
    private String size;
    private double price;
    private String roastLevel;
    private String origin;
    private boolean decaf;
    private int stock;
    private List<String> flavorNotes;
    private String brewMethod;

    public CoffeeModel() {
        this.flavorNotes = Collections.emptyList(); // Initialize to empty list instead of null
    }

    public CoffeeModel(int id, String name, String type, String size, double price,
                       String roastLevel, String origin, boolean decaf, int stock,
                       List<String> flavorNotes, String brewMethod) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.decaf = decaf;
        this.stock = stock;
        this.flavorNotes = flavorNotes != null ? flavorNotes : Collections.emptyList();
        this.brewMethod = brewMethod;
    }

    public static CoffeeModel createSampleCoffee() {
        return new CoffeeModel(
                1,
                "Espresso",
                "Coffee",
                "250g",
                12.99,
                "Dark Roast",
                "Ethiopia",
                false,
                150,
                Arrays.asList("Rich", "Bold", "Chocolatey", "Caramel"),
                "Espresso Machine"
        );
    }

    public String getFlavorNotesString() {
        return flavorNotes != null ? String.join(", ", flavorNotes) : "";
    }

    public void setFlavorNotesFromString(String flavorNotesString) {
        if (flavorNotesString == null || flavorNotesString.trim().isEmpty()) {
            this.flavorNotes = Collections.emptyList();
        } else {
            this.flavorNotes = Arrays.asList(flavorNotesString.split("\\s*,\\s*"));
        }
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public String getType() { return type; }
    public void setType(String type) {
        this.type = Objects.requireNonNull(type, "Type cannot be null");
    }

    public String getSize() { return size; }
    public void setSize(String size) {
        this.size = Objects.requireNonNull(size, "Size cannot be null");
    }

    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public String getRoastLevel() { return roastLevel; }
    public void setRoastLevel(String roastLevel) {
        this.roastLevel = Objects.requireNonNull(roastLevel, "Roast level cannot be null");
    }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) {
        this.origin = Objects.requireNonNull(origin, "Origin cannot be null");
    }

    public boolean isDecaf() { return decaf; }
    public void setDecaf(boolean decaf) { this.decaf = decaf; }

    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative");
        this.stock = stock;
    }

    public List<String> getFlavorNotes() {
        return flavorNotes != null ? flavorNotes : Collections.emptyList();
    }
    public void setFlavorNotes(List<String> flavorNotes) {
        this.flavorNotes = flavorNotes != null ? flavorNotes : Collections.emptyList();
    }

    public String getBrewMethod() { return brewMethod; }
    public void setBrewMethod(String brewMethod) {
        this.brewMethod = Objects.requireNonNull(brewMethod, "Brew method cannot be null");
    }

    @Override
    public String toString() {
        return "CoffeeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", roastLevel='" + roastLevel + '\'' +
                ", origin='" + origin + '\'' +
                ", decaf=" + decaf +
                ", stock=" + stock +
                ", flavorNotes=" + flavorNotes +
                ", brewMethod='" + brewMethod + '\'' +
                '}';
    }
}