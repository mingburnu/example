package misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;

public class DateTypeConverter extends StrutsTypeConverter {
	private SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(values!=null && values.length!=0) {
			for(String value : values) {
				try {
					return sFormat.parse(value);
				} catch (ParseException e) {
					e.printStackTrace();
					throw new TypeConversionException(e);
				}
			}
		}
		return null;
	}
	@Override
	public String convertToString(Map context, Object value) {
		if(value != null && value instanceof java.util.Date) {
			return sFormat.format(value);
		}
		return null;
	}
}
