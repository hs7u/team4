package web.Customer.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthController {
    @RequestMapping(path = {"/Customer/login/oauth2/google"}, method = RequestMethod.GET)
    public void oauth2Login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("ok");
    	// Google取得access_token的url
        URL urlObtainToken = new URL("https://accounts.google.com/o/oauth2/token");
        HttpURLConnection connectionObtainToken =  (HttpURLConnection) urlObtainToken.openConnection();
            
        // 設定此connection使用POST
        connectionObtainToken.setRequestMethod("POST");
        connectionObtainToken.setDoOutput(true);
        
        // 開始傳送參數 
        OutputStreamWriter writer = new OutputStreamWriter(connectionObtainToken.getOutputStream());
        writer.write("code="+req.getParameter("code")+"&");   // 取得Google回傳的參數code
        writer.write("client_id=256304216081-u7ji7nb24h040688p9rq98mdnisr9ue7.apps.googleusercontent.com&");   // 這裡請將xxxx替換成自己的client_id
        writer.write("client_secret=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&");   // 這裡請將xxxx替換成自己的client_serect
        writer.write("redirect_uri=http://localhost:7080/lend/Customer/login/oauth2/google&");   // 這裡請將xxxx替換成自己的redirect_uri
        writer.write("grant_type=authorization_code");  
        writer.close();
        
        // 如果認證成功
        if (connectionObtainToken.getResponseCode() == HttpURLConnection.HTTP_OK){
            StringBuilder sbLines   = new StringBuilder("");
            
            // 取得Google回傳的資料(JSON格式)
            BufferedReader reader = 
                new BufferedReader(new InputStreamReader(connectionObtainToken.getInputStream(),"utf-8"));
            String strLine = "";
            while((strLine=reader.readLine())!=null){
                sbLines.append(strLine);
            }
            
            try {
                // 把上面取回來的資料，放進JSONObject中，以方便我們直接存取到想要的參數
                JSONObject jo = new JSONObject(sbLines.toString());
                getEmail(jo);
                // 印出Google回傳的access token
                // resp.getWriter().println(jo.getString("access_token")); 
            } catch (JSONException e) {
                e.printStackTrace();
            }
                    
        }
    }
    private void getEmail(JSONObject jo) throws ServletException, IOException {
        URL urUserInfo =   
            new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token="+jo.getString("access_token")); 
        HttpURLConnection connObtainUserInfo =  (HttpURLConnection) urUserInfo.openConnection();
        
        //如果認證成功
        if (connObtainUserInfo.getResponseCode() == HttpURLConnection.HTTP_OK){
            StringBuilder sbLines = new StringBuilder("");
            
            // 取得Google回傳的資料(JSON格式)
            BufferedReader reader = 
            new BufferedReader(new InputStreamReader(connObtainUserInfo.getInputStream(),"utf-8"));
            String strLine = "";
            while((strLine=reader.readLine())!=null){
                sbLines.append(strLine);
            }
            
            try {
            // 把上面取回來的資料，放進JSONObject中，以方便我們直接存取到想要的參數
            JSONObject joInfo = new JSONObject(sbLines.toString());
                
            // 印出Google回傳的"emailtoken
            System.out.println(joInfo.getString("email"));
            System.out.println(joInfo.getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
