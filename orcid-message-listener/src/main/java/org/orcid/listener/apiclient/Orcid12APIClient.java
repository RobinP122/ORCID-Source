package org.orcid.listener.apiclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.orcid.jaxb.model.message.LastModifiedDate;
import org.orcid.jaxb.model.message.OrcidHistory;
import org.orcid.jaxb.model.message.OrcidMessage;
import org.orcid.jaxb.model.message.OrcidProfile;
import org.orcid.listener.LastUpdatedListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Component
public class Orcid12APIClient {

    Logger LOG = LoggerFactory.getLogger(LastUpdatedListener.class);
    protected final Client jerseyClient;    
    protected final URI baseUri;
    
    @Autowired
    public Orcid12APIClient(@Value("${org.orcid.message-lisener.api12BaseURI}") String baseUri) throws URISyntaxException{
        LOG.info("Creating Orcid12APIClient with baseUri = "+ baseUri);
        ClientConfig config = new DefaultClientConfig();
        config.getClasses().add(JacksonJaxbJsonProvider.class);
        jerseyClient = Client.create(config);
        this.baseUri = new URI(baseUri);
    }
    
    /** Fetches the profile from the ORCID public API
     *  VERY basic implementation
     * 
     * @param orcid
     * @return
     */
    public OrcidProfile fetchPublicProfile(String orcid){
        WebResource webResource = jerseyClient.resource(baseUri);
        ClientResponse response = webResource.path(orcid+"/orcid-profile").accept("application/xml").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        OrcidMessage output = response.getEntity(OrcidMessage.class);
        LOG.info(output.toString());
        return output.getOrcidProfile();
    }
}
