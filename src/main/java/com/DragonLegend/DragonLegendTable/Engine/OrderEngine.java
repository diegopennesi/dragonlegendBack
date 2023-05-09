package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.Order;
import com.DragonLegend.DragonLegendTable.Model.Table;
import com.DragonLegend.DragonLegendTable.Repository.OrderRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class OrderEngine extends TableEngine implements OrderEngineInterface
{
    @Autowired
    OrderRepository entity;
    public List<Order> getOrderByTable(int limit,String table,Boolean paid) throws Exception {
        Table x = SearchTableByIdAndStatus(table,false, false);

       // x.setAssociatedOrder(new ArrayList<>());
        return x.getAssociatedOrder();
    }
    @Override
    public List<Order> putOrder(List<Order> orderList,String table) throws Exception {
        Table x = SearchTableByIdAndStatus(table,false, false);
        x.setAssociatedOrder(orderList);
        return x.getAssociatedOrder();
    }

    @Override
    public List<Order> putSingleOrder(Order order, String table) throws Exception {
        Table x = SearchTableByIdAndStatus(table,false, false);
        //x.getAssociatedOrder().add(order);
        Optional<Order> existingOrder=x.getAssociatedOrder().stream().filter(e->e.getId().equals(order.getId())).findFirst();
        if(existingOrder.isPresent()){
            Order updateOrder=existingOrder.get();
            updateOrder.setPaid(order.isPaid());
            updateOrder.setExtraInfo(order.getExtraInfo());
        }else{
            x.getAssociatedOrder().add(order);
        }
       updateTable(x);
        return x.getAssociatedOrder();
    }


}
