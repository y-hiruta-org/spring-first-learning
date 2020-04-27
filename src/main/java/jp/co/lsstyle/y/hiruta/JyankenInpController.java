package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JyankenInpController {

	@RequestMapping(value = "/jyankenInp", method = RequestMethod.GET)
	private ModelAndView JyankenInp(ModelAndView model) {
		model.setViewName("/JyankenInp.html");
		return model;
	}

	//RequestMappingでJyankenInp.htmlのjyankenInpFormを受け取る
	@RequestMapping(value = { "/jyankenInpForm" }, method = RequestMethod.POST)
	public ModelAndView output1(

		//formを受け取る
		@ModelAttribute("jyankenForm") ModelAndView model,
		//ラジオボタンの取得
		@RequestParam(name="janken") String atai1) {

			StringBuilder resultBuilder = new StringBuilder();
	        resultBuilder.append("あなたは");
	        if (atai1.equals("0")) {
	            resultBuilder.append("グー");
	        } else if (atai1.equals("1")) {
	            resultBuilder.append("チョキ");
	        } else {
	            resultBuilder.append("パー");
	        }
	        resultBuilder.append("を出して");
	        double random = Math.random();
	        if (random < 0.333) {
	            resultBuilder.append("勝ちました。");
	        } else if (random < 0.666) {
	            resultBuilder.append("負けました。");
	        } else {
	            resultBuilder.append("引き分けました。");
	        }

			//JyankenOut.htmlへ値を送る
			model.addObject("Atai1", resultBuilder.toString());
			model.setViewName("/jyankenOut");
			return model;
	}
}
