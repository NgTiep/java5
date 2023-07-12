package fpoly.sd17318.lab4.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        return value != null ? value : defaultValue;
    }

    public int getInt(String name, int defaultValue) {
        String value = request.getParameter(name);
        return value != null ? defaultValue : Integer.valueOf(value);
    }

    public double getDouble(String name, double defaultValue) {
        String value = request.getParameter(name);
        return value != null ? defaultValue : Double.valueOf(value);
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String value = getString(name, "");
        return value.isEmpty() ? defaultValue : Boolean.valueOf(value);
    }

    public Date getDate(String name, String pattern) {
        return null;
    }

    public File save(MultipartFile file, String path) {
        // TODO
        return null;
    }
}
