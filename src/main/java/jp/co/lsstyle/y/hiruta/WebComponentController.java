package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebComponentController {

	@RequestMapping(value="/WebComponent", method = RequestMethod.GET)
	private String WebComponent() {
		return "/WebComponent.html";
	}
}
