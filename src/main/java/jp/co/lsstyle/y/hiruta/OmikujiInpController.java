package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OmikujiInpController {

	@RequestMapping(value = "/omikujiInp", method = RequestMethod.GET)
	private ModelAndView OmikujiInp(ModelAndView model) {
		model.setViewName("/OmikujiInp.html");
		return model;
	}

	//RequestMappingでOmikujiInp.htmlのtestInpFormを受け取る
	@RequestMapping(value = { "/omikujiInpForm" }, method = RequestMethod.GET)
	public ModelAndView output1(

		//parameterを受け取る
		//formを受け取る
		@ModelAttribute("omikujiForm") ModelAndView model,
		//名前
		@RequestParam(name = "atai1") String ataiOne) {

			String ataiTwo = "吉";
			if (Math.random() < 0.5) {
				ataiTwo = "大吉";
			}

			//TestOut.htmlへ値を送る
			model.addObject("Atai1", ataiOne);
			model.addObject("Atai2", ataiTwo);
			model.setViewName("/omikujiOut");
			return model;
	}
}
