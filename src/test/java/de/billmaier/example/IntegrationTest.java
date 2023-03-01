package de.billmaier.example;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation that combines the Annotations that are usually needed for an integration test:
 * <ul>
 * <li>{@link SpringBootTest}</li>
 * <li>{@link ActiveProfiles} with profile "test"</li>
 * </ul>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SpringBootTest
@ActiveProfiles({"test"})
public @interface IntegrationTest
{
}
