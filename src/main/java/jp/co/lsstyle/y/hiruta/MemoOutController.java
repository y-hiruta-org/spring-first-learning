package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemoOutController {

	//保存ボタン
	@RequestMapping(value="memoOutButton",params = "memoSave", method = RequestMethod.POST)
	private ModelAndView memoSave(ModelAndView model, MemoOutForm form) {
		model.addObject("memoOutForm", form);
		model.setViewName("/MemoOut.html");
		return model;
	}

	//戻るボタン
	@RequestMapping(value="memoOutButton",params = "memoBack", method = RequestMethod.POST)
	private ModelAndView memoBack(ModelAndView model) {
		model.setViewName("/MemoInp.html");
		return model;
	}

	//トップメニューへ
	@RequestMapping(value="memoOutButton",params = "topBack", method = RequestMethod.POST)
	private ModelAndView topBack(ModelAndView model) {
		model.setViewName("/TopMenu.html");
		return model;
	}

}
