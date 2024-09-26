package com.hyperprof.curso.core.services.storage.providers.s3;

import com.amazonaws.regions.Regions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class S3ConfigProperties {

    @Value("${ACCESS_KEY}")
    private String accessKey;

    @Value("${SECRET_KEY}")
    private String secretKey;

    @Value("${BUCKET_NAME}")
    private String bucketName;

    @Value("${REGION}")
    private Regions region;

}
