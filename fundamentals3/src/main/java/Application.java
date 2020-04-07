import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static  void main (String... args){

        ApplicationContext ctx =  new ClassPathXmlApplicationContext ("applicationContext.xml");

        SpeakerService service = ctx.getBean("speakerService", SpeakerServiceImpl.class);

        System.out.println(service.findAll().get(0).getFirstName());

    }
}
