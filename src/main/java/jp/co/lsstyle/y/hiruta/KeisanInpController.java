package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KeisanInpController {

	@RequestMapping(value="/keisanInp", method = RequestMethod.GET)
	private ModelAndView KeisanInp(ModelAndView model) {
		model.setViewName("/KeisanInp.html");
		return model;
	}

	//RequestMappingでGakusyuInp.htmlのkeisanInpFormを受け取る
	@RequestMapping(value = {"/keisanInpForm"}, method = RequestMethod.GET)
	public ModelAndView output1(

		//parameterを受け取る
		@ModelAttribute("keisanForm") ModelAndView model,
		@RequestParam(name = "komk") String komkStr,
		@RequestParam(name="atai1") int ataiOne,
		@RequestParam(name="atai2") int ataiTwo) {

			//計算結果用変数の初期化
			int sum = 0;

			//radiobuttonの演算子の結果用変数の初期化
			String kigouStr = null;

			//radiobuttonのvalue値によるswitch文
			//計算結果と演算子を出力
			int komkInt = Integer.parseInt(komkStr);
			switch (komkInt) {
			case 0:
				sum = ataiOne + ataiTwo;
				kigouStr = "＋";
				break;
			case 1:
				sum = ataiOne - ataiTwo;
				kigouStr = "－";
				break;
			case 2:
				sum = ataiOne * ataiTwo;
				kigouStr = "×";
				break;
			case 3:
				sum = ataiOne % ataiTwo;
				kigouStr = "÷";
				break;
			default:
				ataiOne = 0;
				ataiTwo = 0;
				sum = 0000;
				kigouStr = "エラー";
			}

		//addAttributeでGakusyuOut.htmlへ値を送る
		model.addObject("Atai1", ataiOne);
		model.addObject("Atai2", ataiTwo);
		model.addObject("kotae", sum);
		model.addObject("kigou", kigouStr);
		model.setViewName("/keisanOut");
		return model;
	}
}
