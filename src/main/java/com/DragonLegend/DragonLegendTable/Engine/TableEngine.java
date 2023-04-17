package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.Table;
import com.DragonLegend.DragonLegendTable.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class TableEngine {
    @Autowired
    Dao dao;
    @Autowired
    TableRepository entity;


    public List<Table> getTable(int limit,boolean closed){
        return dao.searchTable(limit,closed);
    }
    public Table SearchTableByIdAndStatus(String tableId,boolean status,boolean nullable) throws Exception {
        return dao.searchTableByNameIdAndStatus(tableId,false,nullable);
    }
    public Table putTable(Table request) throws Exception {
        //request.setId(UUID.randomUUID().toString()); MANAGED BY MONGODB
        request.setAssociatedOrder(new ArrayList<>());
        request.setClosed(false);
        dao.searchTableByNameIdAndStatus(request.getNameId(),false,true);
        entity.save(request);
        return request;
    }
    public boolean closeTable(String nameId) throws Exception {
        Table table=dao.searchTableByNameIdAndStatus(nameId,false,false);
        //TBD table must not be closed if associated to an order whit pending payment.
        if(table.getAssociatedOrder().isEmpty()){
            table.setClosed(true);
            entity.save(table);
            return true;
        }else // we need to check also if the associated order have all item fulfilled!
        {
            throw new Exception("tavolo aperto! concludere e pagare ordini");
        }
    }
     protected boolean updateTable(Table request){
        entity.save(request);
        return true;
    }
}