package com.duman.springproject.dao;

import com.duman.springproject.dto.SocialMediaDto;
import com.duman.springproject.dto.SubscriberDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class SocialMediaDao implements IDAOImplements<SocialMediaDto>{

    @Override
    public void insert(SocialMediaDto socialMediaDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "Insert into social_media(social_media_id,social_media_name,social_media_icon,social_media_url,creation_date) values (?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, socialMediaDto.getSocialMediaId());
            pstmt.setString(2, socialMediaDto.getSocialMediaName());
            pstmt.setBytes(3, socialMediaDto.getSocialMediaIcon());
            pstmt.setString(4, socialMediaDto.getSocialMediaUrl());
            pstmt.setDate(5, socialMediaDto.getCreationDate());
            int rowEffected = pstmt.executeUpdate();
            if (rowEffected > 0) {
                log.info("Insert completed!");
            } else {
                log.error("Failure!!");
            }
        } catch (Exception e) {
            log.error("Insert not completed because of --> " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(SocialMediaDto socialMediaDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "update social_media set social_media_name = ?,social_media_icon = ?"
                    + ",social_media_url = ?,creation_date = ? where social_media_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, socialMediaDto.getSocialMediaName());
            pstmt.setBytes(2, socialMediaDto.getSocialMediaIcon());
            pstmt.setString(3, socialMediaDto.getSocialMediaUrl());
            pstmt.setDate(4, socialMediaDto.getCreationDate());
            pstmt.setLong(5, socialMediaDto.getSocialMediaId());
            int rowEffected = pstmt.executeUpdate();
            if (rowEffected > 0) {
                log.info("Update Succeded!");
            } else {
                log.error("Failure while update!!");
            }
        } catch (Exception e) {
            log.error("Update not completed because of --> " + e.getMessage() );
            e.printStackTrace();
        }
    }

    @Override
    public void delete(SocialMediaDto socialMediaDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "delete from social_media where social_media_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, socialMediaDto.getSocialMediaId());
            int rowEffected = pstmt.executeUpdate();
            if (rowEffected > 0) {
                log.info("Delete is succeded!");
            } else {
                log.error("Delete is not completed!!");
            }
        } catch (Exception e) {
            log.error(" Failure while delete --> " + e.getMessage() );
            e.printStackTrace();
        }
    }

    @Override
    public List<SocialMediaDto> listing() {
        List<SocialMediaDto> list2 = new ArrayList<>();
        SocialMediaDto socialMediaDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "Select * from social_media";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                socialMediaDto = new SocialMediaDto();
                socialMediaDto.setSocialMediaId(rs.getLong("social_media_id"));
                socialMediaDto.setSocialMediaName(rs.getString("social_media_name"));
                socialMediaDto.setSocialMediaIcon(rs.getBytes("social_media_icon"));
                socialMediaDto.setSocialMediaUrl(rs.getString("social_media_url"));
                socialMediaDto.setCreationDate(rs.getDate("creation_date"));
                list2.add(socialMediaDto);
            }
            log.info("Listing succeded!!");
        } catch (Exception e) {
            System.out.println(" An error occured while listing of objects --> " + e.getMessage());
            e.printStackTrace();
        }
        return list2;
    }
}
