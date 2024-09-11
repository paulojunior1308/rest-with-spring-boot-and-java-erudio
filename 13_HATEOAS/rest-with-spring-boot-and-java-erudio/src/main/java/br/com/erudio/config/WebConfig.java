package br.com.erudio.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import br.com.erudio.serialization.converter.YamlJackson2HttpMesageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer
{
  @Override
  public void configureContentNegotiation(@SuppressWarnings("null") ContentNegotiationConfigurer configurer) {

    final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
    
    // Via QUERY PARAM. http://localhost:8080/api/person/v1?mediaType=xml
    /*
    configurer.favorParameter(true)
      .parameterName("mediaType")
      .ignoreAcceptHeader(true)
      .useRegisteredExtensionsOnly(false)
      .defaultContentType(MediaType.APPLICATION_JSON)
      .mediaType("json", MediaType.APPLICATION_JSON)
      .mediaType("xml", MediaType.APPLICATION_XML);
    */

    // Via HEADER PARAM. http://localhost:8080/api/person/v1
    configurer.favorParameter(false)
      .ignoreAcceptHeader(false)
      .useRegisteredExtensionsOnly(false)
      .defaultContentType(MediaType.APPLICATION_JSON)
      .mediaType("json", MediaType.APPLICATION_JSON)
      .mediaType("xml", MediaType.APPLICATION_XML)
      .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
  }

  @Override
  public void extendMessageConverters(@SuppressWarnings("null") List<HttpMessageConverter<?>> converters) {
    converters.add(new YamlJackson2HttpMesageConverter());
  }
  
}