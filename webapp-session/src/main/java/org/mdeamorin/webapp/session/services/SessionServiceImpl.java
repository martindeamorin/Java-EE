package org.mdeamorin.webapp.session.services;

import jakarta.servlet.http.HttpServletRequest;

public class SessionServiceImpl implements SessionService {
    @Override
    public String getSessionValue(HttpServletRequest req, String key) {
        return req.getSession().getAttribute("username").toString();
    }
    @Override
    public void deleteSessionValue(HttpServletRequest req, String key) {
        req.getSession().removeAttribute(key);
    }

    @Override
    public void setSessionValue(HttpServletRequest req, String key, String value) {
        req.getSession().setAttribute(key, value);
    }
}
