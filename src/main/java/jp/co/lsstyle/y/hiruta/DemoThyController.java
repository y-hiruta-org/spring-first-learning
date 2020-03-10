package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoThyController {

	@RequestMapping(value = "/demo/thy" , method = RequestMethod.GET)
	private String demoThy(Model mdl) {
		mdl.addAttribute("msg","Thymeleafを使って値をセット");
		return "demo_thy.html";
	}
}
