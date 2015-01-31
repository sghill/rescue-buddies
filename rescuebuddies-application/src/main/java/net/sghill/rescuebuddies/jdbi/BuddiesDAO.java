package net.sghill.rescuebuddies.jdbi;

import net.sghill.rescuebuddies.core.Buddy;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.UUID;

@RegisterMapper(BuddyMapper.class)
public interface BuddiesDAO {
    @SqlUpdate("insert into buddies (id, name, birth_date, created, last_modified) values (:id, :name, :birthDate, :created, :lastModified)")
    void create(@BindBean Buddy buddy);

    @SqlQuery("select * from buddies where id = :id")
    Buddy findById(@Bind("id") UUID id);

}
