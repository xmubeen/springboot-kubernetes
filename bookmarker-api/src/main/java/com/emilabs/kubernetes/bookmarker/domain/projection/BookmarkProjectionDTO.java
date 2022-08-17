package com.emilabs.kubernetes.bookmarker.domain.projection;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkProjectionDTO {
  private Long id;
  private String title;
  private String url;
  private Instant createdAt;
}


