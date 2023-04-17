package com.DragonLegend.DragonLegendTable.Controller;

import com.DragonLegend.DragonLegendTable.Engine.TableEngine;
import com.DragonLegend.DragonLegendTable.Model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/table")
public class TableController {

    @Autowired
    TableEngine engineT;
    //it will return a list of open table
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getTable(@RequestParam(value="limit",  defaultValue = "10") int limit,@RequestParam(value ="closed",defaultValue = "false") boolean closed){
        return ResponseEntity.ok(engineT.getTable(limit,closed));
    }
    //todoValidation
    @CrossOrigin(origins = "Http://localhost:8081")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> putTable (@RequestHeader(value = "user",defaultValue = "SysAdm") String user, @RequestBody Table x) throws Exception {
       try{
           x.setWaiter(user);
           engineT.putTable(x);
       }catch   (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
        return new ResponseEntity<Table>(x, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> closeTable (@RequestParam (value ="nameId") String nameiD) throws Exception {
        try {
            engineT.closeTable(nameiD);
        }catch (Exception e){
            return   new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}

