package com.emilabs.kubernetes.bookmarker.domain;

import com.emilabs.kubernetes.bookmarker.domain.projection.BookmarkProjectionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

  @Query("select new com.emilabs.kubernetes.bookmarker.domain.projection.BookmarkProjectionDTO(b.id, b.title, b.url, b.createdAt) from Bookmark b")
  Page<BookmarkProjectionDTO> findBookmarks(Pageable pageable);
}
