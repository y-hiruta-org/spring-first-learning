package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemoInpController {

	@RequestMapping(value="/MemoInp", method = RequestMethod.GET)
	private String MemoInp() {
		return "/MemoInp.html";
	}

	@RequestMapping(value = "memoform", method = RequestMethod.GET)
	public String output1(
		@RequestParam(value = "TextMemo") String memoStr,
		Model model) {

		model.addAttribute("memo1", memoStr);
		return "/MemoOut.html";
	}
}
