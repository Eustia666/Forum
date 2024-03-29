package cn.chonglang.forum.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
             //   .apis(RequestHandlerSelectors.any())
             //   .apis(RequestHandlerSelectors.basePackage("cn.niter.forum.api"))
                .apis(RequestHandlerSelectors.basePackage("cn.chonglang.forum.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("ChonglangForum API Doc")
                .description("This is a restful api document of ChonglangForum.")
                .contact(new Contact("赵卫峰","chonglang.cn","664867792@qq.com"))
                .version("1.0")
                .build();
    }

}
