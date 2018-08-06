package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy // ENABLES SPRING AOP
@ComponentScan(basePackages = { "com.expertsystem" })


public class WebMvcConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/jquery/**").addResourceLocations("/jquery/");
		registry.addResourceHandler("/org/**").addResourceLocations("/org/");
		registry.addResourceHandler("/org/cometd/**").addResourceLocations("/org/cometd/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
		registry.addResourceHandler("/datatable/**").addResourceLocations("/datatable/");
		
		registry.addResourceHandler("/bootstrap/css/**").addResourceLocations("/bootstrap/css/");		
		registry.addResourceHandler("/bootstrap/fonts/**").addResourceLocations("/bootstrap/fonts/");
		registry.addResourceHandler("/bootstrap/js/**").addResourceLocations("/bootstrap/js/");		
		registry.addResourceHandler("/font-awesome/css/**").addResourceLocations("/font-awesome/css/");
		registry.addResourceHandler("/font-awesome/fonts/**").addResourceLocations("/font-awesome/fonts/");
		registry.addResourceHandler("/ckeditor/**").addResourceLocations("/ckeditor/");
		
		//assets
		registry.addResourceHandler("/assets/css/**").addResourceLocations("/assets/css/");		
		registry.addResourceHandler("/assets/fonts/**").addResourceLocations("/assets/fonts/");
		registry.addResourceHandler("/assets/plugins/**").addResourceLocations("/assets/plugins/");		
		registry.addResourceHandler("/assets/img/**").addResourceLocations("/assets/img/");
		registry.addResourceHandler("/assets/scripts/**").addResourceLocations("/assets/scripts/");		
		registry.addResourceHandler("/assets/font-awesome/css/**").addResourceLocations("/assets/font-awesome/css/");
		registry.addResourceHandler("/assets/font-awesome/fonts/**").addResourceLocations("/assets/font-awesome/fonts/");

	}

    @Bean  
    public UrlBasedViewResolver jspViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();  
        resolver.setPrefix("/jsp/");  
        resolver.setSuffix(".jsp");  
        resolver.setViewClass(JstlView.class);  
        resolver.setOrder(0);
        return resolver;  
    } 
    //http://websystique.com/springmvc/springmvc-hibernate-many-to-many-example-annotation-using-join-table/
}
