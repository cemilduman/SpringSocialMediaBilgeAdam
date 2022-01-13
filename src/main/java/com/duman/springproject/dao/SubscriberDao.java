package com.duman.springproject.dao;

import com.duman.springproject.dto.SubscriberDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class SubscriberDao implements IDAOImplements<SubscriberDto>{

    @Override
    public void insert(SubscriberDto subscriberDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "Insert into subscriber(subscriber_id,subscriber_name,subscriber_surname,subscriber_adress,creation_date) values (?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, subscriberDto.getSubscriberId());
            pstmt.setString(2, subscriberDto.getSubscriberName());
            pstmt.setString(3, subscriberDto.getSubscriberSurname());
            pstmt.setString(4, subscriberDto.getSubscriberAdress());
            pstmt.setDate(5, subscriberDto.getCreationDate());
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
    public void update(SubscriberDto subscriberDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "update subscriber set subscriber_name = ?,subscriber_surname = ?"
                    + ",subscriber_adress = ?,creation_date = ? where subscriber_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, subscriberDto.getSubscriberName());
            pstmt.setString(2, subscriberDto.getSubscriberSurname());
            pstmt.setString(3, subscriberDto.getSubscriberAdress());
            pstmt.setDate(4, subscriberDto.getCreationDate());
            pstmt.setLong(5, subscriberDto.getSubscriberId());
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
    public void delete(SubscriberDto subscriberDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "delete from subscriber where subscriber_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, subscriberDto.getSubscriberId());
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
    public List<SubscriberDto> listing() {
        List<SubscriberDto> list2 = new ArrayList<>();
        SubscriberDto subscriberDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "Select * from subscriber";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                subscriberDto = new SubscriberDto();
                subscriberDto.setSubscriberId(rs.getLong("subscriber_id"));
                subscriberDto.setSubscriberName(rs.getString("subscriber_name"));
                subscriberDto.setSubscriberSurname(rs.getString("subscriber_surname"));
                subscriberDto.setSubscriberAdress(rs.getString("subscriber_adress"));
                subscriberDto.setCreationDate(rs.getDate("creation_date"));
                list2.add(subscriberDto);
            }
            log.info("Listing succeded!!");
        } catch (Exception e) {
            System.out.println(" An error occured while listing of objects --> " + e.getMessage());
            e.printStackTrace();
        }
        return list2;
    }

    public static void main(String[] args) {
        SubscriberDao dao = new SubscriberDao();
        SubscriberDto dto = SubscriberDto.builder().
                subscriberName("Cemil").
                subscriberSurname("BaskaDuman").
                subscriberAdress("Pendik").
                subscriberId(1L).
                creationDate(new Date(System.currentTimeMillis())).build();

        dao.delete(dto);
    }

}
