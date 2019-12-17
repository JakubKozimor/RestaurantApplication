package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import restaurant.Entity.Inventory;
import restaurant.service.InventoryService;

import javax.validation.Valid;
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

        return "inventory/inventory-list";
    }

    @GetMapping("/showFormForAddProduct")
    public String showFormForAddProduct(Model model) {

        // create empty model
        Inventory product = new Inventory();

        // add empty object to model
        model.addAttribute("product", product);

        return "inventory/inventory-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct( @ModelAttribute("product") Inventory product) {

        // save product
        inventoryService.saveProduct(product);

        // redirect to list of products
        return "redirect:/inventory/inventoryList";
    }
}
