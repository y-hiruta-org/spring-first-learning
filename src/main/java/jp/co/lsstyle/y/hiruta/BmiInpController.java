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

			//2乗は定数を切る
			final int jyoInt = 2;

			//累乗の計算
			double nijyodouble = Math.pow(heightdouble, jyoInt);

			//体重÷身長
			double sumdouble = weightdouble / nijyodouble;

			//BMI結果用変数の初期化
			String taikeStr = null;

			//radiobuttonの性別の結果用変数の初期化
			String sexStr = null;

			//kotaedoubleの結果によるif文
			if(sexInt == 0) {

				sexStr = "男性";

				if(sumdouble <= 18.9) {
					taikeStr = "痩せ気味";
				}else if(sumdouble >= 19.0 && sumdouble <= 24.9){
					taikeStr = "普通";
				}else if(sumdouble >= 25.0 && sumdouble <= 29.9) {
					taikeStr = "肥満傾向";
				}else if(sumdouble >= 30.0 && sumdouble <= 39.9) {
					taikeStr = "肥満";
				}else {
					taikeStr = "重度な肥満";
				}
			}else {

				sexStr = "女性";

				if(sumdouble <= 17.9) {
					taikeStr = "痩せ気味";
				}else if(sumdouble >= 18.0 && sumdouble <= 23.9){
					taikeStr = "普通";
				}else if(sumdouble >= 24.0 && sumdouble <= 29.9) {
					taikeStr = "肥満傾向";
				}else if(sumdouble >= 30.0 && sumdouble <= 39.9) {
					taikeStr = "肥満";
				}else {
					taikeStr = "重度な肥満";
				}
			}

			//フォーマット関数を使って少数点第3位以下を四捨五入
			String bmiStr = String.format("%.2f", sumdouble);

		//addAttributeでBmiOut.htmlへ値を送る
		model.addAttribute("bmisuti", bmiStr);
		model.addAttribute("taikei", taikeStr);
		model.addAttribute("seibetu", sexStr);
		return "/BmiOut.html";
	}
}
