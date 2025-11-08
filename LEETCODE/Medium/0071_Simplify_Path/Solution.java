import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String dir : components) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pollLast(); // Go up one directory
                }
            } else if (!dir.equals("") && !dir.equals(".")) {
                stack.addLast(dir); // Push valid directory
            }
        }

        // If stack empty → root
        if (stack.isEmpty()) {
            return "/";
        }

        // Join path parts with single '/'
        return "/" + String.join("/", stack);
    }
}
