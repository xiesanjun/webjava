package org.smart4j.chapter3.controller;

import com.smart4j.framework.annotation.Action;
import com.smart4j.framework.annotation.Controller;
import com.smart4j.framework.annotation.Inject;
import com.smart4j.framework.bean.Param;
import com.smart4j.framework.bean.View;
import org.smart4j.chapter3.model.Customer;
import org.smart4j.chapter3.service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

    /**
     * 进入 客户列表 界面
     */
    @Action("get:/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }
}
