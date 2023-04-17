package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.Order;
import com.DragonLegend.DragonLegendTable.Model.Table;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class OrderEngine extends TableEngine implements OrderEngineInterface
{
    public List<Order> getOrderByTable(int limit,String table,Boolean paid) throws Exception {
        Table x = SearchTableByIdAndStatus(table,false, false);
       // x.setAssociatedOrder(new ArrayList<>());
        return x.getAssociatedOrder();
    }
    @Override
    public List<Order> putOrder(List<Order> orderList,String table) throws Exception {
        Table x = SearchTableByIdAndStatus(table,false, false);
        x.setAssociatedOrder(orderList);
        updateTable(x);
        return x.getAssociatedOrder();
    }


}
