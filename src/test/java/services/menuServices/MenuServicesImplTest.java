package services.menuServices;

import org.example.service.menuServices.MenuServicesImpl;
import org.junit.Test;

public class MenuServicesImplTest {
    MenuServicesImpl menuServices= new MenuServicesImpl();
    @Test
    public void getAllProductTest(){
        System.out.println(menuServices.getAllProductsFromMenu().toString());
    }
}
