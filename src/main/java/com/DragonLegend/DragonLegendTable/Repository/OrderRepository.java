package com.DragonLegend.DragonLegendTable.Repository;

import com.DragonLegend.DragonLegendTable.Model.MenuItem;
import com.DragonLegend.DragonLegendTable.Model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository  extends MongoRepository<Order,String> {
}
