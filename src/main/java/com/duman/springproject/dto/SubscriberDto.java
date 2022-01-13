package com.duman.springproject.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;


@Getter @Setter
@Builder
@EqualsAndHashCode
@ToString
public class SubscriberDto implements Serializable {
    private static final long serialVersionUID = 7763538129354344472L;

    private long subscriberId;
    private String subscriberName;
    private String subscriberSurname;
    private String subscriberAdress;
    private Date creationDate;

    public SubscriberDto() {
    }

    public SubscriberDto(long subcriberId, String subsriberName, String subscriberSurname, String subscriberAdress, Date creationDate){
        this.subscriberId = subcriberId;
        this.subscriberName = subsriberName;
        this.subscriberSurname = subscriberSurname;
        this.subscriberAdress = subscriberAdress;
        this.creationDate = creationDate;
    }
}
