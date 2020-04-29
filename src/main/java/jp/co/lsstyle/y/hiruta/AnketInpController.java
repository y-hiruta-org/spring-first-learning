package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnketInpController {

	@RequestMapping(value = "/anketInp", method = RequestMethod.GET)
	private ModelAndView AnketInp(ModelAndView model) {
		model.setViewName("/AnketInp.html");
		return model;
	}

	//RequestMappingでAnketInp.htmlのjyankenInpFormを受け取る
	@RequestMapping(value = { "/anketInpForm" }, method = RequestMethod.POST)
	public ModelAndView output1(

		//formを受け取る
		@ModelAttribute("anketForm") ModelAndView model,
		//チェックボックスの取得
		@RequestParam(value = "java", required = false) boolean java,
        @RequestParam(value = "cgengo", required = false) boolean c,
        @RequestParam(value = "php", required = false) boolean php) {

			StringBuilder resultBuilder = new StringBuilder();
			if (java) {
	            resultBuilder.append("Javaがチェックされました。");
	        }
	        if (c) {
	            resultBuilder.append("Cがチェックされました。");
	        }
	        if (php) {
	            resultBuilder.append("PHPがチェックされました。");
	        }

			//AnketOut.htmlへ値を送る
			model.addObject("Atai1", resultBuilder.toString());
			model.setViewName("/AnketOut");
			return model;
	}
}
