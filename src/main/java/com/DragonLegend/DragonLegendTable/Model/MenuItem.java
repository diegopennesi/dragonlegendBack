package com.DragonLegend.DragonLegendTable.Model;
import com.DragonLegend.DragonLegendTable.Utility.ObjectIdStringSerializer;
import com.DragonLegend.DragonLegendTable.Utility.ObjectIdStringSeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import java.util.List;
@Document("MenuItem")//CollecionTame
public class MenuItem {
    @Field(targetType = FieldType.OBJECT_ID)
    @JsonSerialize(using = ObjectIdStringSerializer.class)
    @JsonDeserialize(using = ObjectIdStringSeserializer.class)
    ObjectId id;
    @NotEmpty
    @NotNull
    private String itemName;
    private List<String> subChoice;
    private String description;
    private double price;
    private String menuClass;
    private String Allergens ;
    private boolean isActive;
    public MenuItem(){};
    public MenuItem(String itemName, List<String> subChoice, String description, double price, String menuClass, String allergens, boolean isActive) {
        this.itemName = itemName;
        this.subChoice = subChoice;
        this.description = description;
        this.price = price;
        this.menuClass = menuClass;
        this.isActive= isActive;
        Allergens = allergens;
    }
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<String> getSubChoice() {
        return subChoice;
    }

    public void setSubChoice(List<String> subChoice) {
        this.subChoice = subChoice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMenuClass() {
        return menuClass;
    }

    public void setMenuClass(String menuClass) {
        this.menuClass = menuClass;
    }

    public String getAllergens() {
        return Allergens;
    }

    public void setAllergens(String allergens) {
        Allergens = allergens;
    }

    public boolean isActive(){return isActive;}
    public void setActive(boolean isActive){ this.isActive=isActive;}
    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", subChoice=" + subChoice +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", menuClass=" + menuClass +
                ", Allergens='" + Allergens + '\'' +
                '}';
    }
}
