package com.demo.util;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.View;

/**
 * Spring MVC 视图
 * 
 * 提供Ajax方式返回Json对象
 * 
 * @author XXX
 * 
 */
public class JsonView implements View {
	private Map<String, Object> map = new HashMap<String, Object>();

	@Override
	public String getContentType() {
		return "text/plain;charset=UTF-8";
	}

	public void setProperty(String key, Object value) {		
		map.put(key, value);
	}

	@Override
	public void render(Map<String, ?> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		PrintWriter out = response.getWriter();
		try {
			out.write(this.getJSONString());
		} finally {
			out.close();
			out = null;
		}
	}

	/**
	 * 获取json对象:
	 * 
	 * {"success":"true","message":"info"}
	 */
	private String getJSONString() {
		JSONObject jsonObject = getJsonFromMap(map);
		return jsonObject.toString();
	}

	/**
	 * Map对象转化Json对象
	 * 
	 * @param map
	 * @return
	 */
	private JSONObject getJsonFromMap(Map<String, Object> map) {
		if (!map.isEmpty()) {
			JSONObject jsonObject = new JSONObject();
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				Object key = it.next();
				jsonObject.put(key, map.get(key));
			}
			return jsonObject;
		} else {
			return null;
		}
	}

	public static void main(String[] args) {
		JsonView view = new JsonView();
		view.setProperty("a", "1");
		view.setProperty("b", "2");
		System.out.println(view.getJSONString());

	}
}
