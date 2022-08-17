package com.emilabs.kubernetes.bookmarker.domain;

import com.emilabs.kubernetes.bookmarker.domain.projection.BookmarkProjectionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class BookmarkDTO {
  private List<BookmarkProjectionDTO> data;
  private long totalElements;
  private int totalPages;
  private int currentPage;
  @JsonProperty("isFirst")
  private boolean isFirst;
  @JsonProperty("isLast")
  private boolean isLast;
  private boolean hasNext;
  private boolean hasPrevious;

  public BookmarkDTO(Page<BookmarkProjectionDTO> bookmarkPage) {
    this.setData(bookmarkPage.getContent());
    this.setTotalElements(bookmarkPage.getTotalElements());
    this.setTotalPages(bookmarkPage.getTotalPages());
    this.setCurrentPage(bookmarkPage.getNumber() + 1);
    this.setFirst(bookmarkPage.isFirst());
    this.setLast(bookmarkPage.isLast());
    this.setHasNext(bookmarkPage.hasNext());
    this.setHasPrevious(bookmarkPage.hasPrevious());
  }
}
