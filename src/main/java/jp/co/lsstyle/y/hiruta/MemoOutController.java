package jp.co.lsstyle.y.hiruta;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemoOutController {

	@RequestMapping(value="/MemoOut", method = RequestMethod.GET)
	private String memoout() {
		return "memoout";
	}
}
