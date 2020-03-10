package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GakusyuInpController {

	@RequestMapping(value="/GakusyuInp", method = RequestMethod.GET)
	private String GakusyuInp() {
		return "/GakusyuInp.html";
	}

	//RequestMappingでGakusyuInp.htmlのkeisanformを受け取る
	@RequestMapping(value = "keisanform", method = RequestMethod.GET)
	public String output1(

		//parameterを受け取る
		@RequestParam(name = "komk") String komkStr,
		@RequestParam(name="atai1") int ataiOne,
		@RequestParam(name="atai2") int ataiTwo,
		Model model) {

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
		model.addAttribute("Atai1", ataiOne);
		model.addAttribute("Atai2", ataiTwo);
		model.addAttribute("kotae", sum);
		model.addAttribute("kigou", kigouStr);
		return "/GakusyuOut.html";
	}
}
