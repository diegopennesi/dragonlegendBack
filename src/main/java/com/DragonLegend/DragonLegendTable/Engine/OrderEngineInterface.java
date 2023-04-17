package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.Order;

import java.util.List;


public interface OrderEngineInterface {
    public List<Order> getOrderByTable(int limit,String table, Boolean paid) throws Exception;
    public List<Order> putOrder(List<Order> orderList,String table) throws Exception;

}
