package services.orderServices;

import org.example.service.orderServices.OrderServicesImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServicesImpTest {
    OrderServicesImpl orderServices = new OrderServicesImpl();

    @Test
    public void addOrderFromMenuTest() {
        orderServices.addOrderFromMenu(2,"client");
    }



}
