package example.spring.rest.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestSecurityController {
	@GetMapping("/greet")//no sequrity
	public String doGreet()
	{
		return "Welcome to the world of spring sequrity";
	}
	@GetMapping("/regular-work")//accessible to regular users and administrators
	public String doRegularWork()
	{
		return "Doing some regular work";
	}
	@GetMapping("/admin-work")//accessible to administrators
	public String doAdminWork()
	{
		return  "Doing some Admin regular work";
	}

}
