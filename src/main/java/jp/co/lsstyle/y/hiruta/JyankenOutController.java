package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JyankenOutController {

	@RequestMapping(value="/jyankenOut", method = RequestMethod.GET)
	private ModelAndView JyankenOut(ModelAndView model) {
		model.setViewName("/JyankenOut.html");
		return model;
	}

	@RequestMapping(value = "/jyankenOutForm",params = "jyankenOutBack", method = RequestMethod.GET)
	private ModelAndView JyankenOutBack(ModelAndView model) {
		model.setViewName("/JyankenInp.html");
		return model;
	}

	@RequestMapping(value="/jyankenOutForm",params = "topBackJyanken", method = RequestMethod.GET)
	private ModelAndView ToptBackJyanken(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
