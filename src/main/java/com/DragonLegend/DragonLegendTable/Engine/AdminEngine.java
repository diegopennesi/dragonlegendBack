package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.MenuItem;
import com.DragonLegend.DragonLegendTable.Model.Order;
import com.DragonLegend.DragonLegendTable.Repository.AdminRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AdminEngine implements AdminEngineInterface {
    @Autowired
    AdminRepository admEntity;
    @Override
    public List<MenuItem> getMenuByFilter(List<String> filterList) {
        if(filterList.size()<=0){return admEntity.findAll();}
        List<MenuItem> menuList=Optional.of(admEntity.findAll())
                .filter(list->!list.isEmpty())
                .stream()
                .flatMap(List::stream)
                .filter(e -> filterList.stream().anyMatch(
                        filter -> e.getMenuClass().toLowerCase().contains(filter.toLowerCase())
                                || e.getItemName().toLowerCase().contains(filter.toLowerCase())
                                || String.valueOf(e.getPrice()).equals(filter))
                        )
                .collect(Collectors.toList());
        return menuList;
    }

    @Override
    public MenuItem addNewMenuitem(MenuItem menuItem) {
        Optional<MenuItem> existingMenuItem = Optional.ofNullable(getMenuByFilter(new LinkedList<>()))
                .filter(list->!list.isEmpty())
                .flatMap(list ->list.stream().filter(e->e.getId().equals(menuItem.getId())).findFirst());
        if(existingMenuItem.isPresent()){
            MenuItem updateMenuItem=existingMenuItem.get();
            updateMenuItem.setId(menuItem.getId());
            updateMenuItem.setItemName(menuItem.getItemName());
            updateMenuItem.setAllergens(menuItem.getAllergens());
            updateMenuItem.setMenuClass(menuItem.getMenuClass().replaceAll(" ","_"));
            updateMenuItem.setDescription(menuItem.getDescription());
            updateMenuItem.setPrice(menuItem.getPrice());
            admEntity.save(updateMenuItem);
            return updateMenuItem;
        }else{
            menuItem.setId(new ObjectId());
            admEntity.save(menuItem);
            return menuItem;
        }
    }

    @Override
    public MenuItem disableMenuItem(String id) {
        Optional<MenuItem> request=admEntity.findById(id);
      if(!request.isEmpty()){

      }else return  new MenuItem();
      return request.get();
    }

    @Override
    public boolean deleteItem(String id) {
        admEntity.deleteById(id);
        return admEntity.findById(id).isEmpty();
    }
}
