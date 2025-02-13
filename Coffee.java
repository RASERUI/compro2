package com.russellroy;

class Coffee {
    String name;
    String type;
    String size;
    double price;
    String roastLevel;
    String origin;
    boolean isDecaf;
    int stock;
    String[] flavorNotes;
    String brewMethod;

    public Coffee(String name, String type, String size, double price, String roastLevel,
                  String origin, boolean isDecaf, int stock, String[] flavorNotes, String brewMethod) {
        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
        this.roastLevel = roastLevel;
        this.origin = origin;
        this.isDecaf = isDecaf;
        this.stock = stock;
        this.flavorNotes = flavorNotes;
        this.brewMethod = brewMethod;
    }

    public double calculatePrice() {
        return price + switch (size.toLowerCase()) {
            case "medium" -> 1.5;
            case "large" -> 3.0;
            default -> 0;
        };
    }

    public boolean checkStock() {
        return stock > 0;
    }

    public void addFlavor(String note) {
        flavorNotes = java.util.Arrays.copyOf(flavorNotes, flavorNotes.length + 1);
        flavorNotes[flavorNotes.length - 1] = note;
    }

    public void updateStock(int quantity) {
        stock += quantity;
    }

    public void setDecaf(boolean isDecaf) {
        this.isDecaf = isDecaf;
    }

    public void changeRoastLevel(String newRoastLevel) {
        this.roastLevel = newRoastLevel;
    }

    public void discount(double percentage) {
        price -= price * percentage / 100;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getRoastLevel() {
        return roastLevel;
    }

    public String getOrigin() {
        return origin;
    }

    public boolean isDecaf() {
        return isDecaf;
    }

    public int getStock() {
        return stock;
    }

    public String[] getFlavorNotes() {
        return flavorNotes;
    }

    public String getBrewMethod() {
        return brewMethod;
    }

    public String describe() {
        String decafStatus = isDecaf ? "decaffeinated" : "not decaffeinated";
        StringBuilder flavorDescription = new StringBuilder();
        for (String flavor : flavorNotes) {
            flavorDescription.append(flavor).append(", ");
        }
        if (flavorDescription.length() > 0) {
            flavorDescription.setLength(flavorDescription.length() - 2);
        }

        if (name.equalsIgnoreCase("Americano Latte")) {
            return String.format("An Americano is made by simply adding hot water to espresso, creating a smooth coffee " +
                            "with a flavor similar to drip coffee but richer. It is a %s roast from America. It is %s " +
                            "and has flavor notes of %s. Brew method: %s.",
                    roastLevel, origin, decafStatus, flavorDescription, brewMethod);
        } else if (name.equalsIgnoreCase("Latte")) {
            return String.format("A latte is made with espresso and steamed milk, topped with a small amount of foam, " +
                            "resulting in a creamy and smooth coffee flavor. It is a %s roast from Italy. It is %s " +
                            "and has flavor notes of %s. Brew method: %s.",
                    roastLevel, decafStatus, flavorDescription, brewMethod);
        }

        return "No description available.";
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee1 = new Coffee("Americano Latte", "Latte", "Medium", 5.00, "Dark",
                "America", false, 10, new String[]{"Chocolate", "Nutty", "Smooth", "Vanilla"}, "Espresso");

        System.out.println("Price (Medium): $" + coffee1.calculatePrice());
        System.out.println("In Stock: " + coffee1.checkStock());
        coffee1.addFlavor("Vanilla");
        coffee1.updateStock(5);
        System.out.println("Updated Stock: " + coffee1.stock);
        coffee1.discount(10);
        System.out.println("Discounted Price: $" + coffee1.price);
        System.out.println("Coffee Description: " + coffee1.describe());

        Coffee coffee2 = new Coffee("Latte", "Latte", "Large", 4.50, "Medium",
                "Italy", true, 5, new String[]{"Citrus", "Caramel", "Sweet"}, "Drip");

        System.out.println("\nPrice (Large): $" + coffee2.calculatePrice());
        System.out.println("In Stock: " + coffee2.checkStock());
        coffee2.setDecaf(false);
        System.out.println("Is Decaf: " + coffee2.isDecaf());
        coffee2.changeRoastLevel("Light");
        System.out.println("New Roast Level: " + coffee2.roastLevel);
        coffee2.discount(15);
        System.out.println("Discounted Price: $" + coffee2.price);
        System.out.println("Coffee Description: " + coffee2.describe());
    }
}