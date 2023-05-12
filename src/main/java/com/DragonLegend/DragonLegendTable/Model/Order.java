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


@Document("Orders")//CollecionTame
public class Order {

    @Field(targetType = FieldType.OBJECT_ID)
    @JsonSerialize(using = ObjectIdStringSerializer.class)
    @JsonDeserialize(using = ObjectIdStringSeserializer.class)
    ObjectId id;
    @NotEmpty
    @NotNull
    private String itemName;
    private String extraInfo;
    @NotEmpty
    @NotNull
    private String printedString;
    private String waiter;
    private boolean paid;
    private double price;

    public Order() {

    }

    public Order(ObjectId id,String itemName, String extraInfo, String printedString, String waiter, boolean paid,double price) {
        this.id = id;
        this.itemName = itemName;
        this.extraInfo = extraInfo;
        this.printedString = printedString;
        this.waiter = waiter;
        this.paid = paid;
        this.price= price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getPrintedString() {
        return printedString;
    }

    public void setPrintedString(String printedString) {
        this.printedString = printedString;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                ", printedString='" + printedString + '\'' +
                ", waiter='" + waiter + '\'' +
                ", paid=" + paid + '\'' +
                ", price=" + price +
                '}';
    }

}
