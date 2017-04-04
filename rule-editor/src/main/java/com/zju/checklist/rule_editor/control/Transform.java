package com.zju.checklist.rule_editor.control;

import java.util.HashMap;
import java.util.Map;

public class Transform {
	
	
	public String trans(String input){
		Map<String,String> drools = new HashMap<String,String>();
		String output;
		drools.put("规则库配置文件", "Configuration");
		drools.put("会话配置文件","KieModules");
		drools.put("清单组件库","Repository");
		drools.put("资源文件","Resource");
		drools.put("规则库", "Rules");
		drools.put("Configuration", "规则库配置文件");
		drools.put("KieModules","会话配置文件");
		drools.put("Repository","清单组件库");
		drools.put("Resource","资源文件");
		drools.put("Rules", "规则库");
		output = drools.get(input);
		System.out.println(output);
		return output;
	}
	

}
