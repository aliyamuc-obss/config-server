package tr.com.obss.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

    @Value("${role:Hello Developer}")
    private String role;

    @RequestMapping("/role")
    String getMessage() {
        return this.role;
    }
}

