package com.gestiondepartement.Config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {
    @SuppressWarnings({"rowtypes", "unchecked"})
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(org.springframework.context.ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/allService/*");
    }

    @Bean(name = "students")
    public DefaultWsdl11Definition defaultWsdl11Definition1(XsdSchema studentSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("allServiceSoapHttp");
        wsdl11Definition.setLocationUri("/allService");
        wsdl11Definition.setTargetNamespace("com.gestiondepartement.allapis");
        wsdl11Definition.setSchema(studentSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema studentSchema(){
        return new SimpleXsdSchema(new ClassPathResource("student.xsd"));
    }

    @Bean(name = "teachers")
    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema teacherSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("allServiceSoapHttp");
        wsdl11Definition.setLocationUri("/allService");
        wsdl11Definition.setTargetNamespace("com.gestiondepartement.allapis");
        wsdl11Definition.setSchema(teacherSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema teacherSchema(){
        return new SimpleXsdSchema(new ClassPathResource("teacher.xsd"));
    }

    @Bean(name = "admins")
    public DefaultWsdl11Definition defaultWsdl11Definition3(XsdSchema adminSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("allServiceSoapHttp");
        wsdl11Definition.setLocationUri("/allService");
        wsdl11Definition.setTargetNamespace("com.gestiondepartement.allapis");
        wsdl11Definition.setSchema(adminSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema adminSchema(){
        return new SimpleXsdSchema(new ClassPathResource("admin.xsd"));
    }
}

