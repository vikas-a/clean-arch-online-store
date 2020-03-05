package org.learn.store;

import org.learn.store.gateways.CartGateway;
import org.learn.store.gateways.InventoryGateway;
import org.learn.store.gateways.cart.nosql.NoSqlCartGateway;
import org.learn.store.gateways.product.nosql.NoSQLInventoryGateway;
import org.learn.store.usecases.addToCart.AddToCartUseCase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableConfigurationProperties
@EnableAutoConfiguration
@EnableSwagger2
@SpringBootApplication
public class OnlineStoreApplication {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build();
  }

  @Bean
  protected AddToCartUseCase addToCartUseCase() {
    AddToCartUseCase useCase = new AddToCartUseCase();
    useCase.setCartGateway(cartGateway());
    useCase.setInventoryGateway(inventoryGateway());
    return useCase;
  }

  @Bean
  protected CartGateway cartGateway() {
    return new NoSqlCartGateway();
  }

  @Bean
  protected InventoryGateway inventoryGateway() {
    return new NoSQLInventoryGateway();
  }

  public static void main(String[] args) {
    SpringApplication.run(OnlineStoreApplication.class, args);
  }
}
