package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestOutController {

	@RequestMapping(value="/testOut", method = RequestMethod.GET)
	private ModelAndView TsetOut(ModelAndView model) {
		model.setViewName("/TestOut.html");
		return model;
	}

	@RequestMapping(value = "/testOutForm",params = "testOutBack", method = RequestMethod.GET)
	private ModelAndView TestOutBack(ModelAndView model) {
		model.setViewName("/TestInp.html");
		return model;
	}

	@RequestMapping(value="/testOutForm",params = "topBackTest", method = RequestMethod.GET)
	private ModelAndView ToptBackTest(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
