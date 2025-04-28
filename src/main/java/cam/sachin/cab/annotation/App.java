package cam.sachin.cab.annotation;

import cam.sachin.cab.annotation.config.AppConfig;
import cam.sachin.cab.annotation.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserController userController = context.getBean(UserController.class);
        userController.userMenu();

        context.close();
    }
}
