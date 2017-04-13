#Java Concurrent Demos

##Code Snippets

### 1st Sync Code

```java
public class SubmitOrderController {
    private OrderService orderService;
    private EmailService emailService;
    
    ...
    
    public String submitOrder(...) {
        ...
        orderService.submitOrder(order);
        emailService.sendOrderPlacedNotification(order);
        ...
        
        return "order-confirmation";
    }
    
    ...
}

public class EmailService {
    private EmailTemplateService emailTemplateService;
    private SmtpService smtpService;
    
    public void sendOrderPlacedNotification(Order order) {
        NotificationEmail email = emailTemplateService.buildEmailContent(order, EmailTemplates.SUBMIT_ORDER_NOTIFICATION_EMAIL_TEMPLATE);
        this.send(email);
    }
    
    public void send(NotificationEmail email){
        ...
        smtpService.send(email);
        ...
    }
}
```
### Using Sub Thread
```java
public class EmailService {
    
}
```