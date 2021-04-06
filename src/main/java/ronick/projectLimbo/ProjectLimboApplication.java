package ronick.projectLimbo;
/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectLimboApplication {

	public static void main(String[] args) {
		//System.out.println("Hello, world!");
		SpringApplication.run(ProjectLimboApplication.class, args);
	}
}
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//War
@SpringBootApplication
public class ProjectLimboApplication extends  SpringBootServletInitializer{

    @Override
    protected  SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(ProjectLimboApplication.class);
    }

    public static void main(String[] args){
        SpringApplication.run(ProjectLimboApplication.class, args);
    }
}

