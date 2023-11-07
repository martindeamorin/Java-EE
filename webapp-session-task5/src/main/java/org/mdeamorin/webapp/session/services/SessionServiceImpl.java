package org.mdeamorin.webapp.session.services;

import jakarta.servlet.http.HttpServletRequest;

public class SessionServiceImpl implements SessionService {
    @Override
    public String getSessionValue(HttpServletRequest req, String key) {
        Object sessionAttribute = req.getSession().getAttribute(key);
        return sessionAttribute != null ? sessionAttribute.toString() : null;
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
