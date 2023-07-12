package fpoly.sd17318.lab4.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    public Cookie get(String name) {
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }

    public String getValue(String name) {
        Cookie c = get(name);
        return c != null ? c.getValue() : "";
    }

    public Cookie add(String name, String value, int hours) {
        Cookie c = new Cookie(name, value);
        c.setMaxAge(hours * 3600);
        response.addCookie(c);
        return c;
    }

    public void remove(String name) {
        add(name, "", 0);
    }

}
