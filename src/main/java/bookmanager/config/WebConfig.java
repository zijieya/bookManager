package bookmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

//启用springmvc
//配置DispatcherServlet上下文
@Configuration
@EnableWebMvc
@ComponentScan("bookmanager.web")//组件扫描

public class WebConfig  extends WebMvcConfigurerAdapter{
    //配置jsp视图解析器
  /*  @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }*/
  @Bean
    public ITemplateResolver templateResolver(){
         SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
         templateResolver.setPrefix("/WEB-INF/view/");
         templateResolver.setSuffix(".html");
         templateResolver.setTemplateMode("HTML5");
         templateResolver.setCharacterEncoding("UTF-8");
         return templateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(ITemplateResolver templateResolver){
      SpringTemplateEngine templateEngine=new SpringTemplateEngine();
      templateEngine.setTemplateResolver(templateResolver);
      return  templateEngine;
    }
    @Bean
    public ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("WEB-INF/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("WEB-INF/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("WEB-INF/js/").setCachePeriod(31556926);
        registry.addResourceHandler("/fonts/**").addResourceLocations("WEB-INF/fonts/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("WEB-INF/img/").setCachePeriod(31556926);
    }

    //用默认的servlet来处理静态资源

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }
}
