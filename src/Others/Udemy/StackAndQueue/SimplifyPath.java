package Others.Udemy.StackAndQueue;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
In this coding challenge, we will build a functionality for a command line tool. We want to write a function that takes in a non-empty string representing a
valid Unix-shell path and returns a simplified version of the path. The simplified path must be equivalent to the original path,
that means it should point to same file/directory as the original path.
A path can be an absolute path , meaning that it starts at the root directory in a file system, or a relative path
, meaning that it starts at the current directory in a file system. In a Unix-like Operating System, a path is bounded by the following rules:
The root directory is represented by a / , it's an absolute path; if it doesn't, it's a relative path.
The symbol ..  represents the parent directory. This means that accessing files or directories in /x/y/..  is equivalent to accessing files or directories in /x.
They symbol  represents the current directory. This means that accessing files or directories in /x/y/. is equivalent to accessing files or directories in  /x/y
 The symbols / and . can be repeated sequentially without consequence; the symbol ..  cannot, however repeating it sequentially means going further up in the parent directories. For example,
 /x/y/z/././. and /x/y/z  are equivalent. and /x/y/z/../../... and /x/y/z  aren't. The only exception is with the root directory : /../../.. and
 /  are equivalent because the root directory has no parent directory, which means repeated accessing parent directories does nothing.
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        List<String> tokens = Arrays.stream(path.split("/"))
                .filter(x -> !x.trim().equals(".") && !x.trim().equals(""))
                .collect(Collectors.toList());
        Stack<String> stack = new Stack<>();
        if (path.charAt(0) == '/') {
            stack.push("");
        }
        for (String token : tokens) {
            if (token.equals("..")) {
                if (stack.size() == 0 || stack.peek() == "..") {
                    stack.push(token);
                } else if (stack.peek() != "") {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        if (stack.size() == 1 && stack.peek() == "") return "/";
        StringBuilder res = new StringBuilder("/");
        while (!stack.isEmpty()) {
            res = res.append(stack.pop()).append("/");
        }
        return res.substring(0, res.length() - 2);
    }

    public static void main(String[] args) {
        String path = "/../x/y/../z/././w/a///../../c/./";
        System.out.println(simplifyPath(path));
    }
}