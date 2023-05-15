package com.DragonLegend.DragonLegendTable.Controller;

import com.DragonLegend.DragonLegendTable.Engine.AdminEngineInterface;
import com.DragonLegend.DragonLegendTable.Model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "Http://localhost:8081")
@RestController
@RequestMapping(value="/adm")
public class AdminController {
    @Autowired
    AdminEngineInterface adminEngine;
    @CrossOrigin(origins = "Http://localhost:8081")
    @GetMapping(value ="/menuItem", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMenuByClass(@RequestParam(value = "classMenu",required = false,defaultValue = "") List<String> classMenu){
       // return ResponseEntity.ok(adminEngine.getMenuByClass(classMenu));
       //List<String> request=  (classMenu == null)? new ArrayList<>():classMenu;
        return ResponseEntity.ok(adminEngine.getMenuByClass(classMenu));
    }
    @PostMapping(value ="/menuItem",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addNewitem(@RequestBody(required = true)MenuItem request){
        return ResponseEntity.ok(adminEngine.addNewMenuitem(request));
    }
    @DeleteMapping(value = "/menuItem/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteItem(@PathVariable String id){
        return ResponseEntity.ok(adminEngine.deleteItem(id));
    }
}
