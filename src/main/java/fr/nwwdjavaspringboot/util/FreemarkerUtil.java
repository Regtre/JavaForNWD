package fr.nwwdjavaspringboot.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerUtil {
    public static StringWriter process(String templateName, Map<String, Object> templateData) {
        Configuration cfg = new Configuration(new Version("2.3.23"));

        // TODO : change template loading class !
        cfg.setClassForTemplateLoading(ApplicationContext.class, "/");
        cfg.setDefaultEncoding("UTF-8");

        StringWriter stringWriter = new StringWriter();

        try {
            Template template = cfg.getTemplate(templateName);
            template.process(templateData, stringWriter);
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

        return stringWriter;
    }

    public static void writeToHttpServletResponse(StringWriter stringWriter, HttpServletResponse resp) {
        resp.setContentType("text/html");
        byte[] buffer = stringWriter.toString().getBytes(StandardCharsets.UTF_8);

        try {
            resp.setContentLength(buffer.length);
            resp.getOutputStream().write(buffer);
            resp.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void processToHttpServletResponse(String templateName, Map<String, Object> templateData, HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("connectedUser")!=null && templateData != null) templateData.put("user", request.getSession().getAttribute("connectedUser"));

        StringWriter stringWriter = process(templateName, templateData);
        writeToHttpServletResponse(stringWriter, response);
        try {
            stringWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Object> getDefaultTemplateData(HttpServletRequest request) {
        Map<String, Object> templateData = new HashMap<>();
        if (request.getSession().getAttribute("mode") != null &&
                request.getSession().getAttribute("mode").equals("dev")) {
            templateData.put("mode", "dev");
        }
        return templateData;
    }

    public static Map<String, Object> getTemplateDataWithParametersPropagation(HttpServletRequest request) {
        Map<String, Object> templateData = getDefaultTemplateData(request);
        for (String param : Collections.list(request.getParameterNames())) {
            templateData.put(param, request.getParameter(param));
        }
        return templateData;
    }
}
