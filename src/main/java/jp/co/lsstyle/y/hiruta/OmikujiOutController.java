package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OmikujiOutController {

	@RequestMapping(value="/omikujiOut", method = RequestMethod.GET)
	private ModelAndView OmikujiOut(ModelAndView model) {
		model.setViewName("/OmikujiOut.html");
		return model;
	}

	@RequestMapping(value = "/omikujiOutForm",params = "omikujiOutBack", method = RequestMethod.GET)
	private ModelAndView OmikujiOutBack(ModelAndView model) {
		model.setViewName("/OmikujiInp.html");
		return model;
	}

	@RequestMapping(value="/omikujiOutForm",params = "topBackOmikuji", method = RequestMethod.GET)
	private ModelAndView ToptBackOmikuji(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
