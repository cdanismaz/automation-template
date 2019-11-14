package com.cd.automationtemplate.config;

import java.text.MessageFormat;

public class Constants {

    public static class Urls {
        public static final String LOGIN_PAGE = "/login";
        public static final String DASHBOARD_PAGE = "/dashboard";

        public static String getAbsoluteUrl(String relativeUrl) {
            return MessageFormat.format("{0}{1}", System.getenv("APP_BASE_URL"), relativeUrl);
        }
    }

    public static class Credentials {
        public static final String VALID_USERNAME = "..";
        public static final String VALID_PASSWORD = "..";

        public static final String INVALID_USERNAME = "test";
        public static final String INVALID_PASSWORD = "test";
    }
}
