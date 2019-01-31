package com.example.paycellwebapiclient.common.util;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil<T> {

  /**
   * Marshals Object to json
   *
   * @param object object to be marshalled
   * @return json
   * @throws JsonProcessingException thrown if error exists during marshalling
   */
  public static String convertObjectToJson(Object object) throws JsonProcessingException {
    String json = new ObjectMapper().writer().writeValueAsString(object);
    return json;
  }

  /**
   * Unmarshals json to object
   *
   * @param json to be unmarshalled
   * @param returnClass class for the object
   * @return obbject instance
   * @throws IOException thrown if error exists during unmarshalling
   */
  public static Object convertJsonToObject(String json,
      Class<? extends Object> returnClass) throws IOException {
    return new ObjectMapper().readValue(json, returnClass);
  }
}
