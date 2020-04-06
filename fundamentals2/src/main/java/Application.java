import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static  void main (String... args){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

      //  SpeakerService service = new SpeakerServiceImpl();


        SpeakerService service = ctx.getBean("getSpeakerServiceAutoWired",SpeakerService.class);
//        SpeakerService service2 = ctx.getBean("speakerServiceConstructor",SpeakerService.class);

        //print object addresses to test if singleton/prototype scope works
        //System.out.println(service);
        System.out.println(service.findAll().get(0).getFirstName());
        //System.out.println(service2);

        //singleton prints same address because we get only one bean from the container
        //prototype prints different addresses because we get more than one bean from the container

    }
}
