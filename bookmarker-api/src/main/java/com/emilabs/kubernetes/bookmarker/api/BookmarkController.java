package com.emilabs.kubernetes.bookmarker.api;

import com.emilabs.kubernetes.bookmarker.api.payload.request.CreateBookmarkRequest;
import com.emilabs.kubernetes.bookmarker.api.payload.response.BookmarkDTO;
import com.emilabs.kubernetes.bookmarker.domain.BookmarkService;
import com.emilabs.kubernetes.bookmarker.domain.projection.BookmarkProjectionDTO;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

  private final BookmarkService bookmarkService;

  @GetMapping
  public BookmarkDTO getBookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page,
      @RequestParam(name = "query", required = false, defaultValue = "") String query) {
    if(query == null || query.trim().length() == 0) {
      return bookmarkService.getBookmarks(page);
    }
    return bookmarkService.searchBookmarks(query, page);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public BookmarkProjectionDTO createBookmark(@RequestBody @Valid CreateBookmarkRequest request) {
    return bookmarkService.createBookmark(request);
  }
}
