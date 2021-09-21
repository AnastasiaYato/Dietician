/**
 * @Author Anastazja Noemi Lisowska
 */

import java.util.Objects;

public class Ingredient {
    Product product;
    int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Ingredient(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Ingredient() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Ingredient that = (Ingredient) o;
        return quantity == that.quantity &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCalories() {
        return ((product.cal)/100)*quantity;
    }
    public double CheckPrice(){
        return ((product.price)/100)*quantity;
    }
    public void Display(){
        product.Display();
        System.out.println(quantity);
    }
}
