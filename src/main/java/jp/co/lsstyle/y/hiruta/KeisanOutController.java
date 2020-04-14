package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KeisanOutController {

	@RequestMapping(value="/keisanOut", method = RequestMethod.GET)
	private ModelAndView KeisanOut(ModelAndView model) {
		model.setViewName("/KeisanOut.html");
		return model;
	}

	@RequestMapping(value = "/keisanOutForm",params = "keisanOutBack", method = RequestMethod.GET)
	private ModelAndView KeisanOutBack(ModelAndView model) {
		model.setViewName("/KeisanInp.html");
		return model;
	}

	@RequestMapping(value="/keisanOutForm",params = "topBackKeisan", method = RequestMethod.GET)
	private ModelAndView TopBackKeisan(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
