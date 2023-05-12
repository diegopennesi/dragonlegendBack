package com.DragonLegend.DragonLegendTable.Controller;

import com.DragonLegend.DragonLegendTable.Engine.AdminEngineInterface;
import com.DragonLegend.DragonLegendTable.Model.MenuItem;
import com.DragonLegend.DragonLegendTable.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "Http://localhost:8081")
@RequestMapping(value="/adm")
public class AdminController {
    @Autowired
    AdminEngineInterface adminEngine;
    @GetMapping(value ="/menuItem", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getMenuByClass(@RequestBody(required = true) List<String> classMenu){
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
