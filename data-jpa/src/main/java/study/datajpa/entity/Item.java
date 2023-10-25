package study.datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import org.springframework.data.domain.Persistable;

@Entity
@Getter
public class Item implements Persistable<String> {
    @Id
    private String id;

    @Override
    public boolean isNew() {
        return false;
    }
}
