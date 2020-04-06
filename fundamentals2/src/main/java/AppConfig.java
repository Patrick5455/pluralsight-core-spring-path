import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {


    //setter injection
    @Bean(name = "speakerService")
    public SpeakerService getSpeakerService(){

       SpeakerServiceImpl service = new SpeakerServiceImpl();
       service.setRepository(getSpeakerRepository());
       return service;
    }

    //constructor injection
    @Bean(name = "speakerServiceConstructor")
    //@Scope(value = "singleton")
    //@Scope(value = BeanDefinition.SCOPE_SINGLETON)
    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getSpeakerService2(){

        SpeakerService service = new SpeakerServiceImpl(getSpeakerRepository());
        return service;
    }


    // create repository
    @Bean(name = "speakerRepository")
    public SpeakerRepository getSpeakerRepository(){
        return new HibernateSpeakerRepositoryImpl();
    }

}
