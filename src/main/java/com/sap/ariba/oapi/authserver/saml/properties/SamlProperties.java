package com.sap.ariba.oapi.authserver.saml.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by i851894 on 12/29/15.
 */
@Component
@ConfigurationProperties(prefix = "saml")
public class SamlProperties {

  private Map<String, String > idpUrls;
  private String providerId;
  private String keyStorePassword;

  public Map<String, String> getIdpUrls(){
    return this.idpUrls;
  }

  public void setIdpUrls( Map<String, String> idpUrls ){
    this.idpUrls = idpUrls;
  }

  public void setProviderId( String providerId){
    this.providerId = providerId;
  }

  public String getProviderId(){
    return this.providerId;
  }

  public String getKeyStorePassword() {
    return keyStorePassword;
  }

  public void setKeyStorePassword(String keyStorePassword) {
    this.keyStorePassword = keyStorePassword;
  }

}

