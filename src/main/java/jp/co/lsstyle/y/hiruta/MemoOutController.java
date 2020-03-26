package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemoOutController {

	@RequestMapping(value="/memoOut", method = RequestMethod.GET)
	private ModelAndView memoOut(ModelAndView model, MemoOutForm form) {
		model.addObject("memoOutForm", form);
		model.setViewName("/MemoOut.html");
		return model;
	}

	@RequestMapping(value = "/memoOutButton",params = "memoBack", method = RequestMethod.POST)
	private ModelAndView memoButton(ModelAndView model) {
		model.setViewName("/MemoInp.html");
		return model;
	}

}
