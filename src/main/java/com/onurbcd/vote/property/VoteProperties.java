package com.onurbcd.vote.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties("vote")
@Configuration("voteProperties")
@Getter
@Setter
public class VoteProperties {

    private Integer minSessionDuration;
}
