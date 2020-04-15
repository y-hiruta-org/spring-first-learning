package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestInpController {

	@RequestMapping(value = "/testInp", method = RequestMethod.GET)
	private ModelAndView TestInp(ModelAndView model) {
		model.setViewName("/TestInp.html");
		return model;
	}

	//RequestMappingでTestInp.htmlのtestInpFormを受け取る
	@RequestMapping(value = { "/testInpForm" }, method = RequestMethod.GET)
	public ModelAndView output1(

			//parameterを受け取る
			//formを受け取る
			@ModelAttribute("testForm") ModelAndView model,
			//ラジオボタン
			@RequestParam(name = "komk") String komkStr,
			//国語
			@RequestParam(name = "atai1") int ataiOne,
			//社会
			@RequestParam(name = "atai2") int ataiTwo,
			//理科
			@RequestParam(name = "atai3") int ataiThree,
			//数学
			@RequestParam(name = "atai4") int ataiFour,
			//英語
			@RequestParam(name = "atai5") int ataiFive) {

		//計算結果用変数の初期化
		int sumInt = 0;
		int heikinInt = 0;
		//定数を切る
		final int kyoukaInt = 5;

		//radiobuttonの演算子の結果用変数の初期化
		String kigouStr = null;

		//radiobuttonのvalue値によるif文
		//radiobuttonのvalue値を数値化
		int komkInt = Integer.parseInt(komkStr);

		if (komkInt == 0) {
			//合計点の場合
			sumInt = ataiOne + ataiTwo + ataiThree + ataiFour + ataiFive;
			model.addObject("kotae", sumInt);
			kigouStr = "合計点は、、";
		} else {
			//それ以外の時（平均点の時）
			sumInt = ataiOne + ataiTwo + ataiThree + ataiFour + ataiFive;
			heikinInt = sumInt / kyoukaInt;
			model.addObject("kotae", heikinInt);
			kigouStr = "平均点は、、";
		}

		//TestOut.htmlへ値を送る
		model.addObject("Atai1", ataiOne);
		model.addObject("Atai2", ataiTwo);
		model.addObject("Atai3", ataiThree);
		model.addObject("Atai4", ataiFour);
		model.addObject("Atai5", ataiFive);
		model.addObject("kigou", kigouStr);
		model.setViewName("/testOut");
		return model;
	}
}
