package com.bookstore.jpa.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDto(String title,
                            UUID publishedId,
                            Set<UUID> authorIds,
                            String reviewComments) {

}
