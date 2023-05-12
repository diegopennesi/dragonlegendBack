package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.MenuItem;
import com.DragonLegend.DragonLegendTable.Model.Order;
import com.DragonLegend.DragonLegendTable.Repository.AdminRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AdminEngine implements AdminEngineInterface {
    @Autowired
    AdminRepository admEntity;
    @Override
    public List<MenuItem> getMenuByClass(List<String> menuclasslist) {
        if(menuclasslist.size()<=0){return admEntity.findAll();}
        List<MenuItem> menuList=Optional.ofNullable(admEntity.findAll())
                .filter(list->!list.isEmpty())
                .stream()
                .flatMap(List::stream)
                .filter(e->menuclasslist.contains(e.getMenuClass()))
                .collect(Collectors.toList());

        return menuList;
    }

    @Override
    public MenuItem addNewMenuitem(MenuItem menuItem) {
        Optional<MenuItem> existingMenuItem = Optional.ofNullable(getMenuByClass(new LinkedList<>()))
                .filter(list->!list.isEmpty())
                .flatMap(list ->list.stream().filter(e->e.getId().equals(menuItem.getId())).findFirst());
        if(existingMenuItem.isPresent()){
            MenuItem updateMenuItem=existingMenuItem.get();
            updateMenuItem.setId(menuItem.getId());
            updateMenuItem.setItemName(menuItem.getItemName());
            updateMenuItem.setAllergens(menuItem.getAllergens());
            updateMenuItem.setMenuClass(menuItem.getMenuClass());
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
    public boolean deleteItem(String id) {
        admEntity.deleteById(id);
        return admEntity.findById(id).isEmpty();
    }
}
