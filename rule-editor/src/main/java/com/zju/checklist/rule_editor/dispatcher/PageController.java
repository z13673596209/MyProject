
package com.zju.checklist.rule_editor.dispatcher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value="/")
	public String showRootPage(){
		return "ruleList";
	}
	
	@RequestMapping(value="/ruleEditor")
	public String showRuleEditor(){
		return "ruleEditor";
	}
	
	
	
}