package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemoInpController {
	@RequestMapping(value="/MemoInp", method = RequestMethod.GET)
	private String memoinp(Model model) {
		model.addAttribute("memoinpform", new MemoInpForm());
		return "memoinp";
	}

	@RequestMapping(value = {"/memoform"}, method = {RequestMethod.POST})
	public ModelAndView memo(
			@RequestParam(name = "textmemo", required = false) String textmemo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("textmemo", textmemo);
		modelAndView.setViewName("/MemoOut.html");
		return modelAndView;

		}

//
//	@RequestMapping(value = "memoform", method = RequestMethod.POST)
//	public String output1(
//		@RequestParam(value = "TextMemo") String memoStr,
//		Model model) {
//
//		model.addAttribute("memo1", memoStr);
//		return "/MemoOut.html";
//	}

//	@RequestMapping(value = "memoform", method = RequestMethod.GET)
//	public ModelAndView memo(Object memoStr) {
//		ModelAndView modelAndView = new ModelAndView("MemoInp");
//		modelAndView.addObject("memo1",memoStr);
//		return modelAndView;
//	}

}
