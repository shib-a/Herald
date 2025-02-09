package com.herald.service.Service.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {
    private Long id;
    private Long personId;
    private boolean isMain = true;
    private String socialNetwork;
    private String socialNetworkId;
    private String language;
    private List<Long> eventIds;
    private List<Long> organizerIds;
}
