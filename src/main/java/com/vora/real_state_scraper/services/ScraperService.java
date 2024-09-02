package com.vora.real_state_scraper.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ScraperService {
	
	public ScraperService() {
	}

	private static String sendRequest(String url) {
		HttpRequest req;
	    HttpClient client = HttpClient.newHttpClient();
		try {
			req = HttpRequest.newBuilder().uri(new URI(url)).GET().build();
			HttpResponse<String> resp = client.send(req, BodyHandlers.ofString());
			return resp.body();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static void main(String[] args) {
		ScraperService ss = new ScraperService();
		
		String html = sendRequest("https://www.dfimoveis.com.br/");
		System.out.println(html);
	}
}
