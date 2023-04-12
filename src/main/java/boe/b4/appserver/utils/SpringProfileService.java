package boe.b4.appserver.utils;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class SpringProfileService {
    private static final Logger logger = LoggerFactory.getLogger(SpringProfileService.class);

    public static final String PRODUCTION_PROFILE = "production";

    @Value("${spring.profiles.active}")
    private String profile;
}