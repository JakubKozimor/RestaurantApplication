package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.Entity.Inventory;
import restaurant.service.InventoryService;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/inventoryList")
    public String getAllProducts(Model model) {

        // get list of products
        List<Inventory> listOfProducts = inventoryService.getListOfProductsFromInventory();

        // add list of products to model
        model.addAttribute("listOfProducts", listOfProducts);

        return "inventory-list";
    }
}
