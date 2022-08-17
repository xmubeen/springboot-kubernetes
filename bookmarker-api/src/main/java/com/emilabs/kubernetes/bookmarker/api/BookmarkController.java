package com.emilabs.kubernetes.bookmarker.api;

import com.emilabs.kubernetes.bookmarker.domain.BookmarkDTO;
import com.emilabs.kubernetes.bookmarker.domain.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

  private final BookmarkService bookmarkService;

  @GetMapping
  public BookmarkDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
    return bookmarkService.getBookmarks(page);
  }
}
