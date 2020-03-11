package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiInpController {

	@RequestMapping(value="/BmiInp", method = RequestMethod.GET)
	private String BmiInp() {
		return "/BmiInp.html";
	}

	@RequestMapping(value = "bmiform", method = RequestMethod.GET)
	public String output1(

		//parameterを受け取る
		@RequestParam(name = "sex") int sexInt,
		@RequestParam(name="height") double heightdouble,
		@RequestParam(name="weight") double weightdouble,
		Model model) {

			//BMIの計算
			//2乗は定数を切る
			final int jyoInt = 2;

			//累乗の計算
			double nijyoDouble = Math.pow(heightdouble, jyoInt);

			//体重÷身長
			double sumDouble = weightdouble / nijyoDouble;


			//適正体重と差分の計算
			//22の定数を切る
			final int twoInt = 22;

			//適正体重の計算
			double tekiseDouble = twoInt * (Math.pow(heightdouble,jyoInt));

			//フォーマット関数を使って少数点第3位以下を四捨五入
			String tekiseiStr = String.format("%.2f", tekiseDouble);

			//適正体重との差分を計算
			double sabunDouble = weightdouble - tekiseDouble;

			//フォーマット関数を使って少数点第3位以下を四捨五入
			String sabunStr = String.format("%.2f", sabunDouble);

			//BMI結果用変数の初期化
			String taikeStr = null;

			//radiobuttonの性別の結果用変数の初期化
			String sexStr = null;

			//kotaedoubleの結果によるif文
			if(sexInt == 0) {

				sexStr = "男性";

				if(sumDouble <= 18.9) {
					taikeStr = "痩せ気味";
					model.addAttribute("hikaku1", sabunStr);
					model.addAttribute("tekisei1", tekiseiStr);
				}else if(sumDouble >= 19.0 && sumDouble <= 24.9){
					taikeStr = "普通";
					model.addAttribute("hikaku2", sabunStr);
					model.addAttribute("tekisei2", tekiseiStr);
				}else if(sumDouble >= 25.0 && sumDouble <= 29.9) {
					taikeStr = "肥満傾向";
					model.addAttribute("hikaku3", sabunStr);
					model.addAttribute("tekisei3", tekiseiStr);
				}else if(sumDouble >= 30.0 && sumDouble <= 39.9) {
					taikeStr = "肥満";
					model.addAttribute("hikaku4", sabunStr);
					model.addAttribute("tekisei4", tekiseiStr);
				}else {
					taikeStr = "重度な肥満";
					model.addAttribute("hikaku5", sabunStr);
					model.addAttribute("tekisei5", tekiseiStr);
				}
			}else {

				sexStr = "女性";

				if(sumDouble <= 17.9) {
					taikeStr = "痩せ気味";
					model.addAttribute("hikaku6", sabunStr);
					model.addAttribute("tekisei6", tekiseiStr);
				}else if(sumDouble >= 18.0 && sumDouble <= 23.9){
					taikeStr = "普通";
					model.addAttribute("hikaku7", sabunStr);
					model.addAttribute("tekisei7", tekiseiStr);
				}else if(sumDouble >= 24.0 && sumDouble <= 29.9) {
					taikeStr = "肥満傾向";
					model.addAttribute("hikaku8", sabunStr);
					model.addAttribute("tekisei8", tekiseiStr);
				}else if(sumDouble >= 30.0 && sumDouble <= 39.9) {
					taikeStr = "肥満";
					model.addAttribute("hikaku9", sabunStr);
					model.addAttribute("tekisei9", tekiseiStr);
				}else {
					taikeStr = "重度な肥満";
					model.addAttribute("hikaku0", sabunStr);
					model.addAttribute("tekisei0", tekiseDouble);
				}
			}

			//フォーマット関数を使って少数点第3位以下を四捨五入
			String bmiStr = String.format("%.2f", sumDouble);

			heightdouble = heightdouble * 100;

		//addAttributeでBmiOut.htmlへ値を送る
		model.addAttribute("sincho", heightdouble);
		model.addAttribute("taijyu", weightdouble);
		model.addAttribute("bmisuti", bmiStr);
		model.addAttribute("taikei", taikeStr);
		model.addAttribute("seibetu", sexStr);
		return "/BmiOut.html";
	}
}
