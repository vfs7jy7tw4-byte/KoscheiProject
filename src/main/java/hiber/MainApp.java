package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota",486);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setCar(car1);

      Car car2 = new Car("BMW",572);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setCar(car2);

      Car car3 = new Car("Mercedes",234);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setCar(car3);

      Car car4 = new Car("Ford",456);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      User foundUser = userService.getUserByCar("BMW", 572);

      if (foundUser != null) {
         System.out.println("Пользователь с BMW 572 найден!");
         System.out.println("Id = " + foundUser.getId());
         System.out.println("Имя = " + foundUser.getFirstName());
         System.out.println("Фамилия = " + foundUser.getLastName());
         System.out.println("Email = " + foundUser.getEmail());
      } else {
         System.out.println("Пользователь с BMW 572 не найден");
      }

      context.close();
   }
}
