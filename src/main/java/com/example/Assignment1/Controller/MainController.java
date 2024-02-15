package com.example.Assignment1.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.Assignment1.Model.Order;
import com.example.Assignment1.OrderService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @Autowired
    OrderService service  ;

    @GetMapping("/OnlinePizza")
    public String  action1( Order order) {
        return "index";
    }

    @GetMapping("/addOrder")
    public String action2(  Model model,  @ModelAttribute Order order ) {
        service.save(order);
        double stotal = order.CalculateSizeTotal();
        double ttotal = order.CalculateToppingsTotal();
        double dtotal = order.CalculateDeliveryTotal();
        double total = order.CalculateTotal();
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime newTime = currentTime.plusHours(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCurrentTime = currentTime.format(formatter);
        String formattedNewTime = newTime.format(formatter);
        model.addAttribute("newTime", formattedNewTime);
        model.addAttribute("total", total);
        model.addAttribute("stotal", stotal);
        model.addAttribute("ttotal", ttotal);
        model.addAttribute("dtotal", dtotal);
        return "receipt";
    }

}
