package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaifuOutController {

	@RequestMapping(value="/saifuOut", method = RequestMethod.GET)
	private ModelAndView SaifuOut(ModelAndView model) {
		model.setViewName("/SaisuOut.html");
		return model;
	}

	@RequestMapping(value = "/saifuOutForm",params = "saifuOutBack", method = RequestMethod.GET)
	private ModelAndView SaifuOutBack(ModelAndView model) {
		model.setViewName("/SaifuInp.html");
		return model;
	}

	@RequestMapping(value="/saifuOutForm",params = "topBackSaifu", method = RequestMethod.GET)
	private ModelAndView ToptBackSaifu(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
