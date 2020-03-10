package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopMenuController {

	@RequestMapping(value="/TopMenu", method = RequestMethod.GET)
	private String TopMenu() {
		return "/TopMenu.html";
	}
}
