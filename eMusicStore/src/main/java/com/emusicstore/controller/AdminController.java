package com.emusicstore.controller;

import com.emusicstore.model.Customer;
import com.emusicstore.model.CustomerOrder;
import com.emusicstore.model.Product;
import com.emusicstore.service.CustomerOrderService;
import com.emusicstore.service.CustomerService;
import com.emusicstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("refreshCO")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerOrderService customerOrderService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping
    public  String adminPage(){
        return "admin";
    }
    @RequestMapping("/productInventory")
    public String productInventory(Model model){

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @RequestMapping("/users")
    public  String customerManagement(Model model){

        List<Customer> customerList=customerService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "customerManagement";
    }

    @RequestMapping("/users/viewCustomer/{customerId}")
    public String viewCustomer(@PathVariable("customerId") int customerId, Model model) throws IOException {
        Customer customer=customerService.getCustomerById(customerId);
        List<CustomerOrder> customerOrders=customerOrderService.getOrdersByCustomerId(customerId);

        model.addAttribute("orders", customerOrders);
        model.addAttribute("customer", customer);

        return "viewCustomer";
    }

    @RequestMapping(value="/users/editCustomer", method = RequestMethod.POST)
    public String editCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
        System.out.println(">>>>>>>>>>>>>>>>sono entrato nel metodo post");
        if(result.hasErrors()){
            return "viewCustomer";
        }

        System.out.println(">>>>>>>>>>>>>>>>prima della modifica");
        customerService.editEnable(customer);
        System.out.println(">>>>>>>>>>>>>>>>dopo la modifica"+customer.isEnabled());

        return "redirect:/admin/users/viewCustomer/" + customer.getCustomerId();
    }

    @RequestMapping("/orders")
    public String viewAllOrders(Model model){
        List<CustomerOrder> orders=customerOrderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orderList";
    }

    @RequestMapping("/orders/viewOrder/{orderId}/{productId}")
    public String viewOrderDetail(@PathVariable("orderId") int orderId, @PathVariable("productId") int productId, RedirectAttributes redirect){

        System.out.println(">>>>>>>>>>>>>>>>orderId "+ orderId);
        CustomerOrder customerOrder=customerOrderService.getOrdersByKey(productId,orderId);
        if(!redirect.containsAttribute("refreshCO")){
            redirect.addFlashAttribute("refreshCO", customerOrder);
        }

        return "redirect:/admin/orders/viewOrder/orderDetails";
    }

    @RequestMapping("/orders/viewOrder/orderDetails")
    public  String prettyUrlViewOrderDetail(Model model, @ModelAttribute("refreshCO") CustomerOrder customerOrder, BindingResult result)
    {
//        if(result.hasErrors()){
//            model.addAttribute("error", "Unexpected error, please try to access data again");
//            return "redirect:/admin/orders";
//        }

        List<CustomerOrder> linkedOrders=customerOrderService.getLinkedOrders(customerOrder);
        System.out.println(">>>>>>>>>>>>>> elementi della lista "+linkedOrders.size());
        if(linkedOrders.isEmpty()){
            linkedOrders.add(0, null);
            System.out.println(">>>>>>>>>>>>a quanto pare la lista era vuota -->> ordine univoco");
        }
        Map<String,String> status = new HashMap<String, String>();
        status.put("confirmed", "confirmed");
        status.put("preparato", "preparato");
        status.put("shipped", "shipped");
        status.put("received", "received");
        model.addAttribute("status", status);
        model.addAttribute("order", customerOrder);
        model.addAttribute("linkedOrders", linkedOrders);
        return "viewOrder";
    }

    @RequestMapping(value="/orders/orderDetail/editStatus", method = RequestMethod.POST)
    public String editOrderStatusPost(@Valid @ModelAttribute("order") CustomerOrder customerOrder, BindingResult result) {
        System.out.println(">>>>>> sono in /orders/orderDetail/editStatus");
        if(result.hasErrors()){
            return "viewOrder";
        }
        System.out.println(">>>>>> ho passato il controllo di form");
        customerOrderService.changeStatus(customerOrder);
        String redirect = "/admin/orders/viewOrder/" + customerOrder.getCustomerOrderId().getOrderId()
                + "/" + customerOrder.getCustomerOrderId().getProductId();
        return "redirect:" + redirect;
    }

    @RequestMapping("/orders/deleteOrder/{orderId}/{productId}")
    public String deleteOrder(@PathVariable("orderId") int orderId, @PathVariable("productId") int productId){

        CustomerOrder customerOrder=customerOrderService.getOrdersByKey(productId,orderId);
        customerOrder.setStatus("cancelled");
        customerOrderService.changeStatus(customerOrder);

        return "redirect:/admin/orders";
    }

}