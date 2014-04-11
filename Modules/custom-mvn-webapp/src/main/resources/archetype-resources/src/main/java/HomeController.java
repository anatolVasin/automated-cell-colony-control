package ${package};

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	private Log log = LogFactory.getLog(HomeController.class);
	
	@RequestMapping("/")
	public String root() {
		return "redirect:/home";
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(@RequestParam("a") Integer a, @RequestParam("b") Integer b, Model model) {
		log.info("HomeController is coming");
		
		if (a == null) a = 0;
		if (b == null) b = 0;
		
		int c = a + b;
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		model.addAttribute("result", c);
		
		return "home";
	}
}
