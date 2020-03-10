package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GakusyuOutController {

	@RequestMapping(value="/GakusyuOut", method = RequestMethod.GET)
	private String GakusyuOut() {
		return "/GakusyuOut.html";
	}

	@RequestMapping(value = "outform", method = RequestMethod.GET)
	private String backpage() {
		return "/GakusyuInp.html";
	}

	@RequestMapping(value = "topmenu", method = RequestMethod.GET)
	private String topmenu() {
		return "/TopMenu.html";
	}
}
