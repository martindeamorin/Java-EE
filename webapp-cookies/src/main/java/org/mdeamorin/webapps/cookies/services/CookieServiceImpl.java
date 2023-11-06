package org.mdeamorin.webapps.cookies.services;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServiceImpl implements CookieService {
    @Override
    public Optional<String> getCookieValue(HttpServletRequest req, String key) {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        return Arrays.asList(cookies).stream()
            .filter(c -> key.equals(c.getName()))
            .map(Cookie::getValue)
            .findFirst();
    }
    @Override
    public void deleteCookie(HttpServletResponse resp, String key) {
        Cookie deletedCookie = new Cookie(key, "");
        deletedCookie.setMaxAge(0);
        resp.addCookie(deletedCookie);
    }
}
