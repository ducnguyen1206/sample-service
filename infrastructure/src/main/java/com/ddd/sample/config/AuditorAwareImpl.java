package com.ddd.sample.config;

import com.ddd.sample.utils.SecurityUtils;
import com.ddd.sample.constant.HeaderConstant;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private HttpServletRequest requestHeader;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(SecurityUtils.getUser(requestHeader.getHeader(HeaderConstant.REQUEST_JWT)));
    }
}
