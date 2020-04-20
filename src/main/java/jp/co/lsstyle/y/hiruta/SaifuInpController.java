package jp.co.lsstyle.y.hiruta;

//import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SaifuInpController {

	@RequestMapping(value = "/saifuInp", method = RequestMethod.GET)
	private ModelAndView SaifuInp(ModelAndView model) {
		model.setViewName("/SaifuInp.html");
		return model;
	}

	//RequestMappingでTestInp.htmlのtestInpFormを受け取る
	@RequestMapping(value = { "/saifuInpForm" }, method = RequestMethod.GET)
	public ModelAndView output1(

		//parameterを受け取る
		//formを受け取る
		@ModelAttribute("saifuForm") ModelAndView model,
		//金額
		@RequestParam(name = "atai1") int ataiOne) {

//			ArrayList<Integer> okaneList = new ArrayList<>();

			int [] kinshuInt = {10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1};

			int kingakuInt = ataiOne;

			for (int i = 0 ; i < kinshuInt.length ; i++) {
				int maisuInt = kingakuInt / kinshuInt[i];
				model.addObject("Atai1", kinshuInt[i]);
				model.addObject("Atai2", maisuInt);
				kingakuInt = kingakuInt % kinshuInt[i];
			}

			model.setViewName("/saifuOut");
			return model;
	}
}
