package net.sghill.rescuebuddies;

import io.dropwizard.db.DataSourceFactory;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RescueBuddiesDatabaseConfigurationTest {

    @Test
    public void shouldParseH2InMemoryUrl() {
        // Given
        String url = "jdbc:h2:mem:";

        // When
        DataSourceFactory database = RescueBuddiesDatabaseConfiguration.create(url);

        // Then
        assertThat(database.getUrl()).isEqualTo(url);
        assertThat(database.getDriverClass()).isEqualTo("org.h2.Driver");
        assertThat(database.getUser()).isNullOrEmpty();
        assertThat(database.getPassword()).isNullOrEmpty();
    }

    @Test
    public void shouldParsePostgresUrl() {
        // Given
        String url = "postgres://user:pass@localhost:5432/rescuebuddies";

        // When
        DataSourceFactory database = RescueBuddiesDatabaseConfiguration.create(url);

        // Then
        assertThat(database.getUrl()).isEqualTo("jdbc:postgresql://localhost:5432/rescuebuddies");
        assertThat(database.getUser()).isEqualTo("user");
        assertThat(database.getPassword()).isEqualTo("pass");
        assertThat(database.getDriverClass()).isEqualTo("org.postgresql.Driver");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentIfUnknown() {
        // Given
        String url = "mysql://user:pass@localhost:10000/db";

        // When
        RescueBuddiesDatabaseConfiguration.create(url);

        // Then IllegalArgumentException
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentIfNotURI() {
        // Given
        String notUrl = "Baldwin Consolidation 2-8-8-0";

        RescueBuddiesDatabaseConfiguration.create(notUrl);

        // Then IllegalArgumentException
    }
}
