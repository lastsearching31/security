package com.teperikov.security.auditing;

import com.teperikov.security.dto.user.User;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class ApplicationAuditAware implements AuditorAware<Integer> {

  @Override
  public Optional<Integer> getCurrentAuditor() {
    final var authentication =
        SecurityContextHolder
            .getContext()
            .getAuthentication();
    if (authentication == null ||
        !authentication.isAuthenticated() ||
        authentication instanceof AnonymousAuthenticationToken
    ) {
      return Optional.empty();
    }

    final var userPrincipal = (User) authentication.getPrincipal();
    return Optional.ofNullable(userPrincipal.getId());
  }
}
