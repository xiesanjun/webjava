package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CustomerSrevice 单元测试
 */
public class CustomerServiceTest {

    private final CustomerService customerService;
    private long id;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        //初始化数据库
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        long id = 1;
        List<Customer> customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "John");
        fieldMap.put("telephone", "18890792903");
        Assert.assertTrue(customerService.createCustomer(fieldMap));
    }

    @Test
    public void updateCustomerTest() throws Exception {
        id = 1;
        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("contact", "Eric");
        Assert.assertTrue(customerService.updateCustomer(id, fieldMap));
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        id = 1;
        Assert.assertTrue(customerService.deleteCustomer(id));
    }
}
