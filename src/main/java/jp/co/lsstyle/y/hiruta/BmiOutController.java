package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BmiOutController {

	@RequestMapping(value="/BmiOut", method = RequestMethod.GET)
	private String BmiOut() {
		return "/BmiOut.html";
	}

	@RequestMapping(value = "bmioutform", method = RequestMethod.GET)
	private String bmioutform() {
		return "/BmiInp.html";
	}

	@RequestMapping(value = "topmenuBmi", method = RequestMethod.GET)
	private String topmenuBmi() {
		return "/TopMenu.html";
	}
}
