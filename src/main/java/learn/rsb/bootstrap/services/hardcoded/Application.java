package learn.rsb.bootstrap.services.hardcoded;

import learn.rsb.bootstrap.Demo;

public class Application {

    public static void main(String[] args) {
        DevelopmentOnlyCustomerService service = new DevelopmentOnlyCustomerService();
        Demo.workWithCustomerService(Application.class, service);
    }
}
