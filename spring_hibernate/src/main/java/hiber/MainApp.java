package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      CarService carService = context.getBean(CarService.class);
      carService.add(new Car("nameCar", 12133));
      carService.add(new Car("BMW", 333));
      UserService userService = context.getBean(UserService.class);
      Car car = carService.getCarById((long) 30);
      User user = new User("User1", "Lastname1", "user1@mail.ru", car);
      userService.add(user);
      User user1 = userService.getUserByCar((long) 29);
      System.out.println(user1.getFirstName());

      /*
      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      List<Car> cars = carService.listCar();
      for (Car car : cars) {
         System.out.println("NameCar = "+car.getId());
         System.out.println("Series = "+car.getSeries());
         System.out.println("Number = "+car.getName());
         System.out.println();
      }
      */


      context.close();
   }
}
