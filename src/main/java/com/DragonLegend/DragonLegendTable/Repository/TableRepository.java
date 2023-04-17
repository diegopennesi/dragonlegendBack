package com.DragonLegend.DragonLegendTable.Repository;

import com.DragonLegend.DragonLegendTable.Model.Table;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface TableRepository extends MongoRepository<Table,String> {

    @Query("{nameId:'?0'}")
    Table findTableByNameId(String nameId);
    @Query("{nameId:'?0',closed:?1}")
    Table findTableByNameIdAndClosed(String nameId,boolean closed);
    @Query("{closed:?0}")
    List<Table> findTableByClosed(boolean closed, Pageable pageable);


}
