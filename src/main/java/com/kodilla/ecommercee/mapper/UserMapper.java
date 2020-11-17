
package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private OrderMapper orderMapper;
    private InvoiceMapper invoiceMapper;

    @Autowired
    public UserMapper(OrderMapper orderMapper, InvoiceMapper invoiceMapper) {
        this.orderMapper = orderMapper;
        this.invoiceMapper = invoiceMapper;
    }

    public User mapToUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getUsername(),
                userDto.getStatus(),
                userDto.getUserKey(),
                userDto.getCart(),
                orderMapper.mapToOrderList(userDto.getOrders()),
                invoiceMapper.mapToInvoiceList(userDto.getInvoices()
                ));
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                user.getUsername(),
                user.getStatus(),
                user.getUserKey(),
                user.getCart(),
                orderMapper.mapToOrderDtoList(user.getOrders()),
                invoiceMapper.mapToInvoiceDtoList(user.getInvoices()
                ));
    }

    public List<UserDto> mapToUserDtoList(List<User> users) {
        return users.stream()
                .map(u -> new UserDto(u.getId(),
                        u.getUsername(),
                        u.getStatus(),
                        u.getUserKey(),
                        u.getCart(),
                        orderMapper.mapToOrderDtoList(u.getOrders()),
                        invoiceMapper.mapToInvoiceDtoList(u.getInvoices())))
                .collect(Collectors.toList());
    }

    public List<User> mapToUserList(List<UserDto> users) {
        return users.stream()
                .map(u -> new User(u.getId(),
                        u.getUsername(),
                        u.getStatus(),
                        u.getUserKey(),
                        u.getCart(),
                        orderMapper.mapToOrderList(u.getOrders()),
                        invoiceMapper.mapToInvoiceList(u.getInvoices())))
                .collect(Collectors.toList());
    }

}