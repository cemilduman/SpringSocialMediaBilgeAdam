package com.duman.springproject.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;


@Getter @Setter
@ToString
@EqualsAndHashCode
//@Builder
public class SocialMediaDto implements Serializable {
    private static final long serialVersionUID = -7193894119291853223L;

    private long SocialMediaId;
    private String socialMediaName;
    private byte[] socialMediaIcon;
    private String socialMediaUrl;
    private Date creationDate;

    public SocialMediaDto() {
    }

    public SocialMediaDto(long socialMediaId, String socialMediaName, byte[] socialMediaIcon, String subScriberUrl) {
        SocialMediaId = socialMediaId;
        this.socialMediaName = socialMediaName;
        this.socialMediaIcon = socialMediaIcon;
        this.socialMediaUrl = subScriberUrl;
    }
}
