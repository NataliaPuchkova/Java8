package org.cdb.systems.foo;

import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class HashCodeEqualsExample  {

    private static final long      serialVersionUID = 7467719680182249825L;
    private final UUID             id;
    private final Object           field1;
    private final Object           field2;

   
    public HashCodeEqualsExample( UUID id,
                Object field1,
                Object field2) {
        this.id = id;
        this.field1 = field1;
        this.field2 = field2;
    }

    public UUID getId() {
        return id;
    }

    public Object getField1() {
        return field1;
    }

    public Object getField2() {
        return field2;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
