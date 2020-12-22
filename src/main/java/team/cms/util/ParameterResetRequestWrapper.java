package team.cms.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Map;
import java.util.Vector;

public class ParameterResetRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> parameterMap;

    public ParameterResetRequestWrapper(HttpServletRequest request, Map<String, String[]> parameterMap) {
        super(request);
        this.parameterMap = parameterMap;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return parameterMap;
    }

    @Override
    public Enumeration<String> getParameterNames() {
        return new Vector<>(parameterMap.keySet()).elements();
    }

    @Override
    public String getParameter(String name) {
        Object value = parameterMap.get(name);
        if (value == null) {
            return null;
        } else if (value instanceof String[]) {
            String[] values = (String[]) value;
            if (values.length > 0) {
                return values[0];
            } else {
                return null;
            }
        } else if (value instanceof String) {
            return (String) value;
        } else {
            return value.toString();
        }
    }

    @Override
    public String[] getParameterValues(String name) {
        Object value = parameterMap.get(name);
        if (value == null) {
            return null;
        } else if (value instanceof String[]) {
            return (String[]) value;
        } else if (value instanceof String) {
            return new String[]{(String) value};
        } else {
            return new String[]{value.toString()};
        }
    }
}
