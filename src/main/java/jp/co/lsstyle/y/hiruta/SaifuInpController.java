package jp.co.lsstyle.y.hiruta;

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

		//計算結果用変数の初期化
		int sumInt = 0;

		//SaifuOut.htmlへ値を送る（仮）
		model.addObject("Atai1", 1万);
		model.addObject("Atai2", 5千);
		model.addObject("Atai3", 1千);
		model.addObject("Atai4", 5百);
		model.addObject("Atai5", 百);
		model.addObject("Atai6", 五十);
		model.addObject("Atai7", 十);
		model.addObject("Atai8", 五);
		model.addObject("Atai9", １);
		model.setViewName("/saifuOut");
		return model;
	}
}
