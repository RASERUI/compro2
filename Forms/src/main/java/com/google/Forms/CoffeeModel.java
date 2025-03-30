package com.google.Forms;

import java.util.Arrays;
import java.util.List;

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
        this.flavorNotes = flavorNotes;
        this.brewMethod = brewMethod;
    }

    public static List<CoffeeModel> getSampleCoffees() {
        return List.of(
                new CoffeeModel(1, "Espresso", "Coffee", "250g", 12.99,
                        "Dark Roast", "Ethiopia", false, 150,
                        Arrays.asList("Rich", "Bold", "Chocolatey", "Caramel"),
                        "Espresso Machine")
        );
    }

    public String getFlavorNotesString() {
        return String.join(", ", flavorNotes);
    }

    public void setFlavorNotesFromString(String flavorNotesString) {
        this.flavorNotes = Arrays.asList(flavorNotesString.split(",\\s*"));
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getRoastLevel() { return roastLevel; }
    public void setRoastLevel(String roastLevel) { this.roastLevel = roastLevel; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public boolean isDecaf() { return decaf; }
    public void setDecaf(boolean decaf) { this.decaf = decaf; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public List<String> getFlavorNotes() { return flavorNotes; }
    public void setFlavorNotes(List<String> flavorNotes) { this.flavorNotes = flavorNotes; }

    public String getBrewMethod() { return brewMethod; }
    public void setBrewMethod(String brewMethod) { this.brewMethod = brewMethod; }
}
