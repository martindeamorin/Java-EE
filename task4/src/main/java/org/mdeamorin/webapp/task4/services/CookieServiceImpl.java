package org.mdeamorin.webapp.task4.services;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServiceImpl implements CookieService {
    private final Integer MAX_AGE = 60*60;

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

    @Override
    public void setCookie(HttpServletResponse resp, String key, String value) {
        Cookie newCookie = new Cookie(key, value);
        newCookie.setMaxAge(MAX_AGE);
        resp.addCookie(newCookie);
    }
}
