package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.Table;
import com.DragonLegend.DragonLegendTable.Repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Component
public class Dao {
    @Autowired
    TableRepository repo;

    public List<Table> searchTable(int limit,boolean closed){
        List<Table> tableList= new LinkedList<>();
        Pageable page = PageRequest.of(0,limit);
        tableList=(repo.findTableByClosed(closed,page ));
        return  tableList;
    }
    public List<Table> searchTableByNameId(String nameId, boolean nullable) throws Exception {
        List<Table> listTable= new LinkedList<>();
        Table response= repo.findTableByNameIdAndClosed(nameId,false);
        if(ObjectUtils.isEmpty(response) && nullable){
            listTable.add(response);
            return listTable;
        }else if(!ObjectUtils.isEmpty(response) &&!nullable){
            listTable.add(response);
            return  listTable;
        } else {
            throw new Exception("Exception");//TBD
        }
    }
    public Table searchTableByNameIdAndStatus(String nameId,boolean isClosed, boolean nullable) throws Exception {
        Table response= response=repo.findTableByNameIdAndClosed(nameId,isClosed);
        if(ObjectUtils.isEmpty(response) && nullable){
            return response;
        }else if(!ObjectUtils.isEmpty(response) &&!nullable){
            return  response;
        } else {
            throw new Exception("Risorsa non disponibile o non trovata");//TBD
        }
    }
}