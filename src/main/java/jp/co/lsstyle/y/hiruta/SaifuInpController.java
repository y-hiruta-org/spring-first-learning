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

	//RequestMappingで受け取る
	@RequestMapping(value = { "/saifuInpForm" }, method = RequestMethod.GET)
	public ModelAndView output1(

		//parameterを受け取る
		//formを受け取る
		@ModelAttribute("saifuForm") ModelAndView model,
		//金額
		@RequestParam(name = "atai1") String ataiOne) {

			String kingakuStr = ataiOne;
			int kazuInt;

			kazuInt = Integer.parseInt(kingakuStr) / 10000;
			if (kazuInt == 0) {
				model.addObject("Atai1",0);
			}else {
				model.addObject("Atai1", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(1)) / 5000;
			if (kazuInt == 0) {
				model.addObject("Atai2",0);
			}else {
				model.addObject("Atai2", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(1)) / 1000;
			if (kazuInt == 0) {
				model.addObject("Atai3",0);
			}else {
				model.addObject("Atai3", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(2)) / 500;
			if (kazuInt == 0) {
				model.addObject("Atai4",0);
			}else {
				model.addObject("Atai4", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(2)) / 100;
			if (kazuInt == 0) {
				model.addObject("Atai5",0);
			}else {
				model.addObject("Atai5", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(3)) / 50;
			if (kazuInt == 0) {
				model.addObject("Atai6",0);
			}else {
				model.addObject("Atai6", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(3)) / 10;
			if (kazuInt == 0) {
				model.addObject("Atai7",0);
			}else {
				model.addObject("Atai7", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(4)) / 5;
			if (kazuInt == 0) {
				model.addObject("Atai8",0);
			}else {
				model.addObject("Atai8", kazuInt);
			}
			kazuInt = Integer.parseInt(kingakuStr.substring(4)) / 1;
			if (kazuInt == 0) {
				model.addObject("Atai9",0);
			}else {
				model.addObject("Atai9", kazuInt);
			}

			model.setViewName("/saifuOut");
			return model;
	}
}
