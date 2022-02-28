package web.CommonUtil;

import java.security.SecureRandom;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StaticUtil {
    public static final Gson GSON = new GsonBuilder().create();
	public static final String JSON_MIME_TYPE = "application/json";
	public static final String PREFIX_WEB_INF = "/WEB-INF";
	public static final String MAIL_SUBJECT = "會員驗證信";
	public static final String SYMBOLS = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";
	public static final String ATAG_HREF = "<a href='http://localhost:7080/lend/Customer/init/";
	public static final String ATAG_AfterParam = "''><span>驗證</span></a>";
	public static final Random RANDOM = new SecureRandom();
}
