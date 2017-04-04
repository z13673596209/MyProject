package com.zju.checklist.rule_editor.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zju.checklist.rule_editor.containers.JudgeResult;
import com.zju.checklist.rule_editor.containers.Rule;
import com.zju.checklist.rule_editor.containers.Rules;

@RestController
public class CreateRules {
    private String path = "d://Checklist";
    private static Map<String, String> drools = new HashMap<String, String>();

    static {
        drools.put("规则库配置文件", "Configuration");
        drools.put("会话配置文件", "KieModules");
        drools.put("清单组件库", "Repository");
        drools.put("其他", "Resource");
        drools.put("规则库", "Rules");
        drools.put("Configuration", "规则库配置文件");
        drools.put("KieModules", "会话配置文件");
        drools.put("Repository", "清单组件库");
        drools.put("Resource", "其他");
        drools.put("Rules", "规则库");
    }

    public CreateRules() {
    }

    @RequestMapping(value = "/CreateRule", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public JudgeResult CreateRule(@RequestBody Rule rule) throws IOException {
        String text;
        String loc = rule.getLocation();
        String location1;
        text = rule.getText();
        JudgeResult judgeResult = new JudgeResult();
        // java.net.URLDecoder.decode("text","UTF-8");
//		System.out.println(text);		
        try {

            if (loc.indexOf("/") != -1) {
                loc = drools.get((loc.substring(0, loc.indexOf("/"))))
                        + loc.substring(loc.indexOf("/"), loc.length());
            } else {
                if (drools.containsKey(loc)) {
                    loc = drools.get(loc);
                } else {

                }
            }
            location1 = path + "/" + loc;

            FileOutputStream fs = new FileOutputStream(location1);
            // FileOutputStream fs = new FileOutputStream("D:/rule/11.DRL");
            OutputStreamWriter osw = new OutputStreamWriter(fs, "UTF-8");
            osw.write(text);
            osw.flush();
            osw.close();
            judgeResult.setResult("success");
        } catch (Exception e) {
            e.printStackTrace();
            judgeResult.setResult("false");
        }
        return judgeResult;
    }

    @RequestMapping(value = "/CreateList", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Rules CreateList(@RequestBody Rule rule) {
        String path1;

        String loc = rule.getLocation();
//		System.out.println(loc);
        if (loc == null) {
            path1 = path;
        } else {
            if (loc.indexOf("/") != -1) {if( drools.containsKey((loc.substring(0, loc.indexOf("/"))))){
                loc = drools.get((loc.substring(0, loc.indexOf("/"))))
                        + loc.substring(loc.indexOf("/"), loc.length());}else {

            }
            } else {
                if (drools.containsKey(loc)) {
                    loc = drools.get(loc);
                } else {

                }
            }
            path1 = path + "/" + loc;
        }
//        System.out.println(path1);
        File file = new File(path1);
        Rules rules = new Rules();
        List<Rule> list = new ArrayList();
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹为空");
            } else {
                for (File file2 : files) {
                    Rule rule1 = new Rule();
                    String name = file2.getName();
                    // System.out.println(file2.getName());
                    if (name.equals("Configuration") || name.equals("KieModules")
                            || name.equals("Repository") || name.equals("Resource")
                            || name.equals("Rules")) {
                        name = drools.get(file2.getName());

                    } else {
                    }
//					System.out.println(name);
                    rule1.setName(name);

                    list.add(rule1);
                }
                rules.setRules(list);
            }
        } else {
            System.out.println("文件不存在");
        }
        // Iterator it =rules.getRules().iterator();
        // while(it.hasNext()){
        // Rule rule2 = (Rule)it.next();
        // System.out.println(rule2.getName());
        // }
        return rules;

    }

    @RequestMapping(value = "/ReturnText", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public Rules returnText(@RequestBody Rule rule) throws IOException {
        String text;
        String path2 = path;
        Transform transform = new Transform();
        String loc = rule.getLocation();
        System.out.println(loc);
        if (loc == null) {
            path2 = path;
        } else {
            if (loc.indexOf("/") != -1) {
               if(drools.containsKey(loc.substring(0, loc.indexOf("/")))){
                loc = drools.get((loc.substring(0, loc.indexOf("/"))))
                        + loc.substring(loc.indexOf("/"), loc.length());}else{}
            } else {
                if (drools.containsKey(loc)) {
                    loc = drools.get(loc);
                } else {
                }
            }
            path2 = path + "/" + loc;
        }
        System.out.println(path2);
        File file = new File(path2);
        Long fileLength = file.length();
        char[] fileContent = new char[fileLength.intValue()];
        Rules rules = new Rules();
        List<Rule> list = new ArrayList();
        if (file.exists()) {
            FileInputStream fs = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fs, "UTF-8");
            reader.read(fileContent);
            text = String.valueOf(fileContent);
            rule.setText(text);
            rule.setName(file.getName());
            System.out.println(text);
            reader.close();
            list.add(rule);
        } else {
            System.out.println("文件不存在");
        }
        rules.setRules(list);
        return rules;
    }
}
