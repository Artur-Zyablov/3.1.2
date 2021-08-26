package spring.crud.security.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity<abs extends Number> implements Persistable<abs> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private abs id;

    @Nullable
    @Override
    public abs getId() {
        return id;
    }

    public void setId(@Nullable abs id) {
        this.id = id;
    }

    @Transient
    @Override
    public boolean isNew() {
        return null == getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity<?> that = (AbstractEntity<?>) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }
}

//package spring.crud.security.model;
//
//        import javax.persistence.GeneratedValue;
//        import javax.persistence.GenerationType;
//        import javax.persistence.Id;
//        import javax.persistence.MappedSuperclass;
//        import java.io.Serializable;
//
//@MappedSuperclass
//public class AbstractEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    protected Long id;
//
//    public boolean persisted() {
//        return id != null;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    @Override
//    public int hashCode() {
//        if (getId() != null) {
//            return getId().hashCode();
//        }
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        AbstractEntity other = (AbstractEntity) obj;
//        if (getId() == null || other.getId() == null) {
//            return false;
//        }
//        return getId().equals(other.getId());
//    }
//}

