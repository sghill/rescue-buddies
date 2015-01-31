package net.sghill.rescuebuddies.jdbi;

import net.sghill.rescuebuddies.core.Buddy;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class BuddyMapper implements ResultSetMapper<Buddy> {
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String BIRTH_DATE = "birth_date";
    public static final String CREATED = "created";
    public static final String LAST_MODIFIED = "last_modified";

    public Buddy map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Buddy(
                UUID.fromString(r.getString(ID)),
                r.getString(NAME),
                LocalDate.parse(r.getString(BIRTH_DATE)),
                DateTime.parse(r.getString(CREATED)),
                DateTime.parse(r.getString(LAST_MODIFIED)));
    }
}

