package wf.hackathon.diversitydimension.config;


import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;

import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.http.MediaType;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableElasticsearchRepositories(basePackages
        = "wf.hackathon.diversitydimension.elastic.repositories")
@ComponentScan(basePackages = { "wf.hackathon.diversitydimension.elastic" })
public class ElasticSearchConfiguration extends
        AbstractElasticsearchConfiguration {
    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        HttpHost[] hosts = new HttpHost[1];
        hosts[0] = new HttpHost("testdeployment-de5f04.es.us-central1.gcp.cloud.es.io", 9243, "https");

        Header[] headers = new Header[2];
        headers[0] = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.elasticsearch+json;compatible-with=7");;
        headers[1] = new BasicHeader(HttpHeaders.ACCEPT, "application/vnd.elasticsearch+json;compatible-with=7");;


        RestClientBuilder builder = RestClient.builder(hosts).setDefaultHeaders(headers);


        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("ddtest", "Pass1234"));


        final SSLContext sslContext;
        try {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("my_keystore.jks");

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            keyStore.load(in, "password".toCharArray());
            in.close();

            sslContext = SSLContexts.custom()
                    .loadTrustMaterial(keyStore,
                            new TrustSelfSignedStrategy())
                    .build();
            builder.setHttpClientConfigCallback(httpClientBuilder -> {
                //httpClientBuilder.disableAuthCaching();
                httpClientBuilder.setSSLContext(sslContext);
                return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

        return restHighLevelClient;
    }
}