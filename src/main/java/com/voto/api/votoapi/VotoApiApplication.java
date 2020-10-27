@ComponentScan({"com.api.voto.service","com.api.voto","com.api.voto.controllers"})
@EnableReactiveMongoRepositories({"com.api.voto"})
@SpringBootApplication
public class VotoApiApplication {

	public static void main(String[] args) {		
		SpringApplication.run(VotoApiApplication.class, args);		
	}

}
