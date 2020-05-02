package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChusyaOutController {

	@RequestMapping(value="/chusyaOut", method = RequestMethod.GET)
	private ModelAndView ChusyaOut(ModelAndView model) {
		model.setViewName("/ChusyaOut.html");
		return model;
	}

	@RequestMapping(value = "/chusyaOutForm",params = "chusyaOutBack", method = RequestMethod.GET)
	private ModelAndView ChusyaOutBack(ModelAndView model) {
		model.setViewName("/ChusyaInp.html");
		return model;
	}

	@RequestMapping(value="/chusyaOutForm",params = "topBackChusya", method = RequestMethod.GET)
	private ModelAndView ToptBackChusya(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
