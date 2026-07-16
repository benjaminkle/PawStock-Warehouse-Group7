package com.pawstock.pawstock_warehouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pawstock.pawstock_warehouse.service.ProductService;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute(
                "productCount",
                productService.countProducts());

        model.addAttribute(
                "brandCount",
                productService.countBrands());

        model.addAttribute(
                "categoryCount",
                productService.countCategories());

        model.addAttribute(
                "supplierCount",
                productService.countSuppliers());

        model.addAttribute(
                "activePage",
                "home");

        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute(
                "activePage",
                "about");

        return "about";
    }

    @GetMapping("/warehouse")
    public String warehouse(Model model) {
        model.addAttribute(
                "activePage",
                "warehouse");

        return "warehouse";
    }

    @GetMapping("/roadmap")
    public String roadmap(Model model) {
        model.addAttribute(
                "activePage",
                "roadmap");

        return "roadmap";
    }
}