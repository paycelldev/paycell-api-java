package com.example.paycellwebapiclient.common.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class JsonRestClient<T, S> {

  @SuppressWarnings("unchecked")
  public S sendRequest(T t, Class<S> responseClass) throws Exception {
    try {
      String jsonRequest = JsonUtil.convertObjectToJson(t);

      HttpClient httpClient = HttpClientBuilder.create().build();
      HttpPost post = new HttpPost(getUrl());
      StringEntity postingString = new StringEntity(jsonRequest);
      post.setEntity(postingString);
      post.setHeader("Content-type", "application/json");
      HttpResponse response = httpClient.execute(post);
      String jsonResponse = StreamUtil.readInputStream(response.getEntity().getContent());

      return (S) JsonUtil.convertJsonToObject(jsonResponse, responseClass);

    } catch (Exception e) {
      throw new Exception("An error occured during request method", e);
    }
  }

  public String getUrl() {
    return null;
  }

}
