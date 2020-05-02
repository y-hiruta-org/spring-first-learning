package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChusyaInpController {

	@RequestMapping(value = "/chusyaInp", method = RequestMethod.GET)
	private ModelAndView ChusyaInp(ModelAndView model) {
		model.setViewName("/ChusyaInp.html");
		return model;
	}

	//RequestMappingでChusyaInp.htmlのtestInpFormを受け取る
	@RequestMapping(value = { "/chusyaInpForm" }, method = RequestMethod.GET)
	public ModelAndView output1(

		//parameterを受け取る
		//formを受け取る
		@ModelAttribute("chusyaForm") ModelAndView model,
		//名前
		@RequestParam(name = "atai1") int ataiOne) {

			//1000円で，60分駐車可能
			int charge = 1000;
			ataiOne = ataiOne - 60;

			//まだ駐車するならば，600円加算して30分追加
			while (ataiOne > 0) {
			    charge = charge + 600;
			    ataiOne = ataiOne - 30;
			}

			//ChusyaOut.htmlへ値を送る
			model.addObject("Atai1", charge);
			model.setViewName("/chusyaOut");
			return model;
	}
}
