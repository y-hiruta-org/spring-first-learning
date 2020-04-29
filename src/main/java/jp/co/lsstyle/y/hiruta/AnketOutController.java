package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnketOutController {

	@RequestMapping(value="/anketOut", method = RequestMethod.GET)
	private ModelAndView AnketOut(ModelAndView model) {
		model.setViewName("/AnketOut.html");
		return model;
	}

	@RequestMapping(value = "/anketOutForm",params = "anketOutBack", method = RequestMethod.GET)
	private ModelAndView AnketOutBack(ModelAndView model) {
		model.setViewName("/AnketInp.html");
		return model;
	}

	@RequestMapping(value="/anketOutForm",params = "topBackAnket", method = RequestMethod.GET)
	private ModelAndView ToptBackAnket(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
