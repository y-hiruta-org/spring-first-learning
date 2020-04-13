package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BmiModelOutController {

	@RequestMapping(value="/BmiModelOut", method = RequestMethod.POST)
	private ModelAndView BmiModelOut(ModelAndView model) {
		model.setViewName("/BmiModelOut.html");
		return model;
	}

	@RequestMapping(value="bmioutform",params = "bmiback", method = RequestMethod.GET)
	private ModelAndView bmiback(ModelAndView model) {
		model.setViewName("/BmiMOdelInp.html");
		return model;
	}

	@RequestMapping(value="bmioutform",params = "topbackbmi", method = RequestMethod.GET)
	private ModelAndView topbackbmi(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}
}
