package org.mdeamorin.webapp.task4.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    Optional<String> getCookieValue(HttpServletRequest req, String key);
    void deleteCookie(HttpServletResponse resp, String key);
    void setCookie(HttpServletResponse resp, String key, String value);
} 
