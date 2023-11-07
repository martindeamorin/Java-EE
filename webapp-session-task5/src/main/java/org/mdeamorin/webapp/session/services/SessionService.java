package org.mdeamorin.webapp.session.services;

import jakarta.servlet.http.HttpServletRequest;

public interface SessionService {
    String getSessionValue(HttpServletRequest req, String key);
    void deleteSessionValue(HttpServletRequest req, String key);
    void setSessionValue(HttpServletRequest req, String key, String value);
} 
