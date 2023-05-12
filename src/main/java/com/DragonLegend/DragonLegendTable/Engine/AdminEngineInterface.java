package com.DragonLegend.DragonLegendTable.Engine;

import com.DragonLegend.DragonLegendTable.Model.MenuItem;

import java.awt.*;
import java.util.List;

public interface AdminEngineInterface {
    public List<MenuItem>getMenuByClass(List<String> menuClass);
    public MenuItem addNewMenuitem(MenuItem menuItem);
    public boolean deleteItem(String id);
}
