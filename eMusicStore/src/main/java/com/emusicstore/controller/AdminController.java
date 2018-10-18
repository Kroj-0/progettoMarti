package com.emusicstore.controller;

import com.emusicstore.model.*;
import com.emusicstore.service.*;
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
import java.util.*;

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
    @Autowired
    private TrackingService trackingService;
    @Autowired
    private UsersService usersService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productInventory";
    }

    @RequestMapping("/users")
    public String customerManagement(Model model) {

        List<Customer> customerList = customerService.getCustomerList();
        model.addAttribute("customerList", customerList);
        return "customerManagement";
    }

    @RequestMapping("/users/viewCustomer/{customerId}")
    public String viewCustomer(@PathVariable("customerId") int customerId, Model model) throws IOException {
        Customer customer = customerService.getCustomerById(customerId);
        List<CustomerOrder> customerOrders = customerOrderService.getOrdersByCustomerId(customerId);

        model.addAttribute("orders", customerOrders);
        model.addAttribute("customer", customer);

        return "viewCustomer";
    }

    @RequestMapping(value = "/users/editCustomer", method = RequestMethod.POST)
    public String editCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
//        System.out.println(">>>>>>>>>>>>>>>>sono entrato nel metodo post");
//        if (result.hasErrors()) {
//            return "viewCustomer";
//        }

        Users user = usersService.getUserByUsername(customer.getUsername());
        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>user prima della modifica "+user.isEnabled());
        user.setEnabled(customer.getUsers().isEnabled());

        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>user dopo della modifica "+user.isEnabled());
        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>username user "+user.getUsername());
        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>pwd user "+user.getPassword());
        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>userid user "+user.getUserId());
        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>auth user "+user.getAuthority());
        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>customer user "+user.getCustomer());

        usersService.setEnable(user);

//        Users control = usersService.getUserByUsername(customer.getUsername());
//        System.out.println(">>>>>>>>CONTROLLER>>>>>>>>dopo la modifica verifico il database " + control.isEnabled());
        return "redirect:/admin/users/viewCustomer/" + customer.getCustomerId();
    }

    @RequestMapping("/orders")
    public String viewAllOrders(Model model) {
        List<CustomerOrder> orders = customerOrderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orderList";
    }

    @RequestMapping("/orders/viewOrder/{orderId}/{productId}")
    public String viewOrderDetail(@PathVariable("orderId") int orderId, @PathVariable("productId") int productId, RedirectAttributes redirect) {

        System.out.println(">>>>>>>>>>>>>>>>orderId " + orderId);
        CustomerOrder customerOrder = customerOrderService.getOrdersByKey(productId, orderId);
        if (!redirect.containsAttribute("refreshCO")) {
            redirect.addFlashAttribute("refreshCO", customerOrder);
        }

        return "redirect:/admin/orders/viewOrder/orderDetails";
    }

    @RequestMapping("/orders/viewOrder/orderDetails")
    public String prettyUrlViewOrderDetail(Model model, @ModelAttribute("refreshCO") CustomerOrder customerOrder, BindingResult result) {
        if(result.hasErrors()){
            model.addAttribute("error", "Unexpected error, please try to access data again");
            return "redirect:/admin/orders";
        }

        List<CustomerOrder> linkedOrders = customerOrderService.getLinkedOrders(customerOrder);
        System.out.println(">>>>>>>>>>>>>> elementi della lista " + linkedOrders.size());
        if (linkedOrders.isEmpty()) {
            linkedOrders.add(0, null);
            System.out.println(">>>>>>>>>>>>a quanto pare la lista era vuota -->> ordine univoco");
        }
        Map<String, String> status = new HashMap<String, String>();
        status.put("confirmed", "confirmed");
        status.put("prep4shipping", "prepaired");
        status.put("shipped", "shipped");
        status.put("transit", "transit");
        status.put("received", "received");
        model.addAttribute("status", status);
        model.addAttribute("order", customerOrder);
        model.addAttribute("linkedOrders", linkedOrders);
        return "viewOrder";
    }

    @RequestMapping(value="/orders/orderDetail/editStatus", method = RequestMethod.POST)
    public String editOrderStatusPost(@Valid @ModelAttribute("order") CustomerOrder customerOrder, BindingResult result) {

        if(result.hasErrors()){
            return "viewOrder";
        }

        TrackingId trId=new TrackingId(customerOrder.getTracking().getTrackingId().getTrackingId(), customerOrder.getTracking().getTrackingId().getStatus());
        Tracking tracking=new Tracking(trId, new Date());
        customerOrder.setTracking(tracking);

        List<String> status = new ArrayList<String>();
        status.add(0,"confirmed");
        status.add(1,"prep4shipping");
        status.add(2,"shipped");
        status.add(3,"transit");
        status.add(4,"received");

        String actual=customerOrder.getTracking().getTrackingId().getStatus();
        System.out.println(">>>>>>>>>>>>>>>>stato che ho cambiato: "+actual);
        if(customerOrder.getTracking().getTrackingId().getStatus()!= status.get(0))
        {
            List <Tracking> list=trackingService.getTrackingById(trId.getTrackingId());
            for(int i=0;i<list.size();i++){
                System.out.println(">>>>>>>>>>>>>>>>primo stato della lista per quel tracking: "+list.get(i).getTrackingId().getStatus());
                if(customerOrder.getTracking().getTrackingId().getStatus()!= list.get(i).getTrackingId().getStatus()){
                    for(int j=1;j<status.size();j++){
                        if(customerOrder.getTracking().getTrackingId().getStatus()!= status.get(j)){
                            TrackingId trId2=new TrackingId(list.get(i).getTrackingId().getTrackingId(), status.get(j).toString());
                            Tracking track2=new Tracking(trId2, new Date());
                            System.out.println(">>>>>>>>>>>>>>>>facendo piu di uno step inserisco questo stato: "+trId2.getStatus());
                            trackingService.addTracking(track2);
                        }
                    }
                }
            }
        }
        trackingService.addTracking(tracking);
        customerOrderService.update(customerOrder);
        String redirect = "/admin/orders/viewOrder/" + customerOrder.getCustomerOrderId().getOrderId()
                + "/" + customerOrder.getCustomerOrderId().getProductId();
        return "redirect:" + redirect;
    }

    @RequestMapping("/orders/deleteOrder/{orderId}/{productId}")
    public String deleteOrder(@PathVariable("orderId") int orderId, @PathVariable("productId") int productId){

        CustomerOrder customerOrder=customerOrderService.getOrdersByKey(productId,orderId);

        TrackingId trId=new TrackingId(customerOrder.getTracking().getTrackingId().getTrackingId(), "cancelled");
        Tracking tracking=new Tracking(trId, new Date());
        customerOrder.setTracking(tracking);
        trackingService.addTracking(tracking);
        customerOrderService.update(customerOrder);

        return "redirect:/admin/orders";
    }

}