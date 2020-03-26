package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class MemoInpController {

	/**
	 * 初期表示処理
	 *
	 * @return ModelAndView 画面情報
	 */
	@RequestMapping(value="/memoInp", method = RequestMethod.GET)
	private ModelAndView memoInp(ModelAndView model, MemoInpForm form) {
		model.addObject("memoInpForm", form);
		model.setViewName("/MemoInp.html");
		return model;
	}


	/**
	 * フォーム処理
	 *
	 * @param model 画面情報
	 * @param form フォーム
	 * @param textMemo
	 * @return 画面情報
	 */
	@RequestMapping(value = {"/memoForm"}, method = RequestMethod.POST)
	public ModelAndView memo(
			@ModelAttribute("memoInpForm") MemoInpForm form, ModelAndView model) {
		model.addObject("memoInpForm", form);
		model.setViewName("/MemoOut.html");
		return model;

	}


	@RequestMapping(value="/memoOutButton", method = RequestMethod.GET)
	private ModelAndView memoButton(ModelAndView model) {
		model.setViewName("/MemoInp.html");
		return model;
	}
}
