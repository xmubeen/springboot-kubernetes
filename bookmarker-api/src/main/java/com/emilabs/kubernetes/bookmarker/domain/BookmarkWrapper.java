package com.emilabs.kubernetes.bookmarker.domain;

import com.emilabs.kubernetes.bookmarker.domain.projection.BookmarkProjectionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BookmarkWrapper {

  public BookmarkProjectionDTO toDTO(Bookmark bookmark) {
    BookmarkProjectionDTO dto = new BookmarkProjectionDTO();
    BeanUtils.copyProperties(bookmark, dto);
    return dto;
  }

}
