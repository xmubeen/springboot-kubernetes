package com.emilabs.kubernetes.bookmarker.domain;

import com.emilabs.kubernetes.bookmarker.domain.projection.BookmarkProjectionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
  private final BookmarkRepository repository;
  private final BookmarkWrapper bookmarkWrapper;

  @Transactional(readOnly = true)
  public BookmarkDTO getBookmarks(Integer page) {
    int pageNo = page < 1 ? 0 : page -1;
    Pageable pageable = PageRequest.of(pageNo, 10, Sort.Direction.DESC, "createdAt");
    Page<BookmarkProjectionDTO> bookmarkPage = repository.findBookmarks(pageable);
    return new BookmarkDTO(bookmarkPage);
  }
}
