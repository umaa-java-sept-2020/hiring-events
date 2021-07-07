package com.candidate.interview.hiringevent;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class TestRun {
    public static void main(String[] args) {
        HttpServletRequest httpServletRequest = new CustomHttpServletRequestMapper(null);
    }

    private static class CustomHttpServletRequestMapper extends HttpServletRequestWrapper
    {
        public CustomHttpServletRequestMapper(HttpServletRequest request) {
            super(request);
        }

        @Override
        public String getMethod() {
            return "GET";
        }

        @Override
        public String getServletPath() {
            return "/rest/projects/info";
        }
    }
}
