package com.DragonLegend.DragonLegendTable.Model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Document("Table")//CollecionTame
public class Table {
    @Field(targetType = FieldType.OBJECT_ID)
    private ObjectId id;
    @NotNull
    @NotEmpty
    private String nameId;
    private boolean closed;
    private String extraInfo;
    @Nullable
    private List<Order> associatedOrder;
    private String waiter;
    public Table() {

    }

    public Table(ObjectId id, String nameId, boolean closed, String extraInfo, List<Order> associatedOrder, String waiter) {
        this.id = id;
        this.nameId = nameId;
        this.closed = closed;
        this.extraInfo = extraInfo;
        this.associatedOrder = associatedOrder;
        this.waiter = waiter;
    }
/*
    public Table(ObjectId id, String nameId, boolean closed, String extraInfo, int associatedOrder) {
        this.id = id;
        this.nameId = nameId;
        this.closed = closed;
        this.extraInfo = extraInfo;
        this.associatedOrder = associatedOrder;
    }
*/
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }
    public String getNameId() {
        return nameId;
    }
    public void setNameId(String nameId) {
        this.nameId = nameId;
    }
    public Boolean getClosed() {
        return closed;
    }
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }
    public String getExtraInfo() {
        return extraInfo;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    public List<Order> getAssociatedOrder() {
        return associatedOrder;
    }
    public void setAssociatedOrder(List<Order> associatedOrder) {
        this.associatedOrder = associatedOrder;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id='" + id + '\'' +
                ", nameId='" + nameId + '\'' +
                ", closed=" + closed +
                ", extraInfo='" + extraInfo + '\'' +
                ", associatedOrder=" + associatedOrder +
                '}';
    }
}
