package leetcode;

import java.util.Locale;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/simplify-path/
 */
public class Problem71_SimplifyPath {
	public String simplifyPath(String path) {
		assert path != null;
		assert path.length() > 0;

		String ret = "";

		path = path.trim();
		String[] parts = path.split("/");
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (part.length() == 0) {
				continue;
			} else if (part.equals(".")) {
				continue;
			} else if (part.equals("..")) {
				int idx = ret.lastIndexOf("/");
				if (idx != -1) {
					ret = ret.substring(0, idx);
				}
			} else {
				ret = ret + "/" + part;
			}
		}

		if (ret.equals("")) {
			ret = "/";
		}

		return ret;
	}

	public String simplifyPath2(String path) {
		assert path != null;
		assert path.length() > 0;

		Stack<String> stack = new Stack<>();

		path = path.trim();
		String[] parts = path.split("/");
		for (String part : parts) {
			if (part.equals("")) {
				continue;
			} else if (part.equals(".")) {
				continue;
			} else if (part.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(part);
			}
		}

		String ret = "";
		while (!stack.isEmpty()) {
			ret = "/" + stack.pop() + ret;
		}

		if (ret.equals("")) {
			ret = "/";
		}

		return ret;
	}

	public static void main(String[] args) {
		Problem71_SimplifyPath obj = new Problem71_SimplifyPath();
		System.out.println(obj.simplifyPath2("/home/"));
		System.out.println(obj.simplifyPath2("/../"));
		System.out.println(obj.simplifyPath2("/home//foo"));
		System.out.println(obj.simplifyPath2("/a/./b/../../c/"));
	}
}
