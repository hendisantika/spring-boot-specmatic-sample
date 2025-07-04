package id.my.hendisantika.specmaticsample;

import id.my.hendisantika.specmaticsample.model.DB;
import io.ktor.server.application.Application;
import io.specmatic.test.SpecmaticContractTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-specmatic-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 04/07/25
 * Time: 07.03
 * To change this template use File | Settings | File Templates.
 */
public class ContractTest implements SpecmaticContractTest {
    private static final String EXCLUDED_ENDPOINTS = "'/internal/metrics'";
    private static ConfigurableApplicationContext context;

    @BeforeAll
    public static void setUp() {
        System.setProperty("host", "localhost");
        System.setProperty("port", "8090");
        System.setProperty("SPECMATIC_GENERATIVE_TESTS", "true");
        System.setProperty("SPECMATIC_TEST_PARALLELISM", "auto");
        System.setProperty("filter", String.format("PATH!=%s", EXCLUDED_ENDPOINTS));

        DB.INSTANCE.resetDB();

        context = SpringApplication.run(Application.class);
    }

    @AfterAll
    public static void tearDown() {
        context.close();
    }
}