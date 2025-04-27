package com.java.problems.leetcode.medium;

import java.util.Stack;

import static java.lang.System.*;

public class SimplifyPath71 {
    public static void main(String[] args) {
        String path01 = "/home/";
        String path02 = "/a/./b/../../c/";
        String path03 = "/a/./b/../../c/../../d/";
        String path04 = "/home//foo/";
        String path05 = "/home/user/Documents/../Pictures";
        String path06 = "/../";
        String path07 = "/.../a/../b/c/../d/./";
        String path08 = "/a//b////c/d//././/..";
        String path09 = "/..";
        SimplifyPath71 s = new SimplifyPath71();
        out.println(s.simplifyPath(path01));
        out.println(s.simplifyPath(path02));
        out.println(s.simplifyPath(path03));
        out.println(s.simplifyPath(path04));
        out.println(s.simplifyPath(path05));
        out.println(s.simplifyPath(path06));
        out.println(s.simplifyPath(path07));
        out.println(s.simplifyPath(path08));
        out.println(s.simplifyPath(path09));
    }
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length(); ) {
            char c = path.charAt(i);
            if (c == '/') {
                while (i < path.length() && path.charAt(i) == '/') {
                    i++;
                }
                if(stack.empty() || !stack.peek().toString().equals("/")) {
                    stack.push(Character.toString(c));
                }
            }
            else if (c == '.') {
                int dotCount = 0;
                StringBuilder temp = new StringBuilder();
                while (i < path.length() && path.charAt(i) == '.') {
                    dotCount++;
                    temp.append(path.charAt(i));
                    i++;
                }
                if((dotCount == 1 && i < path.length() && path.charAt(i) == '/') ||
                        (dotCount == 1 && i == path.length())){
                } else if((dotCount == 2 && i < path.length() && path.charAt(i) == '/') ||
                        (dotCount == 2 && i == path.length())){
                    if(stack.size() > 1) {
                        stack.pop();
                    }
                    if(stack.size() > 1) {
                        stack.pop();
                    }
                } else {
                    while (i < path.length() && path.charAt(i) != '/') {
                        temp.append(path.charAt(i));
                        i++;
                    }
                    stack.push(temp.toString());
                }
            } else {
                StringBuilder temp = new StringBuilder();
                while (i < path.length() && path.charAt(i) != '/') {
                    temp.append(path.charAt(i));
                    i++;
                }
                stack.push(temp.toString());
            }
        }
        if(stack.size() > 1 && stack.peek().equals("/")) {
            stack.pop();
        }
        return stack.toString().replace(", ","").replace("[", "").replace("]", "");
    }
}
