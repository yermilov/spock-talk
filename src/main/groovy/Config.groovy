import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Config {

    @Bean
    PasswordGenerator passwordGenerator() {
        new PasswordGenerator(alphabet: alphabet(), random: random())
    }

    @Bean
    String alphabet() {
        ('a'..'z').join()
    }

    @Bean
    Random random() {
        new Random()
    }
}
