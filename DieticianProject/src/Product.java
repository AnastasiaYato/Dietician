/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.Objects;

public class Product { //for ListOfIngredients export/import
    String name;
    int quantityInPack;
    double cal;
    String unit;
    double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Product product = (Product) o;
        return quantityInPack == product.quantityInPack &&
                Double.compare(product.cal, cal) == 0 &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(unit, product.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantityInPack, cal, unit, price);
    }

    public Product(String name, int quantityInPack, double cal, String unit, double price) {
        this.name = name;
        this.quantityInPack = quantityInPack;
        this.cal = cal;
        this.unit = unit;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void Display(){
        System.out.println(name+" "+quantityInPack+" "+cal+" "+unit+" "+price);
    }
}
