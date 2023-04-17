package com.DragonLegend.DragonLegendTable.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("Orders")//CollecionTame
public class Order {

    @Field(targetType = FieldType.OBJECT_ID)
    String id;
    @NotEmpty
    @NotNull
    private String itemName;
    private String extraInfo;
    @NotEmpty
    @NotNull
    private String printedString;
    private String waiter;
    private boolean paid;

    public Order() {

    }

    public Order(String id,String itemName, String extraInfo, String printedString, String waiter, boolean paid) {
        this.id = id;
        this.itemName = itemName;
        this.extraInfo = extraInfo;
        this.printedString = printedString;
        this.waiter = waiter;
        this.paid = paid;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
