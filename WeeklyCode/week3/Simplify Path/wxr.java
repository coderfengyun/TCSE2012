

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {

		SimplifyPath simplifyPath = new SimplifyPath();
		System.out.println(simplifyPath
				.simplifyPath("/mpJN/..///../../ubYgf/tFM/"));

	}

	public String simplifyPath(String path) {
		if (path.isEmpty()) {
			return "/";
		}
		String simplePath = "";
		String[] pathParams = path.split("/");
		Stack<String> stack = new Stack<String>();
		for (String pathParam : pathParams) {

			if (pathParam.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}

			} else if (pathParam.equals(".") || pathParam.isEmpty()) {

				continue;
			} else {
				stack.push(pathParam);
			}
		}

		if (stack.isEmpty()) {
			simplePath = "/";
		} else {
			Iterator<String> iterator = stack.iterator();
			while (iterator.hasNext()) {

				simplePath += "/" + iterator.next();
			}
		}

		return simplePath;
	}
}
