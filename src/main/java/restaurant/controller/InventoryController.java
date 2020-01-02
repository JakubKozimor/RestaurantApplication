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

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/inventoryList")
    public String getAllProducts(Model model) {
        List<Inventory> listOfProducts = inventoryService.getListOfProductsFromInventory();
        model.addAttribute("listOfProducts", listOfProducts);
        model.addAttribute("quantity", 0);
        return "inventory/inventory-list";
    }

    @GetMapping("/showFormForAddProduct")
    public String showFormForAddProduct(Model model) {
        Inventory product = new Inventory();
        model.addAttribute("product", product);
        return "inventory/inventory-form";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute("product") Inventory product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "inventory/inventory-form";
        } else {
            inventoryService.saveProduct(product);
            return "redirect:/inventory/showFormForEditListOfProduct";
        }
    }

    @GetMapping("/showFormForEditListOfProduct")
    public String showFormForEditListOfProduct(Model model) {
        List<Inventory> listOfProducts = inventoryService.getListOfProductsFromInventory();
        model.addAttribute("listOfProducts", listOfProducts);
        return "/inventory/inventory-edit-list";
    }

    @PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam("productId") int productId, @RequestParam(value = "quantityUpdate", required = false) Integer newQuantity) {
        inventoryService.updateQuantity(productId, newQuantity);
        return "redirect:/inventory/inventoryList";
    }

    @PostMapping("/addQuantity")
    public String addQuantity(@RequestParam("productId") int productId, @RequestParam(value = "quantityAdd", required = false) Integer newQuantity) {
        inventoryService.addQuantity(productId, newQuantity);
        return "redirect:/inventory/inventoryList";
    }

    @PostMapping("/removeQuantity")
    public String removeQuantity(@RequestParam("productId") int productId, @RequestParam(value = "quantityRemove", required = false) Integer newQuantity) {
        inventoryService.removeQuantity(productId, newQuantity);
        return "redirect:/inventory/inventoryList";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int productId) {
        inventoryService.remove(productId);
        return "redirect:/inventory/showFormForEditListOfProduct";
    }

    @GetMapping("showFormForUpdateProduct")
    public String showFormForUpdateProduct(@RequestParam("productId") int productId, Model model) {
        Optional<Inventory> theProduct = inventoryService.getSingleProduct(productId);
        theProduct.ifPresent(product -> model.addAttribute("product", product));
        return "/inventory/inventory-form";
    }
}
