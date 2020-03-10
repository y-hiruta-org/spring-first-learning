package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextController {

	@RequestMapping(value="/Text", method = RequestMethod.GET)
	private String Text() {
		return "/Text.html";
	}

	@RequestMapping(value = "testform", method = RequestMethod.GET)
	public String output1(
		@RequestParam(name = "q1") String str1,
		Model model) {
			int i = Integer.parseInt(str1);
			if (i == 0) {
				str1 = "男性";
			}else {
				str1 = "女性";
			}
		model.addAttribute("moji1", str1);
		return "/Text2.html";
	}
}
