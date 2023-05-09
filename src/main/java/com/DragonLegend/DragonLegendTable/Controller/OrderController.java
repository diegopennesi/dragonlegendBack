package com.DragonLegend.DragonLegendTable.Controller;

import com.DragonLegend.DragonLegendTable.Engine.OrderEngineInterface;
import com.DragonLegend.DragonLegendTable.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin(origins = "Http://localhost:8081")
@RequestMapping(value="/order")
public class OrderController {
    @Autowired
    OrderEngineInterface orderEngineInt;

    @GetMapping(value="{tableId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getOrder(@RequestParam(value="limit", defaultValue = "25") int limit,
                                   @PathVariable String tableId,
                                   @RequestParam (value = "paid", defaultValue="false",required = false) Boolean paid ) throws Exception {
    //this method will get the ordeListAssociated to the order list. WIll be showed only last 25 item unless requested
        // will show all the item regardless paid or unpaid, unless requested
        List<Order> x = new LinkedList<>();
        try {
           x.addAll(orderEngineInt.getOrderByTable(limit, tableId, paid));
       } catch (Exception e){
           return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
        return ResponseEntity.ok(x);
    }

    @PutMapping(value="{tableId}/list",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editOrder(@PathVariable String tableId,@RequestBody List<Order> request) throws Exception {
        orderEngineInt.putOrder(request,tableId);
        return ResponseEntity.ok("");
    }
    @PutMapping(value="{tableId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editOrder(@PathVariable String tableId,@RequestBody Order request) throws Exception {
        orderEngineInt.putSingleOrder(request,tableId);
        return ResponseEntity.ok("");
    }
}
