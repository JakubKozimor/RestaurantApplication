package restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import restaurant.Entity.Inventory;
import restaurant.service.InventoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

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

        // add model attribute for new quantity
        model.addAttribute("quantity", 0);

        return "inventory/inventory-list";
    }

    @GetMapping("/showFormForAddProduct")
    public String showFormForAddProduct(Model model) {

        // create empty object
        Inventory product = new Inventory();

        // add empty object to model
        model.addAttribute("product", product);

        return "inventory/inventory-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Inventory product, BindingResult bindingResult) {

        // check errors if not errors save product if not back to form for add
        if (bindingResult.hasErrors()) {
            return "inventory/inventory-form";
        } else {

            // save product
            inventoryService.saveProduct(product);

            // redirect to list of products
            return "redirect:/inventory/showFormForEditListOfProduct";
        }
    }

    @GetMapping("/showFormForEditListOfProduct")
    public String showFormForEditListOfProduct(Model model) {

        // get list of products
        List<Inventory> listOfProducts = inventoryService.getListOfProductsFromInventory();

        // add list of products to model
        model.addAttribute("listOfProducts", listOfProducts);

        return "/inventory/inventory-edit-list";
    }

    @PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam("productId") int productId, @RequestParam(value = "quantityUpdate", required = false) Integer newQuantity) {

        // set new quantity
        inventoryService.updateQuantity(productId, newQuantity);

        // redirect to list of products
        return "redirect:/inventory/inventoryList";
    }

    @PostMapping("/addQuantity")
    public String addQuantity(@RequestParam("productId") int productId, @RequestParam(value = "quantityAdd", required = false) Integer newQuantity) {

        // add to quantity
        inventoryService.addQuantity(productId, newQuantity);

        // redirect to list of products
        return "redirect:/inventory/inventoryList";
    }

    @PostMapping("/removeQuantity")
    public String removeQuantity(@RequestParam("productId") int productId, @RequestParam(value = "quantityRemove", required = false) Integer newQuantity) {

        // remove quantity
        inventoryService.removeQuantity(productId, newQuantity);

        // redirect to list of products
        return "redirect:/inventory/inventoryList";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int productId) {

        // remove product
        inventoryService.remove(productId);

        // redirect to form for edit product
        return "redirect:/inventory/showFormForEditListOfProduct";
    }

    @GetMapping("showFormForUpdateProduct")
    public String showFormForUpdateProduct(@RequestParam("productId") int productId, Model model) {

        // get product
        Optional<Inventory> theProduct = inventoryService.getSingleProduct(productId);

        // theProduct is always present
        theProduct.ifPresent(product ->{

            // set product as a model attribute
            model.addAttribute("product", product);

        });

        return "/inventory/inventory-form";
    }
}
