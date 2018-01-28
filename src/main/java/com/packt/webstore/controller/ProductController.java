package com.packt.webstore.controller;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.NoProductsFondUnderCategoryException;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("market")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(@PathVariable String category, Model model) {
        List<Product> products = productService.getProductByCategory(category);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFondUnderCategoryException();
        }
        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/update/stock")
    public String updateStock(Model model) {
        productService.updateAllStock();
        return "redirect:/market/products";
    }

    @RequestMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params") Map<String, List<String>> filterParams,
                                      Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("newProduct", product);
        return "addProduct";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product product) {
        this.productService.addProduct(product);
        return "redirect:/market/products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }

}
