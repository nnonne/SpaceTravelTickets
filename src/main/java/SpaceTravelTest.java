import org.flywaydb.core.Flyway;
import util.HibernateUtil;
import services.ClientCrudService;
import services.PlanetCrudService;

import java.util.ResourceBundle;

public class SpaceTravelTest {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("hibernate");
    private static final String JDBC_URL = "hibernate.connection.url";

    public static void main(String[] args) {
        Flyway.configure()
                .dataSource(resourceBundle.getString(JDBC_URL), null, null)
                .load()
                .migrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        clientCrudService.create("Katie");
        System.out.println(clientCrudService.getById(1));
        System.out.println(clientCrudService.getById(10));
        System.out.println(clientCrudService.getById(11));
        clientCrudService.update(5, "Linda");
        System.out.println(clientCrudService.listAll());
        clientCrudService.deleteById(5);
        System.out.println(clientCrudService.listAll());


        PlanetCrudService planetCrudService = new PlanetCrudService();
        planetCrudService.create("PLANET6", "NEPTUNE");
        System.out.println(planetCrudService.getById("PLANET1"));
        System.out.println(planetCrudService.getById("PLANET5"));
        System.out.println(planetCrudService.getById("PLANET6"));
        planetCrudService.update("PLANET5", "PLUTO");
        System.out.println(planetCrudService.listAll());
        planetCrudService.deleteById("PLANET3");
        System.out.println(planetCrudService.listAll());
        HibernateUtil.getInstance().close();
    }

}
