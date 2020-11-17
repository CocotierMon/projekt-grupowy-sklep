package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {
    ProductMapper productMapper;

    public GroupDto mapToGroupDto(Group group) {
        return new GroupDto(group.getId(),
                group.getGroupName(),
                productMapper.mapToProductDtoList(group.getProductsList()));
    }

    public Group mapToGroup(GroupDto groupDto) {
        return new Group(groupDto.getId(),
                groupDto.getGroupName(),
                productMapper.mapToProductList(groupDto.getProductsList()));
    }

    public List<GroupDto> mapToGroupsListDto(List<Group> groups) {
        return groups.stream()
                .map(g -> new GroupDto(g.getId(),
                        g.getGroupName(),
                        productMapper.mapToProductDtoList(g.getProductsList())))
                .collect(Collectors.toList());
    }

    public List<Group> mapToGroupsList(List<GroupDto> groups) {
        return groups.stream()
                .map(g -> new Group(g.getId(),
                        g.getGroupName(),
                        productMapper.mapToProductList(g.getProductsList())))
                .collect(Collectors.toList());
    }


}