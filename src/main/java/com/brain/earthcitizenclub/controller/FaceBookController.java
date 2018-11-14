package com.brain.earthcitizenclub.controller;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brain.earthcitizenclub.util.StringUtil;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.Parameter;
import com.restfb.exception.FacebookOAuthException;
import com.restfb.types.FacebookType;

@Controller
public class FaceBookController {

	final String APPID = "838205832995879";
	final String APPSECRET = "2f15a99de7451faa81608fc32aa0e0b1";
	
	//TODO
	//계정에서 받아오기
	String accesstoken = "EAAD3sOGEJWkBAPe2a212gKSh18KNvRCwJOCAUjMi0IzwZBE9S1ZAJwwV3C020ikj0G5e0SNSCe4oZC3Yr7qQhck1ZC1UHZA8eVKNrXCbhpesIbc7AMF5caYIbPp6yjJBe6pwNNaRSwv8OeUYZCLHHlwiIZBtyB1zcZC6JZApnby1JARgTgBjOWO14";

	@RequestMapping("/post")
	@ResponseBody
	public String post() {

		DefaultFacebookClient fbClient = new DefaultFacebookClient(accesstoken);

		FacebookType publishMessageResponse = null;

		try {
			publishMessageResponse = fbClient.publish("me/feed", FacebookType.class,
					Parameter.with("message", "담벼락 포스팅 내용을 입력합니다."), Parameter.with("link", "javaking75.blog.me"),
					Parameter.with("picture", "이미지경로"), Parameter.with("type", "link"),
					Parameter.with("name", "링크이름입니다."), Parameter.with("caption", "caption 입니다."),
					Parameter.with("description", "description 입니다."));
		} catch (FacebookOAuthException e) {
			// error occur!!
			e.printStackTrace();
		}
		return publishMessageResponse.getId();
	}

	@RequestMapping("/getToken")
	public String getToken(Model model, @RequestParam(required = false) String code)
			throws MalformedURLException, IOException {

		if (StringUtil.isNotEmpty(code)) {
			String redirectUrl = "http://www.khdi.org/getToken";
			String url = "https://graph.facebook.com/oauth/access_token?client_id=" + this.APPID
					+ "&redirect_uri=" + redirectUrl + "&client_secret=" + this.APPSECRET + "&code=" + code;
			String token = "초기값";
			try {
				URL newURL = new URL(url);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				InputStream is = newURL.openStream();
				int r;
				while ((r = is.read()) != -1) {
					baos.write(r);
				}
				String response = new String(baos.toByteArray());
				is.close();
				baos.close();
				
				
				//TODO 토큰 짤라서 쓰기
				token = response;
				System.out.println(token);

			} catch (Exception e) {
				System.err.println(e);
			}
			model.addAttribute("url", url);
			model.addAttribute("token", token);
		}
		
		model.addAttribute("code", code);
		
		return "/test/faceBookAutoShare";
	}
}
