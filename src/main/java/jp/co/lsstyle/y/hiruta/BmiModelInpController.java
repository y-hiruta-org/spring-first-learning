package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BmiModelInpController {

	@RequestMapping(value="/bmiModelInp", method = RequestMethod.GET)
	private ModelAndView BmiModelInp(ModelAndView model) {
		model.setViewName("/BmiModelInp.html");
		return model;
	}

	@RequestMapping(value = {"/bmimodelform"}, method = RequestMethod.POST)
	public ModelAndView output1(

		//parameterを受け取る
		@ModelAttribute("bmiModelInpForm") ModelAndView model,
		@RequestParam(name = "sex") int sexInt,
		@RequestParam(name="height") double heightdouble,
		@RequestParam(name="weight") double weightdouble) {

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
					model.addObject("hikaku1", sabunStr);
					model.addObject("tekisei1", tekiseiStr);
				}else if(sumDouble >= 19.0 && sumDouble <= 24.9){
					taikeStr = "普通";
					model.addObject("hikaku2", sabunStr);
					model.addObject("tekisei2", tekiseiStr);
				}else if(sumDouble >= 25.0 && sumDouble <= 29.9) {
					taikeStr = "肥満傾向";
					model.addObject("hikaku3", sabunStr);
					model.addObject("tekisei3", tekiseiStr);
				}else if(sumDouble >= 30.0 && sumDouble <= 39.9) {
					taikeStr = "肥満";
					model.addObject("hikaku4", sabunStr);
					model.addObject("tekisei4", tekiseiStr);
				}else {
					taikeStr = "重度な肥満";
					model.addObject("hikaku5", sabunStr);
					model.addObject("tekisei5", tekiseiStr);
				}
			}else {

				sexStr = "女性";

				if(sumDouble <= 17.9) {
					taikeStr = "痩せ気味";
					model.addObject("hikaku6", sabunStr);
					model.addObject("tekisei6", tekiseiStr);
				}else if(sumDouble >= 18.0 && sumDouble <= 23.9){
					taikeStr = "普通";
					model.addObject("hikaku7", sabunStr);
					model.addObject("tekisei7", tekiseiStr);
				}else if(sumDouble >= 24.0 && sumDouble <= 29.9) {
					taikeStr = "肥満傾向";
					model.addObject("hikaku8", sabunStr);
					model.addObject("tekisei8", tekiseiStr);
				}else if(sumDouble >= 30.0 && sumDouble <= 39.9) {
					taikeStr = "肥満";
					model.addObject("hikaku9", sabunStr);
					model.addObject("tekisei9", tekiseiStr);
				}else {
					taikeStr = "重度な肥満";
					model.addObject("hikaku0", sabunStr);
					model.addObject("tekisei0", tekiseDouble);
				}
			}

			//フォーマット関数を使って少数点第3位以下を四捨五入
			String bmiStr = String.format("%.2f", sumDouble);

			heightdouble = heightdouble * 100;

		//ModelAndViewでBmiOut.htmlへ値を送る
		model.addObject("sincho", heightdouble);
		model.addObject("taijyu", weightdouble);
		model.addObject("bmisuti", bmiStr);
		model.addObject("taikei", taikeStr);
		model.addObject("seibetu", sexStr);
		model.setViewName("/BmiModelOut");
		return model;
	}
}
