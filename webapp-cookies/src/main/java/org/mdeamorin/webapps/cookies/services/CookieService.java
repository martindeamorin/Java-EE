package org.mdeamorin.webapps.cookies.services;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    Optional<String> getCookieValue(HttpServletRequest req, String key);
    void deleteCookie(HttpServletResponse resp, String key);

} 
